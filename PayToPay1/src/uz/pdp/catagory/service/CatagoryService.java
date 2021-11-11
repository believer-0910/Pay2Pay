package uz.pdp.catagory.service;

import uz.pdp.catagory.model.Catagory;
import uz.pdp.catagory.model.Service;

import java.util.ArrayList;
import java.util.List;

public class CatagoryService implements CatagoryServiceInterface {

    ArrayList<Catagory> catagoryList = new ArrayList<>();
    ServiceService serviceService = new ServiceService();

    @Override
    public Integer add(Catagory catagory) {
        if (check(catagory) != null) {
            return -1;
        } else {
            catagoryList.add(catagory);
        }
        return 0;
    }


    @Override
    public void get() {

    }

    @Override
    public void delete() {

    }



    @Override
    public Catagory check(Catagory catagory) {
        for (Catagory catagory1 : catagoryList)
            if (catagory.getName().equals(catagory1.getName()))
                return catagory;
        return null;
    }

    @Override
    public ArrayList<Catagory> getAll() {
        return catagoryList;
    }

    public void get(ServiceService serviceService){
        for (Catagory catagory : catagoryList){
            serviceService.get(catagory);
        }
    }

    public Catagory check(String name) {
        for (Catagory catagory1 : catagoryList)
            if (catagory1.getName().equals(name))
                return catagory1;
        return null;
    }

}
