package uz.pdp.service;

import uz.pdp.model.History;
import uz.pdp.model.InputOutput;
import uz.pdp.model.User;

import java.util.ArrayList;
import java.util.List;

public class HistoryService implements HistoryServiceInterface{

    List<History> historyList = new ArrayList<>();

    History history = new History();
    History history1 = new History();

    @Override
    public void add1(String card1, String card2, Enum type1, Enum type2, double amount) {
        history.setCardNumber(card1);
        history.setType(type1);
        history.setHistory(amount);
        historyList.add(history);
        history1.setCardNumber(card2);
        history1.setType(type2);
        history1.setHistory(amount);
        historyList.add(history1);
    }

    @Override
    public void getHistoryList(String cardNumber) {
        System.out.println("INPUT transaction");
        for (History history: historyList){
            if (history.getCardNumber().equals(cardNumber) && history.getType().equals(InputOutput.INPUT)){
                System.out.println(history.getHistory());
            }
        }
        System.out.println("OUTPUT transaction");
        for (History history: historyList){
            if (history.getCardNumber().equals(cardNumber) && history.getType().equals(InputOutput.OUTPUT)){
                System.out.println(history.getHistory());
            }
        }
    }
}
