package webservice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author pirasalbe
 */
public class cf {
    
    private String nome;
    private String cognome;
    private String nascita;
    private String comune;
    private String sesso;
    private Proxy proxy;
    
    public cf(String nome, String cognome, String nascita, String comune, String sesso, Proxy proxy) {
        this.nome = nome;
        this.cognome=cognome;
        this.nascita=nascita;
        this.comune=comune;
        this.sesso=sesso;
        this.proxy = proxy;
    }
    
    public String calcola(){   
        Element element = null;
        String uri="http://webservices.dotnethell.it/codicefiscale.asmx/CalcolaCodiceFiscale?nome=" + nome + "&cognome=" + cognome + "&comunenascita=" + comune + "&datanascita=" + nascita + "&sesso=" + sesso;
    
        try {

		URL url = new URL(uri);
                HttpURLConnection conn;
                
                if(proxy!=null)
                    conn = (HttpURLConnection) url.openConnection(proxy);
                else
                    conn = (HttpURLConnection) url.openConnection();
                
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
                
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(conn.getInputStream());
                element = doc.getDocumentElement();

		conn.disconnect();

	  } catch (Exception e) {

		System.out.println(e);

	  }
    
        return element.getTextContent();
        
    }
    
}
