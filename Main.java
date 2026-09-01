import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        // Port 5000 par server start karein
        HttpServer server = HttpServer.create(new InetSocketAddress(5000), 0);
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String response = "Hellooooooooooo World from Docker Java Server!";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });
        System.out.println("Server started on port 5000...");
        server.start();
    }
}
