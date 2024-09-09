package com.aha.GPU_Compare.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterGpuDto {
    public Optional<String>  manufacturer;
    public Optional<Integer>  minimumReleaseYear;

}
