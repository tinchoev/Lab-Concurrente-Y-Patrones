/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class ServerAfrica extends Server {

    public ServerAfrica(Server unServer) {
        super(unServer);
        usuarios.put("africaUser", "africa");
        nombre = "Servidor de África";
    }
}
