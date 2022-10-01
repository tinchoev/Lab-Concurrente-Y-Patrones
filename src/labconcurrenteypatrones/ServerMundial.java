package labconcurrenteypatrones;


/**
 *
 * @author nahuel
 */
public class ServerMundial extends Server { //Clase Base-Incializa y carga el servidor de las demas clases manejadoras

    private ServerOceania serOc;
    private ServerAsia serAs;
    private ServerAfrica serAf;
    private ServerEuropa serEu;
    private ServerAmerica serAm;

    public ServerMundial() {
        super(null);
        serOc = new ServerOceania(null);
        serAs = new ServerAsia(serOc);
        serAf = new ServerAfrica(serAs);
        serEu = new ServerEuropa(serAf);
        serAm = new ServerAmerica(serEu);

    }

    @Override
    public void verificarUsuario(Usuario p) {
       this.serAm.verificarUsuario( p);
    }

    @Override
    public void cargarBD() {
        serOc.cargarBD();
        serAs.cargarBD();
        serAf.cargarBD();
        serEu.cargarBD();
        serAm.cargarBD();
    }

}
