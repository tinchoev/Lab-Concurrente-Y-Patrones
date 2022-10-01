package labconcurrenteypatrones;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Usuario implements Runnable {

    private String nombreDeUsuario;
    private String password;
    private PaginaWeb paginaWeb;
    private boolean permisoAEntrar;

    public Usuario(String unNombreDeUsuario, String unaPassword, PaginaWeb unaPaginaWeb) {
        this.nombreDeUsuario = unNombreDeUsuario;
        this.password = unaPassword;
        this.paginaWeb = unaPaginaWeb;
        this.permisoAEntrar = false;
    }

    public boolean getPermiso() {
        return this.permisoAEntrar;
    }

    public void setPermiso(boolean p) {
        //Variable que es modificada solo si el usuario pertenece a un servidor
        this.permisoAEntrar = p;
    }

    public String getNombre() {
        return this.nombreDeUsuario;
    }
    public String getPassword(){
        return this.password;
    }

    @Override
    public void run()  {
        
        try {
            Thread.sleep(((int)(Math.random()*(4000 - 2000)+ 2000)));
            //Se intenta loguear
            paginaWeb.logIn(this);
           Thread.sleep(((int)(Math.random()*(4000 - 2000)+ 2000)));
            if (this.permisoAEntrar) {//si se logeo entra a la pagina a votar
                System.out.println(this.nombreDeUsuario + ": Ingresé a la pagina");
                paginaWeb.votar(this.nombreDeUsuario);
            }else{//sino se pudo loguear se va 
                System.out.println(this.nombreDeUsuario + " No pudo ingresar a la pagina");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
