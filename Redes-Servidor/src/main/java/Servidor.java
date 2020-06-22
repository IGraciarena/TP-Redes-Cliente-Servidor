import java.net.Socket;

public class Servidor {

    public Socket clienteConectado = null;
//    public Socket socket = null;
//    private BufferedReader input = null;
//    private PrintWriter output = null;
//    private String message = "";

    Servidor(Socket clienteConectado) {
        this.clienteConectado = clienteConectado;
    }

}
