import javax.xml.crypto.Data;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class servidor {

    public static void main(String[] args) {
        //Crear un objeto socket
        int puerto = 5000;

        try {
            DatagramSocket socket = new DatagramSocket(puerto);
            System.out.println("Servidor esperando conexiones...");

            byte[] bufferEntrada = new byte[1024];

            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada,bufferEntrada.length);

            socket.receive(paqueteEntrada);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}