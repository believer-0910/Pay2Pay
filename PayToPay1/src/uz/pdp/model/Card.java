package uz.pdp.model;

import java.util.UUID;

public class Card extends BaseModel{
    private String cardNumber;
    private double cashBack;
    private String password;
    private double money;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getCashBack() {
        return cashBack;
    }

    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
