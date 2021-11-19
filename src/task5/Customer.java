package task5;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
    private String name;
    private transient String phone;
    private int score;
    private String cardNumber;

    public Customer(String name, String phone, int score, String cardNumber) {
        this.name = name;
        this.phone = phone;
        this.score = score;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return score == customer.score &&
                Objects.equals(name, customer.name) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(cardNumber, customer.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, score, cardNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", score=" + score +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
