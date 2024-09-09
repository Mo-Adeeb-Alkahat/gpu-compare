package com.aha.GPU_Compare.controllers;


import com.aha.GPU_Compare.dtos.CreateReviewDto;
import com.aha.GPU_Compare.services.GpuService;
import com.aha.GPU_Compare.services.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/review")
public class ReviewController {
    private GpuService gpuService;
    private ReviewService reviewService;

    public ReviewController(GpuService gpuService, ReviewService reviewService) {
        this.gpuService = gpuService;
        this.reviewService = reviewService;
    }


    @PostMapping("/add-review")
    public String addReview(@RequestBody CreateReviewDto createReviewDto) {
        this.reviewService.addReview(createReviewDto);
        return "redirect:/gpu/" + createReviewDto.gpu_id;
    }
}
