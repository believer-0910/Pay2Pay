package uz.pdp.catagory.service;

import uz.pdp.catagory.model.Catagory;
import uz.pdp.catagory.model.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceService implements ServiceServiceInterface{

    ArrayList<Service> serviceList = new ArrayList<>();

    @Override
    public Integer add(Service service) {
        if(check(service) == null)
            serviceList.add(service);
        else
            return -1;
        return 0;
    }

    public ArrayList<Service> getAll(){
        return serviceList;
    }

    @Override
    public void get() {


    }
    public void get(Catagory catagory) {
        System.out.println("++++++++++++++++" + catagory.getName() + "+++++++++++++++");
        for (Service service: serviceList) {
            if (service.getCatagoryId().equals(catagory.getId())) {
                System.out.println("++++++++++" + service.getName() + "+++++++++++");
            }
        }

    }

    @Override
    public void delete() {

    }

    @Override
    public Service check(Service service) {
        for (Service service1: serviceList)
            if (service1.getName().equals(service.getName()))
                return service;
        return null;
    }

    public void get(ServiceService serviceService){
        for (Service service: serviceList)
            if (service!=null)
                System.out.println("+++++++++++++++++++++++++++++++++"+service.getName()+"+++++++++++++++++++++++++++");
    }
}
