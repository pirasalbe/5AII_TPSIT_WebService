/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author pirasalbe
 */
public class WebService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(
			(System.in)));
        
        String nome, cognome, nascita, comune, sesso;
        
        try{
            
            System.out.print("Digita nome: ");
            nome = in.readLine();
            
            System.out.print("Digita cognome: ");
            cognome = in.readLine();
            
            System.out.print("Digita data nascita: ");
            nascita = in.readLine();
            
            System.out.print("Digita comune: ");
            comune = in.readLine();
            
            System.out.print("Digita sesso: ");
            sesso = in.readLine();
        
        } catch(Exception e){
            System.out.println(e);
        }
        
    }
    
}
