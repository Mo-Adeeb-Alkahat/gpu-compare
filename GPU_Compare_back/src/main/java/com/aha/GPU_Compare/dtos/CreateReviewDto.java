package com.aha.GPU_Compare.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateReviewDto {
    public String description;
    public String userName;
    public int gpu_id;

}
