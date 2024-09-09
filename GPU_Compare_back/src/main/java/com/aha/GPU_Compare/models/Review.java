package com.aha.GPU_Compare.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Table(name = "review")
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String userName;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL , optional = false)
    @JoinColumn(name="gpu_id")
    private Gpu gpu;

    public Review(String description, String userName, Gpu gpu) {
        this.description = description;
        this.userName = userName;
        this.gpu = gpu;
    }

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Gpu getGpu() {
        return gpu;
    }

    public void setGpu(Gpu gpu) {
        this.gpu = gpu;
    }
}
