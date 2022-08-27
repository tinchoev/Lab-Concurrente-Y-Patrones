/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class ServerAsia extends Server {

    public ServerAsia(Server unServer) {
        super(unServer);
        usuarios.put("asiaUser", "asia");
        nombre = "Servidor de Asia";
    }
}
