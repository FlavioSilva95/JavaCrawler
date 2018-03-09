/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrawler;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
/**
 *
 * @author alunomobile
 */
public class ThreadBuscar implements Runnable  {

    private int id;
    private int qtd = 0;
    
    public ThreadBuscar(int id) {
        this.id = id;
    }
    
    @Override
    public void run() {
        
        try{
            String url = null;
            
            while(!Listagem.getInstancia().getUrls().isEmpty()){
  
               url = new String(Listagem.getInstancia().getUrls().get(0));
               Listagem.getInstancia().getUrls().remove(0);
                             
               if (url.contains("google")) continue;
               
               Document doc =  Jsoup.connect(url).get();
               System.out.println("Thread: " + this.id);
               System.out.println(doc.title());
               System.out.println("----------");
               
               qtd++;
               
                /*InputStream response = new URL(url).openStream();

                Scanner scanner = new Scanner(response);
                String responseBody = scanner.useDelimiter("\\A").next();
                System.out.println("Thread: " + this.id);
                System.out.println(responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>")));*/
            }
            
            System.out.println("Sites visitados: " + qtd);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
}
