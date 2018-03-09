/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alunomobile
 */
public class Listagem {
    
	//prototipo semaforo
	//static boolean busy = false;
    private List<String> urls = new ArrayList<String>();
    //public static List<String> urls_lidas = new ArrayList<String>();
    private static Listagem instancia = null;
    
    private Listagem(){
        
        
        try {
        	File arquivo = new File(Listagem.class.getResource("domains.txt").getFile());
            Scanner s = new Scanner(arquivo);
            
            while(s.hasNextLine())
                this.urls.add(s.nextLine());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Listagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static Listagem getInstancia(){
        if (Listagem.instancia == null)
            Listagem.instancia = new Listagem();
            
        return Listagem.instancia;
    }
    
    protected List<String> getUrls(){
    	return instancia.urls;
    }
    
}
