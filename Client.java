import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("localhost", 2345);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ClientMultiThreadThing multiThreadThing = new ClientMultiThreadThing(socket);
        multiThreadThing.start();
        while (true){
            if(scanner.hasNext()){
                String message = scanner.nextLine();
                out.println(message);
            }
        }
    }
}