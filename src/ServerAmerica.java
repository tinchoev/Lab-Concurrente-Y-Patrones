/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class ServerAmerica extends Server {

    public ServerAmerica(Server unServer) {
        super(unServer);
        usuarios.put("americaUser", "america");
        nombre = "Servidor de América";
    }
}
