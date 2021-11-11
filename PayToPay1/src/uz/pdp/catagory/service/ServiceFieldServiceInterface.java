package uz.pdp.catagory.service;

import uz.pdp.catagory.model.Service;
import uz.pdp.catagory.model.ServiceField;

public interface ServiceFieldServiceInterface extends BaseCatagoryService<ServiceField, Integer>{
    ServiceField check(ServiceField serviceField);
}
