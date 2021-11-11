package uz.pdp.service;

import uz.pdp.model.Card;

public interface CardServiceInterface extends BaseService<Card, Integer> {
    Card checkCard(String cardNumber);
    int fillBalance(String cardNumber, double money);
    void payToPay(String cardNumber1, String cardNumber2, double amount, HistoryService historyService);
}
