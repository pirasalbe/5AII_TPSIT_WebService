package webservice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Date;

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
    
    public cf(String nome, String cognome, String nascita, String comune, String sesso) {
        this.nome = nome;
        this.cognome=cognome;
        this.nascita=nascita;
        this.comune=comune;
        this.sesso=sesso;
    }
    
    public String calcola(){        
        String result ="";
        String uri="http://webservices.dotnethell.it/codicefiscale.asmx/CalcolaCodiceFiscale?nome=" + nome + "&cognome=" + cognome + "&comunenascita=" + comune + "&datanascita=" + nascita + "&sesso=" + sesso;
    
        try {

		URL url = new URL(uri);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... ");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
                        result+=output;
		}

		conn.disconnect();

	  } catch (Exception e) {

		System.out.println(e);

	  }
    
        return result;
        
    }
    
}
