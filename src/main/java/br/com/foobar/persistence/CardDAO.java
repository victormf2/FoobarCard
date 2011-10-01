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

    public void insert(Card card) {
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
}
