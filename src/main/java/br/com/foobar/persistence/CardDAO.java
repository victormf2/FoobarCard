package br.com.foobar.persistence;

import br.com.foobar.database.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public class CardDAO {

    public CardDAO() {
    }

    public void saveCard(Card card) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(card);
        session.getTransaction().commit();
        session.close();
    }

    public List<Card> getCards() {
        Session session = HibernateUtil.getSession();
        Criteria c = session.createCriteria(Card.class);
        return c.list();
    }

    public Card getCard(String cardNumber) {
        Session session = HibernateUtil.getSession();
        Card card = (Card) session.get(Card.class, cardNumber);
        session.close();
        return card;
    }

    public void updateCard(Card card) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(card);
        session.getTransaction().commit();
        session.close();
    }
}
