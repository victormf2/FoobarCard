package br.com.foobar.persistence;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CardDAO {
    
    private SessionFactory factory;

    public CardDAO() {
        factory = new Configuration().addAnnotatedClass(Card.class).buildSessionFactory();
    }
    
    public void insert(Card card) {
        Session session = factory.openSession();
        session.save(card);  
        session.flush();
        session.close();
    }
    
    public List<Card> getCards() {
        Session session = factory.openSession();
        Criteria c = session.createCriteria(Card.class);
        return c.list();
    }
}
