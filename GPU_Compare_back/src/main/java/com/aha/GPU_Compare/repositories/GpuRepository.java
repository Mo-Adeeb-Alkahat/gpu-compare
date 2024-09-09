package com.aha.GPU_Compare.repositories;

import com.aha.GPU_Compare.models.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GpuRepository extends JpaRepository<Gpu,Integer> {
    Optional<Gpu> findOneByProductName (String productName);
}
