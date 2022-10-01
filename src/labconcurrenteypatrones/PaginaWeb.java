package labconcurrenteypatrones;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class PaginaWeb {

    private Semaphore sem = new Semaphore(5, true);
    private ServerMundial server;
    private int opc1 = 0, opc2 = 0, opc3 = 0;

    public PaginaWeb(ServerMundial unServer) {
        this.server = unServer;
    }

    public void logIn(Usuario p) throws InterruptedException {
        sem.acquire(); //se deja que cierta cantidad de hilos entren a loguear
        server.verificarUsuario(p);
        sem.release();
    }

    public synchronized void votar(String usuario) {
        //Metodo sincronizado que simula una votacion, un hilo a la vez entra y cuando sale, otro entra 
        System.out.println("------------------------------------------------------------------");
        int eleccionAleatoria = new Random().nextInt(3) + 1;
        System.out.println("EL usuario " + usuario + " ingreso a votar");
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
        
        System.out.println("EL usuario " + usuario + " salio de votar");
        System.out.println("Opción 1: " + opc1 + " - Opción 2: " + opc2 + " - Opción 3: " + opc3);
        System.out.println("---------------------------------------------------------------------");
    }
}
