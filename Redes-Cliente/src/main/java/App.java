import java.io.IOException;
import java.net.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws UnknownHostException, IOException, IllegalArgumentException, InputMismatchException, ConnectException, SocketException {
        try {
            checkConnection();
        } catch (UnknownHostException e) {
            System.out.println("Error de host");
            checkConnection();
        } catch (ConnectException e) {
            System.out.println("Error en la conexion");
            checkConnection();
        } catch (SocketException e){
            System.out.println("Finalizado");
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

    protected static void checkConnection() throws IOException, UnknownHostException, IllegalArgumentException, InputMismatchException, ConnectException, SocketException {
        Scanner opc = new Scanner(System.in);
        String ip;
        Integer puerto;
        System.out.println("Bienvenido, ingrese su ip y el puerto");
        System.out.println("IP: ");
        ip = opc.nextLine();
        System.out.println("Puerto: ");
        puerto = opc.nextInt();
        Socket cliente = new Socket(InetAddress.getByName(ip), puerto);
        AtiendeEscritura hiloEscritor = new AtiendeEscritura(cliente);
        AtiendeLectura hiloLector = new AtiendeLectura(cliente);
        Thread tescritor = new Thread(hiloEscritor);
        Thread tlector = new Thread(hiloLector);
        tescritor.start();
        tlector.start();
        if (cliente.isConnected()) {
            System.out.println("La conexion fue exitosa");
        }
    }
}
