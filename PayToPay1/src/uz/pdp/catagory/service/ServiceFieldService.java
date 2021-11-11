package uz.pdp.catagory.service;

import uz.pdp.catagory.model.Service;
import uz.pdp.catagory.model.ServiceField;

import java.util.ArrayList;
import java.util.List;

public class ServiceFieldService implements ServiceFieldServiceInterface {
    List<ServiceField> serviceFieldList = new ArrayList<>();

    @Override
    public Integer add(ServiceField serviceField) {
        if (check(serviceField)==null)
            serviceFieldList.add(serviceField);
        else
            return -1;
        return 0;
    }

    @Override
    public void get() {

    }

    @Override
    public void delete() {

    }

    @Override
    public ServiceField check(ServiceField serviceField) {
        for (ServiceField serviceField1: serviceFieldList)
            if(serviceField.equals(serviceField1))
                return serviceField;
        return null;
    }
}
