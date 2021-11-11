package uz.pdp.catagory.model;

import uz.pdp.service.BaseService;

import java.util.UUID;

public class Service extends BaseCatagory {
    private UUID catagoryId;

    public UUID getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(UUID catagoryId) {
        this.catagoryId = catagoryId;
    }
}
