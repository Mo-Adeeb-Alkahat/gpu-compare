package com.aha.GPU_Compare.services;

import com.aha.GPU_Compare.dtos.CreateGpuDto;
import com.aha.GPU_Compare.dtos.FilterGpuDto;
import com.aha.GPU_Compare.models.Gpu;
import com.aha.GPU_Compare.repositories.GpuRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GpuService  {

private EntityManager em;
    private GpuRepository gpuRepository ;

    public GpuService(GpuRepository gpuRepository , EntityManager em) {
        this.gpuRepository = gpuRepository;
        this.em=em;
    }

    public List<Gpu> getAll() {

        List<Gpu> gpus = this.gpuRepository.findAll();
        return gpus;

    }


    public Gpu getOne( int id) {

    Optional<Gpu> gpu = this.gpuRepository.findById(id);
    return gpu.orElse(null);

    }

    public Gpu getOneByName( String productName) {

        Optional<Gpu> gpu = this.gpuRepository.findOneByProductName(productName);
        return gpu.orElse(null);

    }

    public void addGpu(CreateGpuDto createGpuDto) {


        Gpu gpu = new Gpu( createGpuDto.manufacturer,
                createGpuDto.productName,
                createGpuDto.releaseYear,
                createGpuDto.memSize,
                createGpuDto.memBusWidth,
                createGpuDto.gpuClock,
                createGpuDto.memClock,
                createGpuDto.unifiedShader,
                createGpuDto.tmu,
                createGpuDto.rop,
                createGpuDto.pixelShader,
                createGpuDto.vertexShader,
                createGpuDto.igp,
                createGpuDto.bus,
                createGpuDto.memType,
                createGpuDto.gpuChip);
                this.gpuRepository.save(gpu);
    }


    public void modifyGpu(int id, CreateGpuDto createGpuDto) {

        Gpu gpu = new Gpu( createGpuDto.manufacturer,
                createGpuDto.productName,
                createGpuDto.releaseYear,
                createGpuDto.memSize,
                createGpuDto.memBusWidth,
                createGpuDto.gpuClock,
                createGpuDto.memClock,
                createGpuDto.unifiedShader,
                createGpuDto.tmu,
                createGpuDto.rop,
                createGpuDto.pixelShader,
                createGpuDto.vertexShader,
                createGpuDto.igp,
                createGpuDto.bus,
                createGpuDto.memType,
                createGpuDto.gpuChip);
        gpu.setId(id);

        this.gpuRepository.save(gpu);

    }

    public String deleteOne(int id) {

        this.gpuRepository.deleteById(id);


        return "deleted";
    }

    public ArrayList<Gpu> filter(FilterGpuDto filterGpuDto) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery query = criteriaBuilder.createQuery(Gpu.class);
        Root<Gpu> root = query.from(Gpu.class);
        List<Predicate> predicates = new ArrayList<>();

        if(filterGpuDto.manufacturer.isPresent() && filterGpuDto.minimumReleaseYear.isPresent()) {
            predicates.add(
                    criteriaBuilder.greaterThanOrEqualTo(root.get("releaseYear") , filterGpuDto.minimumReleaseYear.get())
            );
            predicates.add(criteriaBuilder.like(root.get("manufacturer"),"%"+filterGpuDto.manufacturer.get()+"%"));

        }
        query.where(predicates.toArray(new Predicate[predicates.size()
                ]));
        return (ArrayList<Gpu>) em.createQuery(query).getResultList();
    }
}
