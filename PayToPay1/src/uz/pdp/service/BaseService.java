package uz.pdp.service;

public interface BaseService <T, R> {
    R add(T t);
    void get();
    void delete(String cardNumber);
}
