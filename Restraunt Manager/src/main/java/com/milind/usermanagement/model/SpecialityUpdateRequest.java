package com.milind.usermanagement.model;

public class SpecialityUpdateRequest {
    private long id;
    private String speciality;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
