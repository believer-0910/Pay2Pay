package uz.pdp.model;

public class History extends BaseModel{
    private String cardNumber;
    private Enum type;
    private double history;

    public History() {

    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public double getHistory() {
        return history;
    }

    public void setHistory(double history) {
        this.history = history;
    }
}
