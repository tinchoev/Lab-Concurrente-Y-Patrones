/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class Usuario implements Runnable {
    private String nombreDeUsuario;
    private String password;
    private PaginaWeb paginaWeb;
    
    public Usuario(String unNombreDeUsuario, String unaPassword, PaginaWeb unaPaginaWeb) {
        this.nombreDeUsuario = unNombreDeUsuario;
        this.password = unaPassword;
        paginaWeb = unaPaginaWeb;
    }
    
    @Override
    public void run() {
        if(paginaWeb.logIn(nombreDeUsuario, password)) {
            System.out.println(nombreDeUsuario+": Ingresé");
            paginaWeb.votar();
        }
    }
}
