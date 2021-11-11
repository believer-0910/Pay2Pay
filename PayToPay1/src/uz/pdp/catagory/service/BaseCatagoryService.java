package uz.pdp.catagory.service;

public interface BaseCatagoryService<T, R> {
    R add(T t);
    void get();
    void delete();
}
