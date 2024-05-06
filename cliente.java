import java.util.Scanner;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class cliente {
    public static void main(String[] args) {
        int puerto = 5000;

        try {

            while (true) {

                DatagramSocket socket = new DatagramSocket();
                InetAddress direccionIp_servidor = InetAddress.getByName("172.31.115.155");
    
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ingrese el mensaje: ");
                String mensajeSalida = scanner.nextLine();
    
                byte[] bufferSalida = mensajeSalida.getBytes();
    
                DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionIp_servidor, puerto);
                socket.send(paqueteSalida);
    
                byte[] bufferEntrada = new byte[1024];
                DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);
    
                socket.receive(paqueteEntrada);
    
                String mensajeRecibido = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
                System.out.println("El mensaje es: " + mensajeRecibido);
                
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
