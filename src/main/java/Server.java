import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{

    @Override
    public void run() {

        try (ServerSocket serverSocket = new ServerSocket(Main.getPort());
             Socket socket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)
        ){
            int number = Integer.parseInt(in.readLine());
            int firstArg = 0;
            int secondArg = 1;
            int finalNum = 0;
            for (int i = 1; i < number; i++) {
                finalNum = firstArg + secondArg;
                firstArg = secondArg;
                secondArg = finalNum;
            }
            out.println(finalNum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
