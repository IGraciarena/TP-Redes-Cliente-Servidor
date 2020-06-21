import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class AtiendeEscritura extends Atendedor implements Runnable {
    private String mensajeTX = "_";

    AtiendeEscritura(Socket s) {
        super(s);
    }

    @Override
    public void run() {
        try {
            Scanner tecla = new Scanner(System.in);

            while (output != null && (!mensajeTX.equalsIgnoreCase("x"))) {
                mensajeTX = tecla.nextLine();
                output.println(mensajeTX);
                System.out.println("Yo: " + mensajeTX);
                output.flush();
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}