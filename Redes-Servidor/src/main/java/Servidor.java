import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public Socket clienteConectado = null;
    public Socket socket = null;
    private static ServerSocket SocketMio = null;
    private BufferedReader input = null;
    private PrintWriter output = null;
    private String message = "";

    Servidor(Socket datoCliente) {
        clienteConectado = datoCliente;
    }

    Servidor() {

    }

    public void escucharCliente() {
        try {

            socket = SocketMio.accept();
            System.out.println("Cliente conectado :" + "desde IP" + socket.getInetAddress() + " desde el puerto " + socket.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dispose(){
        try {
            SocketMio.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Inicio() {
        try {
            SocketMio= new ServerSocket(3000);
            System.out.println("Servidor conectado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
