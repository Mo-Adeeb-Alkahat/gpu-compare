package com.aha.GPU_Compare.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name="gpu")
public class Gpu {




    private String manufacturer;
    private String productName;
    private int releaseYear;
    private int memSize;
    private int memBusWidth;
    private int gpuClock;
    private int memClock;
    private int unifiedShader;
    private int tmu;
    private int rop;
    private String pixelShader;
    private String vertexShader;
    private String igp;
    private String bus;
    private String memType;
    private String gpuChip;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY , mappedBy ="gpu" , cascade = CascadeType.ALL)
    private List<Review> reviews;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    public Gpu(String manufacturer, String productName, int releaseYear, int memSize, int memBusWidth, int gpuClock, int memClock, int unifiedShader, int tmu, int rop, String pixelShader, String vertexShader, String igp, String bus, String memType, String gpuChip) {
        this.manufacturer = manufacturer;
        this.productName = productName;
        this.releaseYear = releaseYear;
        this.memSize = memSize;
        this.memBusWidth = memBusWidth;
        this.gpuClock = gpuClock;
        this.memClock = memClock;
        this.unifiedShader = unifiedShader;
        this.tmu = tmu;
        this.rop = rop;
        this.pixelShader = pixelShader;
        this.vertexShader = vertexShader;
        this.igp = igp;
        this.bus = bus;
        this.memType = memType;
        this.gpuChip = gpuChip;
    }

    public Gpu() {
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }


    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getMemSize() {
        return memSize;
    }

    public void setMemSize(int memSize) {
        this.memSize = memSize;
    }

    public int getMemBusWidth() {
        return memBusWidth;
    }

    public void setMemBusWidth(int memBusWidth) {
        this.memBusWidth = memBusWidth;
    }

    public int getGpuClock() {
        return gpuClock;
    }

    public void setGpuClock(int gpuClock) {
        this.gpuClock = gpuClock;
    }

    public int getMemClock() {
        return memClock;
    }

    public void setMemClock(int memClock) {
        this.memClock = memClock;
    }

    public int getUnifiedShader() {
        return unifiedShader;
    }

    public void setUnifiedShader(int unifiedShader) {
        this.unifiedShader = unifiedShader;
    }

    public int getTmu() {
        return tmu;
    }

    public void setTmu(int tmu) {
        this.tmu = tmu;
    }

    public int getRop() {
        return rop;
    }

    public void setRop(int rop) {
        this.rop = rop;
    }

    public String getPixelShader() {
        return pixelShader;
    }

    public void setPixelShader(String pixelShader) {
        this.pixelShader = pixelShader;
    }

    public String getVertexShader() {
        return vertexShader;
    }

    public void setVertexShader(String vertexShader) {
        this.vertexShader = vertexShader;
    }

    public String getIgp() {
        return igp;
    }

    public void setIgp(String igp) {
        this.igp = igp;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getMemType() {
        return memType;
    }

    public void setMemType(String memType) {
        this.memType = memType;
    }

    public String getGpuChip() {
        return gpuChip;
    }

    public void setGpuChip(String gpuChip) {
        this.gpuChip = gpuChip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
