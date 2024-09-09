package com.aha.GPU_Compare.services;

import com.aha.GPU_Compare.dtos.CreateReviewDto;
import com.aha.GPU_Compare.models.Gpu;
import com.aha.GPU_Compare.models.Review;
import com.aha.GPU_Compare.repositories.ReviewRepositry;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {


    private GpuService gpuService;
    private ReviewRepositry reviewRepositry;

    public ReviewService(GpuService gpuService, ReviewRepositry reviewRepositry) {
        this.gpuService = gpuService;
        this.reviewRepositry = reviewRepositry;
    }

    public void addReview(CreateReviewDto createReviewDto) {

        Gpu gpu = this.gpuService.getOne(createReviewDto.gpu_id);
        if (gpu != null) {
            Review review = new Review(createReviewDto.description, createReviewDto.userName, gpu);
            reviewRepositry.save(review);
            return;
        }
        System.out.println("gpu not found");

    }
}
