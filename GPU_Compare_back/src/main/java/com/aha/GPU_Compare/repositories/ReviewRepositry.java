package com.aha.GPU_Compare.repositories;

import com.aha.GPU_Compare.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepositry extends JpaRepository<Review,Integer> {
}
