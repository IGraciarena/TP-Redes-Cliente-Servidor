import java.io.*;
import java.net.Socket;

public class Atendedor {
    protected Socket s;
    protected BufferedReader input;
    protected PrintWriter output;

    Atendedor(Socket s){
        this.s=s;
        InputStream IN;
        try {
            IN = s.getInputStream();
            OutputStream OUT = s.getOutputStream();
            input = new BufferedReader(new InputStreamReader(IN));
            output = new PrintWriter(new OutputStreamWriter(OUT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
