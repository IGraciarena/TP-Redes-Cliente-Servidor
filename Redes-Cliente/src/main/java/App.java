import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws UnknownHostException, IOException, IllegalArgumentException, InputMismatchException, ConnectException {
        try {
            checkConnection();
        } catch (UnknownHostException e) {
            System.out.println("Error de host");
            checkConnection();
        } catch (ConnectException e) {
            System.out.println("Error en la conexion");
            checkConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de puerto");
            checkConnection();
        } catch (InputMismatchException e) {
            System.out.println("El puerto ingresado esta fuera de rango");
            checkConnection();
        }
    }

    protected static void checkConnection() throws IOException, UnknownHostException, IllegalArgumentException, InputMismatchException, ConnectException {
        Scanner opc = new Scanner(System.in);
        String ip;
        Integer puerto;
        System.out.println("Bienvenido, ingrese su ip y el puerto");
        System.out.println("IP: ");
        ip = opc.nextLine();
        System.out.println("Puerto: ");
        puerto = opc.nextInt();
        Socket sConexionActual = new Socket(InetAddress.getByName(ip), puerto);
        AtiendeEscritura hiloEscritor = new AtiendeEscritura(sConexionActual);
        AtiendeLectura hiloLector = new AtiendeLectura(sConexionActual);
        Thread tescritor = new Thread(hiloEscritor);
        Thread tlector = new Thread(hiloLector);
        tescritor.start();
        tlector.start();
        if (sConexionActual.isConnected()) {
            System.out.println("La conexion fue exitosa");
        }
    }
}
