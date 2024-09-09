package com.aha.GPU_Compare.controllers;


import com.aha.GPU_Compare.dtos.CreateGpuDto;
import com.aha.GPU_Compare.dtos.FilterGpuDto;
import com.aha.GPU_Compare.models.Gpu;
import com.aha.GPU_Compare.services.GpuService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@ResponseBody
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/gpu")
public class GpuController {


    private GpuService gpuService;

    public GpuController(GpuService gpuService) {
        this.gpuService = gpuService;
    }

    @GetMapping("/all")
    public List<Gpu> getAllGpus() {
        return this.gpuService.getAll();
    }

    @GetMapping("/{id}")
    public Gpu getGpu(@PathVariable("id") int id) {
        return this.gpuService.getOne(id);
    }



    @PostMapping("/add")
    public String addGpu(@RequestBody CreateGpuDto createGpuDto) {
        this.gpuService.addGpu(createGpuDto);
                return "redirect:/gpu/all";
    }

    

    @PostMapping("/modify/{id}")
    public String modifyGpu(@PathVariable("id") int id , @RequestBody CreateGpuDto createGpuDto) {
        this.gpuService.modifyGpu(id,createGpuDto);
        return "redirect:/gpu/all";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGpu(@PathVariable("id") int id) {
         this.gpuService.deleteOne(id);
        return "deleted";
    }

    @GetMapping("/compare")
    public ArrayList<Gpu> compareGpus(@RequestParam String productName1 , @RequestParam String productName2) {

        System.out.println(productName2);

        Gpu gpu1 = this.gpuService.getOneByName(productName1);
        Gpu gpu2 = this.gpuService.getOneByName(productName2);


        ArrayList<Gpu> twoGpus = new ArrayList<>();
        twoGpus.add(gpu1);
        twoGpus.add(gpu2);

        return twoGpus ;



    }

    @PostMapping("/filter")
    public ArrayList<Gpu> filterGpus(@RequestBody FilterGpuDto filterGpuDto) {
        ArrayList<Gpu> filteredGpus = new ArrayList<>();
        filteredGpus.addAll(this.gpuService.filter(filterGpuDto));
        return  filteredGpus;
    }


}
