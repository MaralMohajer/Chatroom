import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMultiThreadThing extends Thread{
    ArrayList<PrintWriter> outArrayList;
    Socket socket;
    String message;
    String name;
    public ServerMultiThreadThing(Socket socket , String name , ArrayList<PrintWriter> outArrayList){

        this.name = name;
        this.socket = socket;
        this.outArrayList = outArrayList;
    }

    @Override
    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String text;
            while (((text = in.readLine()) != null )){
                message = name + " : " + text;
                System.out.println(message);
                for (int i = 0; i < outArrayList.size(); i++) {
                    if (!message.equals(name + " : ")){
                        outArrayList.get(i).println(message);
                    }

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
