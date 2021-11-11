package uz.pdp.catagory.service;

import uz.pdp.catagory.model.Catagory;
import uz.pdp.service.BaseService;

import java.util.ArrayList;

public interface CatagoryServiceInterface extends BaseCatagoryService<Catagory, Integer> {
    Catagory check(Catagory catagory);
    ArrayList<Catagory> getAll();
}
