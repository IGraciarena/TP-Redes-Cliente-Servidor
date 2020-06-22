import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor;
        servidor = new ServerSocket(3000);
        System.out.println("Servidor conectado");
        while (true) {
            Socket cliente;
            cliente = servidor.accept();
            System.out.println("Cliente conectado :" + "desde IP" + cliente.getInetAddress() + " desde el puerto " + cliente.getPort());
            Servidor s = new Servidor(cliente);
            AtiendeEscritura hiloEscritor = new AtiendeEscritura(cliente);
            AtiendeLectura hiloLector = new AtiendeLectura(cliente);
            Thread tescritor = new Thread(hiloEscritor);
            Thread tlector = new Thread(hiloLector);
            tescritor.start();
            tlector.start();
        }
    }
}
