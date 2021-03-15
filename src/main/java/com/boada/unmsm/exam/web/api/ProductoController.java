package com.boada.unmsm.exam.web.api;

import com.boada.unmsm.exam.entity.Producto;
import com.boada.unmsm.exam.exception.PartNumberNotFoundException;
import com.boada.unmsm.exam.exception.ProductsNotFoundException;
import com.boada.unmsm.exam.exception.SamePartNumberException;
import com.boada.unmsm.exam.exception.TypeProductNotFoundException;
import com.boada.unmsm.exam.service.ProductoService;
import com.boada.unmsm.exam.strategy.TypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Producto producto) {
        validateProduct(producto);
        validateTypeProduct(producto);
        validateQuantityComponents(producto);
        productoService.save(producto);
    }

    private void validateProduct(Producto producto) {
        Optional.of(producto)
                .filter(p -> !productoService.existsByPartNumber(p.getPartNumber()))
                .orElseThrow(() -> new SamePartNumberException("El PartNumber " + producto.getPartNumber() + " ya está registrado."));
    }

    private void validateTypeProduct(Producto producto) {

        try {
            TypeProduct.valueOf(producto.getTipoProducto());
        } catch (IllegalArgumentException e) {
            throw new TypeProductNotFoundException("El tipo de producto debe ser Normal o Paquete.");
        }
    }

    private void validateQuantityComponents(Producto producto) {
        TypeProduct.valueOf(producto.getTipoProducto()).validateType(producto.getCantidadComponentes(), producto.getPartNumber());
    }

    @GetMapping("/{partNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Producto getByPartNumber(@PathVariable("partNumber") String partNumber) {

        return productoService.findByPartNumber(partNumber)
                .orElseThrow(() -> new PartNumberNotFoundException(""));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> list() {

        return Optional.of(productoService.list())
                .filter(list -> list.size() > 0)
                .orElseThrow(() -> new ProductsNotFoundException(""));
    }

    @DeleteMapping("/{partNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("partNumber") String partNumber) {

        productoService.deleteByPartNumber(partNumber)
                .filter(rows -> rows > 0)
                .orElseThrow(() -> new PartNumberNotFoundException(""));
    }
}
