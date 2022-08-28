/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class ServerAmerica extends Server {

    public ServerAmerica(Server unServer) {
        super(unServer);
        usuarios.put("usuario 10", "10");
        usuarios.put("usuario 11", "11");
        usuarios.put("usuario 12", "12");
        nombre = "Servidor de América";
    }
}
