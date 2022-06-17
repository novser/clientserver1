import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
    @Override
    public void run() {

        try (Socket socket = new Socket(Main.getIp(), Main.getPort());
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Введите номер члена ряда Фибоначчи");
            out.println(scanner.nextLine());
            System.out.println("Ответ: " + in.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}