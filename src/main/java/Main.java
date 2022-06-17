public class Main {

    private static String IP = "localhost";
    private static int port = 12129;

    public static void main(String[] args) {

        new Client().start();
        new Server().start();

    }

    public static String getIp() {
        return IP;
    }

    public static int getPort() {
        return port;
    }
}
