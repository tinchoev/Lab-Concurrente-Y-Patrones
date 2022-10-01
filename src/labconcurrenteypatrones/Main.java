package labconcurrenteypatrones;





import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor ;

public class Main {
    public static void main (String [] args) {
        
        //Variables cadena de responsabilidad
        ServerMundial servidor = new ServerMundial();
        servidor.cargarBD();
        PaginaWeb paginaWeb = new PaginaWeb(servidor);//Clase que cotiene el recurso compartido
        
        ArrayList<Usuario> listaAux = new ArrayList<Usuario>();//Lista que cotiene a lso usarios scados de un txt
        crearHilos(listaAux,paginaWeb);
        
        ExecutorService executor = Executors.newFixedThreadPool(8);
        
        for(int i=0; i<13; i++) {
           executor.execute(( (Usuario)(listaAux.get(i)) ) );
        }
        executor.shutdown(); // Metodo que termina la vida de los hilos cuando no quedan mas tareas
        
    }
    
    public static void crearHilos(ArrayList l,PaginaWeb p){
        //Metodo que extrae los atributos de los usuarios y los inicializa 
        String ARCHIVO = "src/labconcurrenteypatrones/Personas.txt";
        
        try{
            FileReader lectorArchivo = new FileReader(ARCHIVO);
            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            String linea = null;
            while((linea = bufferLectura.readLine()) != null){
                obtenerInformacion(linea,l,p);
                
            }
        }catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo en algun archivo.");
        }
    }
     public static void obtenerInformacion(String l,ArrayList lista,PaginaWeb p){
        String aux = l,contrasenia,nombre;
        int posAux = aux.indexOf(":");
        aux = aux.substring(posAux+1,aux.length());
        posAux = aux.indexOf(":");
        //Obtenemos el correo 
        nombre = aux.substring(0, posAux);
        aux = aux.substring(posAux+1,aux.length());
        posAux = aux.indexOf(":");
        //obtenemos la contrasenia
        contrasenia = aux.substring(posAux+1,aux.length());
        lista.add(new Usuario(nombre,contrasenia,p));
    }
}
