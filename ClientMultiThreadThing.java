import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientMultiThreadThing extends Thread{
    Socket socket;
    String message;
    public ClientMultiThreadThing(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String text;
            while ((text = in.readLine()) != null){
                this.message = text;
                System.out.println(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
