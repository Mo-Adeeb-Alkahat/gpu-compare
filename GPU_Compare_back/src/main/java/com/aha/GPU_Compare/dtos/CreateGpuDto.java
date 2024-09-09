package com.aha.GPU_Compare.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGpuDto {
//must be the same as the post request
    public String manufacturer;
    public String productName;
    public int releaseYear;
    public int memSize;
    public int memBusWidth;
    public int gpuClock;
    public int memClock;
    public int unifiedShader;
    public int tmu;
    public int rop;
    public String pixelShader;
    public String vertexShader;
    public String igp;
    public String bus;
    public String memType;
    public String gpuChip;
}
