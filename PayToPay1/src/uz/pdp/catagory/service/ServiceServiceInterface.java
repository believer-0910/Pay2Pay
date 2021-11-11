package uz.pdp.catagory.service;

import uz.pdp.catagory.model.Service;

public interface ServiceServiceInterface extends BaseCatagoryService<Service, Integer>{
    Service check(Service service);

}
