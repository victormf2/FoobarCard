package br.com.foobar.persistence;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CardDAO {

    private SessionFactory factory;

    public CardDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void saveCard(Card card) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(card);
        session.getTransaction().commit();
        session.close();
    }

    public List<Card> getCards() {
        Session session = factory.openSession();
        Criteria c = session.createCriteria(Card.class);
        return c.list();
    }
    
    public Card getCard(String cardNumber) {
        Session session = factory.openSession();
        Card card = (Card) session.get(Card.class, cardNumber);
        session.close();
        return card;
    }
    
    public void updateCard(Card card) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(card);
        session.getTransaction().commit();
        session.close();
    }
}
