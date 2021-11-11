package uz.pdp.service;

import uz.pdp.model.History;

public interface HistoryServiceInterface {

    void add1(String  card1, String  card2, Enum type1, Enum type2, double amount);
    void getHistoryList(String cardNumber);

}
