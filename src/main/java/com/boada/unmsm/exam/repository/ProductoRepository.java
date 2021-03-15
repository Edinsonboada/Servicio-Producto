package com.boada.unmsm.exam.repository;

import com.boada.unmsm.exam.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    public Optional<Producto> findByPartNumber(String partNumber);

    public boolean existsByPartNumber(String partNumber);

    public Optional<Integer> deleteByPartNumber(String partNumber);
}
