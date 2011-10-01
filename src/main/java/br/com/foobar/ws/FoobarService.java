/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foobar.ws;

import br.com.foobar.persistence.Card;
import br.com.foobar.persistence.CardDAO;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author victor
 */
public class FoobarService {
    
    public static final String URL_REQUISICAO_SCHEMA = "http://localhost:8080/FoobarCard/requisicao.xsd";

    public FoobarService() {
    }

    @POST
    @Consumes(MediaType.TEXT_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Resposta postXml(String xmlRequisicao) throws JAXBException, SAXException, MalformedURLException, Exception {
        JAXBContext jc = JAXBContext.newInstance(Requisicao.class);
        Unmarshaller u = jc.createUnmarshaller();
        ByteArrayInputStream bis = new ByteArrayInputStream(xmlRequisicao.getBytes());
        SchemaFactory sf = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema s = sf.newSchema(new URL(URL_REQUISICAO_SCHEMA));
        u.setSchema(s);
        Requisicao requisicao = (Requisicao) u.unmarshal(bis);
        return doRequisicao(requisicao);
    }
    
    public Resposta doRequisicao(Requisicao requisicao) throws Exception {
        System.out.println(requisicao);
        CardDAO cdao = new CardDAO();
        cdao.insert(new Card("abc", BigDecimal.ZERO));
        return new Resposta(Resposta.CODIGO_RETORNO_APROVADO, Resposta.MENSAGEM_APROVADO);
    }
}
