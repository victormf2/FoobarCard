package br.com.foobar.ws;

import br.com.foobar.business.CardManager;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

@Path("/autorizacao")
public class FoobarService {

    public static final String REQUISICAO_SCHEMA_URL = "http://localhost:8080/Foobar/requisicao.xsd";
    public static final Resposta RESPOSTA_APROVADO = new Resposta(Resposta.CODIGO_RETORNO_APROVADO, Resposta.MENSAGEM_APROVADO);
    public static final Resposta RESPOSTA_RECUSADO = new Resposta(Resposta.CODIGO_RETORNO_RECUSADO, Resposta.MENSAGEM_RECUSADO);

    public FoobarService() {
    }

    @GET
    public String get() {
        return "WebServiceOK";
    }

    @POST
    @Consumes(MediaType.TEXT_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Resposta postXml(String xmlRequisicao) {
        try {
            Requisicao requisicao = parseXmlToRequisicao(xmlRequisicao);
            return respostaToRequisicao(requisicao);
        } catch (Exception ex) {
            return RESPOSTA_RECUSADO;
        }

    }

    private Requisicao parseXmlToRequisicao(String xmlRequisicao) throws JAXBException, SAXException, MalformedURLException {
        JAXBContext jc = JAXBContext.newInstance(Requisicao.class);
        Unmarshaller u = jc.createUnmarshaller();
        ByteArrayInputStream bis = new ByteArrayInputStream(xmlRequisicao.getBytes());
        SchemaFactory sf = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema s = sf.newSchema(new URL(REQUISICAO_SCHEMA_URL));
        u.setSchema(s);
        Requisicao requisicao = (Requisicao) u.unmarshal(bis);
        return requisicao;
    }

    private Resposta respostaToRequisicao(Requisicao requisicao) {
        CardManager cardManager = new CardManager();
        return cardManager.processRequisicao(requisicao) ? RESPOSTA_APROVADO : RESPOSTA_RECUSADO;
    }
}
