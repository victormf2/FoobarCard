package br.com.foobar;

import br.com.foobar.persistence.Card;
import br.com.foobar.persistence.CardDAO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Testeee {
    
    public static void main (String[] args) {
        CardDAO c = new CardDAO();
        c.insert(new Card("99999999777", new BigDecimal(12.3)));
        List<Card> cards = c.getCards();
        for(Card card : cards) {
            System.out.println(card);
        }
    }
}
