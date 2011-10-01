package br.com.foobar;

import br.com.foobar.persistence.Card;
import br.com.foobar.persistence.CardDAO;
import java.math.BigDecimal;
import java.util.List;

public class Testeee {

    public static void main(String[] args) {
        CardDAO c = new CardDAO();
        c.insert(new Card("999567578", new BigDecimal(12.3)));
        List<Card> cards = c.getCards();
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
