package labconcurrenteypatrones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.HashMap;
import java.util.Map;

public abstract class Server {//Clase abstracta cabecera de las demas clases
    
    protected Map<String, String> usuarios = new HashMap<>();
    protected Server siguienteServer;
    protected String nombre;
    
    public Server(Server unServer) {
        this.siguienteServer = unServer;
    }
    
    public abstract void verificarUsuario(Usuario p);
    public abstract void cargarBD();
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   /* public boolean verificarUsuario(String nombreDeUsuario, String password) {
        if(this.nombreDeUsuarioValido(nombreDeUsuario) && this.passwordValida(nombreDeUsuario, password)) {
            System.out.println(nombreDeUsuario+" ingresó a la página por "+nombre);
            return true;
        }
        System.out.println("Las credenciales de "+nombreDeUsuario+" no existen en "+nombre);
        return this.verificarUsuarioEnSiguienteServer(nombreDeUsuario, password);
    }
    
    private boolean verificarUsuarioEnSiguienteServer(String nombreDeUsuario, String password) {
        if(siguienteServer == null) {
            return false;
        }
        return siguienteServer.verificarUsuario(nombreDeUsuario, password);
    }
    
    private boolean nombreDeUsuarioValido(String nombreDeUsuario) {
        return usuarios.containsKey(nombreDeUsuario);
    }
    
    private boolean passwordValida(String nombreDeUsuario, String password) {
        return usuarios.get(nombreDeUsuario).equals(password);
    }*/
}
