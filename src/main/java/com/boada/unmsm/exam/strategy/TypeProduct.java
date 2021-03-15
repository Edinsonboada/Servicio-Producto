package com.boada.unmsm.exam.strategy;

import com.boada.unmsm.exam.exception.ComponentsQuantityException;

import java.util.Optional;

public enum TypeProduct {
    Paquete {
        @Override
        public void validateType(int cantidadComponentes, String partNumber) {
            Optional.of(cantidadComponentes)
                    .filter(c -> c > 0)
                    .orElseThrow(() -> new ComponentsQuantityException("El PartNumber "+partNumber+" es tipo Paquete, la cantidad de componentes no puede ser 0."));
        }
    }, Normal {
        @Override
        public void validateType(int cantidadComponentes, String partNumber) {
            Optional.of(cantidadComponentes)
                    .filter(c -> c == 0)
                    .orElseThrow(() -> new ComponentsQuantityException("El PartNumber "+partNumber+" es tipo Normal, la cantidad de componentes no puede ser mayor a 0."));
        }
    };

    public abstract void validateType(int cantidadComponentes, String partNumber);
}
