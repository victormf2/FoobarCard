package br.com.foobar.business;

import br.com.foobar.persistence.Card;
import br.com.foobar.persistence.CardDAO;
import br.com.foobar.ws.Requisicao;
import java.math.BigDecimal;

public class CardManager {

    private CardDAO cardDAO;

    public CardManager() {
        cardDAO = new CardDAO();
    }

    public boolean processRequisicao(Requisicao requisicao) {
        Card card = cardDAO.getCard(requisicao.getNumeroCartao());
        BigDecimal cardLimit = card.getCardLimit();
        BigDecimal value = requisicao.getValor();

        if (isValueGreaterThanCardLimit(cardLimit, value)) {
            return false;
        }
        decreaseCardLimit(card, value);
        return true;
    }

    public boolean isValueGreaterThanCardLimit(BigDecimal cardLimit, BigDecimal value) {
        return value.compareTo(cardLimit) > 0;
    }

    public void decreaseCardLimit(Card card, BigDecimal value) {
        card.setCardLimit(card.getCardLimit().subtract(value));
        cardDAO.updateCard(card);
    }
}
