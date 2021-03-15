package com.boada.unmsm.exam.service;

import com.boada.unmsm.exam.entity.Producto;
import com.boada.unmsm.exam.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Optional<Producto> findByPartNumber(String parNumber) {
        return productoRepository.findByPartNumber(parNumber);
    }

    public List<Producto> list() {
        return productoRepository.findAll();
    }

    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    public boolean existsByPartNumber(String partNumber) {
        return productoRepository.existsByPartNumber(partNumber);
    }

    @Transactional
    public Optional<Integer> deleteByPartNumber(String partNumber) {
        return productoRepository.deleteByPartNumber(partNumber);
    }
}
