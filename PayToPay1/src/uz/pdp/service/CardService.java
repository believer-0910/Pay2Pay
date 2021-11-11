package uz.pdp.service;

import uz.pdp.model.Card;
import uz.pdp.model.InputOutput;

import java.util.ArrayList;
import java.util.List;

public class CardService implements CardServiceInterface {
    List<Card> cardList = new ArrayList<>();

    @Override
    public Integer add(Card card) {
        if (checkCard(card.getCardNumber())!=null)
            return -1;
        cardList.add(card);
        return 0;
    }

    @Override
    public void get() {

    }

    @Override
    public void delete(String cardNumber) {

    }

    @Override
    public Card checkCard(String cardNumber) {
        for(Card card: cardList){
            if(card.getCardNumber().equals(cardNumber))
                return card;
        }
        return null;
    }

    @Override
    public int fillBalance(String cardNumber, double money) {
        int index = 0;
        for (Card card : cardList) {
            if (card.getCardNumber().equals(cardNumber)) {
                card.setMoney(card.getMoney()+money);
                cardList.set(index, card);
                return 10;
            }
            index++;
        }
        return 0;
    }

    @Override
    public void payToPay(String cardNumber1, String cardNumber2, double amount, HistoryService historyService) {
        Card card1 = checkCard(cardNumber1);
        Card card2 = checkCard(cardNumber2);
        if (card1 != null || card2 != null){
            if(card1.getMoney()>amount+amount/100){
                card1.setMoney(card1.getMoney()-amount-amount/100);
                card2.setMoney(card2.getMoney()+amount);
                card1.setCashBack(card1.getCashBack()+amount/200);
                historyService.add1(card1.getCardNumber(), card2.getCardNumber(), InputOutput.OUTPUT, InputOutput.INPUT, amount);
                cardList.set(cardList.indexOf(checkCard(cardNumber1)), card1);
                cardList.set(cardList.indexOf(checkCard(cardNumber2)), card2);
            }
        }
    }


}
