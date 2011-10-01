/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foobar.ws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Requisicao {
    
    private BigDecimal numeroCartao;
    private String dataExpiracao;
    private BigDecimal valor;

    @XmlElement(name="dataExpiracao", required=true)
    public String getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(String dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    @XmlElement(name="numeroCartao", required=true)
    public BigDecimal getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(BigDecimal numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @XmlElement(name="valor", required=true)
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("Requisicao "
                + "([numeroCartao: %s],"
                + "[dataExpiracao: %s],"
                + "[valor: %.2f])", numeroCartao, dataExpiracao, valor);
    }
}
