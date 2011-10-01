package br.com.foobar.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Card")
@Table(name="card")
public class Card implements Serializable{
    
    private String cardNumber;
    private BigDecimal cardLimit;

    public Card() {
    }

    public Card(String cardNumber, BigDecimal cardLimit) {
        this.cardNumber = cardNumber;
        this.cardLimit = cardLimit;
    }

    @Column(name="card_limit")
    public BigDecimal getCardLimit() {
        return cardLimit;
    }

    @Id
    @Column(name="card_number")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardLimit(BigDecimal cardLimit) {
        this.cardLimit = cardLimit;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "br.com.foobar.persistence.Card [ cardNumber=" + cardNumber + ", cardLimit=" + cardLimit + " ]";
    }
    
    
}
