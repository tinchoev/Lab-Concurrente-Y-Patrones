/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main (String [] args) {
        ServerOceania serOc = new ServerOceania(null);
        ServerAsia serAs = new ServerAsia(serOc);
        ServerAfrica serAf = new ServerAfrica(serAs);
        ServerEuropa serEu = new ServerEuropa(serAf);
        ServerAmerica serAm = new ServerAmerica(serEu);
        PaginaWeb paginaWeb = new PaginaWeb(serAm);
        ExecutorService executor = Executors.newFixedThreadPool(20);
        
        for(int i=1; i<=20; i++) {
            executor.execute(new Usuario("usuario "+i, Integer.toString(i), paginaWeb));
        }
        
        executor.shutdown();
    }
}
