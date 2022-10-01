package labconcurrenteypatrones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class ServerAfrica extends Server {

    HashMap datos = new HashMap();

    public ServerAfrica(Server unServer) {
        super(unServer);
    }

    public void verificarUsuario(Usuario p) {
        //Verifica si puede atender la solicitud, sino pasa al usuario a otro servidor
        if (existeUsuarioBD(p.getNombre(), p.getPassword())) {
            p.setPermiso(true);
            System.out.println("El usuario "+ p.getNombre() +" entro al servidor de Africa");
        } else {
            this.siguienteServer.verificarUsuario(p);
        }
    }

    @Override
    public void cargarBD() {
        cargarDatosTxt();
    }

    private void cargarDatosTxt() {
        String ARCHIVO = "src/labconcurrenteypatrones/BdAfrica.txt";

        try {
            FileReader lectorArchivo = new FileReader(ARCHIVO);
            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            String linea = null;
            while ((linea = bufferLectura.readLine()) != null) {
                obtenerInformacion(linea);

            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo en algun archivo.");
        }
    }

    private void obtenerInformacion(String l) {
        String aux = l, contrasenia, usuario;
        int posAux = aux.indexOf(":");
        aux = aux.substring(posAux + 1, aux.length());

        posAux = aux.indexOf(":");
        //Obtenemos el correo 
        usuario = aux.substring(0, posAux);
        aux = aux.substring(posAux + 1, aux.length());

        posAux = aux.indexOf(":");
        //obtenemos la contrasenia
        contrasenia = aux.substring(posAux + 1, aux.length());
        this.datos.put(usuario, contrasenia);

    }

    public boolean existeUsuarioBD(String usuario, String contrasenia) {
        boolean existe = false;
        String contra = (String) this.datos.get(usuario);
        if (contra != null) {
            if (contra.equals(contrasenia)) {
                existe = true;
            }
        }
        return existe;
    }

}
