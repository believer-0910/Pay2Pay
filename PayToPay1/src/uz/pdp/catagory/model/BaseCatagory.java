package uz.pdp.catagory.model;

import java.util.UUID;

public abstract class BaseCatagory {
    private UUID id;
    private String name;

    public BaseCatagory() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

//    public void setId() {
//        this.id = UUID.randomUUID();
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
