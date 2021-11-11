package uz.pdp.catagory.model;

import java.util.UUID;

public class ServiceField {
    private UUID id;
    private String name;
    private String title;
    private UUID serviceId;

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getServiceId() {
        return serviceId;
    }

    public void setServiceId(UUID serviceId) {
        this.serviceId = serviceId;
    }
}
