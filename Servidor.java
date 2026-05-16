import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 5000; 

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando conexión en el puerto " + puerto + "...");

            Socket socketCliente = serverSocket.accept();
            System.out.println("¡Cliente conectado desde: " + socketCliente.getInetAddress().getHostAddress() + "!");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);
            String mensajeCliente = entrada.readLine();
            System.out.println("El cliente dice: " + mensajeCliente);
            salida.println("¡Hola Cliente! Mensaje recibido fuerte y claro.");
            socketCliente.close();
            System.out.println("Conexión finalizada.");
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}