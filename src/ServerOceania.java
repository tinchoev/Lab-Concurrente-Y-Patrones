/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class ServerOceania extends Server {

    public ServerOceania(Server unServer) {
        super(unServer);
        usuarios.put("usuario 1", "1");
        usuarios.put("usuario 2", "2");
        usuarios.put("usuario 3", "3");
        nombre = "Servidor de Oceanía";
    }
}
