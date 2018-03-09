/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrawler;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alunomobile
 */
public class JavaCrawler {

    public static void main(String[] args) {
        try {
        	Random random = new Random();
            for(int i = 0; i < 10; i++){
                Thread t = new Thread(new ThreadBuscar(i));
                t.start();
                t.sleep(100);
                
            }
            
            /*String url = "http://globo.com";
            InputStream response = new URL(url).openStream();

                Scanner scanner = new Scanner(response);
               
                String responseBody = scanner.useDelimiter("\\A").next();
                System.out.println("\\A - Thread: " + 1);
                System.out.println(responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>")));
                */
        } catch (Exception ex) {
            Logger.getLogger(JavaCrawler.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
    }
    
}
