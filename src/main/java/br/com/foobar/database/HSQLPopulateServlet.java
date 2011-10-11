package br.com.foobar.database;

import br.com.foobar.persistence.Card;
import br.com.foobar.persistence.CardDAO;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HSQLPopulateServlet implements Servlet {

    @Override
    public void init(ServletConfig sc) throws ServletException {
        CardDAO cardDAO = new CardDAO();
        cardDAO.saveCard(new Card("123400000000", new BigDecimal(300)));
        cardDAO.saveCard(new Card("123400000001", new BigDecimal(30)));
        cardDAO.saveCard(new Card("123400000002", new BigDecimal(50)));
        cardDAO.saveCard(new Card("123400000003", new BigDecimal(100)));
        cardDAO.saveCard(new Card("1234567890987654", new BigDecimal(30)));

        java.util.List<Card> l = cardDAO.getCards();
        for (Card c : l) {
            System.out.println(c);
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest sr, ServletResponse sr1) throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }
}
