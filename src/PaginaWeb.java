/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Random;
import java.util.concurrent.Semaphore;

public class PaginaWeb {
    private Semaphore sem = new Semaphore(5, true);
    private Server server;
    private int opc1 = 0, opc2 = 0, opc3 = 0;
    
    public PaginaWeb(Server unServer) {
        this.server = unServer;
    }
    
    public boolean logIn(String nombreDeUsuario, String password) {
        boolean salida = false;
        
        try {
            sem.acquire();
            salida = server.verificarUsuario(nombreDeUsuario, password);
            sem.release();
        } catch(InterruptedException e) {}
        if(!salida)
                System.out.println("El usuario "+nombreDeUsuario+" no pudo ingresar.");
        
        return salida;
    }
    
    public synchronized void votar() {
        int eleccionAleatoria = new Random().nextInt(3)+1;
        switch (eleccionAleatoria) {
            case 1:
                opc1++;
                break;
            case 2:
                opc2++;
                break;
            case 3:
                opc3++;
                break;
        }
        System.out.println("Opción 1: "+opc1+" - Opción 2: "+opc2+" - Opción 3: "+opc3);
    }
}
