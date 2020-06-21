public class App {
    public static void main(String[] args) {
        Servidor s = new Servidor();
        s.Inicio();
        s.escucharCliente();
        AtiendeEscritura hiloEscritor = new AtiendeEscritura(s.socket);
        AtiendeLectura hiloLector = new AtiendeLectura(s.socket);
        Thread tescritor = new Thread(hiloEscritor);
        Thread tlector = new Thread(hiloLector);
        tescritor.start();
        tlector.start();
    }
}
