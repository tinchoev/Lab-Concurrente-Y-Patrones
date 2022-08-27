/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class ServerEuropa extends Server {

    public ServerEuropa(Server unServer) {
        super(unServer);
        usuarios.put("europaUser", "europa");
        nombre = "Servidor de Europa";
    }
}
