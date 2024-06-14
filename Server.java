import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2345);
        System.out.println("Chat Server is running on port 2345");
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ArrayList<PrintWriter> printWriterArrayList = new ArrayList<>();
        while (true){
            Socket socket = serverSocket.accept();
            printWriterArrayList.add(new PrintWriter(socket.getOutputStream(), true));
            String name = "User" + atomicInteger.incrementAndGet();
            ServerMultiThreadThing multiThreadThing = new ServerMultiThreadThing(socket , name, printWriterArrayList);
            multiThreadThing.start();
        }

    }
}