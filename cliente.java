import javax.xml.crypto.Data;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class cliente {
    public static void main(String[] args) {
         //Crear un objeto socket
        int puerto = 5000;

        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress direccionIp_servidor = InetAddress.getByName("localhost");

            //Arreglo de bytes 
            String mensajeSalida = "Hola soy el cliente";
            byte[] bufferSalida= mensajeSalida.getBytes();

            DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionIp_servidor, puerto);
            socket.send(paqueteSalida);

            //Mensaje servidor

            byte[] bufferEntrada = new byte[1024];

            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada,bufferEntrada.length);

            socket.receive(paqueteEntrada);

            //Extraer la info del paquete 
            String mensajeRecibido = new String(paqueteEntrada.getData());
            System.out.println("El mensaje es: "+mensajeRecibido);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
