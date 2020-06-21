import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class AtiendeLectura extends Atendedor implements Runnable {

    private String mensajeRX = "_";

    AtiendeLectura(Socket s) {
        super(s);
    }


    public void run() {
        try {
            do {
                mensajeRX = input.readLine();
                System.out.println("Vos: " + mensajeRX);

            } while (input != null && (!mensajeRX.equalsIgnoreCase("x")));
            s.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}