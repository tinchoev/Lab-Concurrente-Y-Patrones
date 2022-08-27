/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class ServerOceania extends Server {

    public ServerOceania(Server unServer) {
        super(unServer);
        usuarios.put("oceniaUser", "oceania");
        nombre = "Servidor de Oceanía";
    }
}
