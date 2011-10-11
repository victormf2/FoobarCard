package br.com.foobar.ws;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Resposta {

    private short codigoRetorno;
    private String mensagem;
    public static final short CODIGO_RETORNO_APROVADO = 1;
    public static final short CODIGO_RETORNO_RECUSADO = 0;
    public static final String MENSAGEM_APROVADO = "Transacao Aprovada";
    public static final String MENSAGEM_RECUSADO = "Transacao Nao Aprovada";

    public Resposta() {
    }

    public Resposta(short codigoRetorno, String mensagem) {
        this.codigoRetorno = codigoRetorno;
        this.mensagem = mensagem;
    }

    @XmlElement(name = "codigoRetorno", required = true)
    public short getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(short codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    @XmlElement(name = "mensagem", required = true)
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return String.format("Resposta "
                + "([codigoRetorno: %d],"
                + "[mensagem: %s],", codigoRetorno, mensagem);
    }
}
