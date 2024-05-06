import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Hilocliente extends Thread {

    private DatagramSocket socket;
    private DatagramPacket paqueteEntrada;

    public Hilocliente(DatagramSocket socket, DatagramPacket paqueteEntrada){
        this.socket=socket;
        this.paqueteEntrada=paqueteEntrada;

    }

    public void run(){

        //Extraer la info del paquete 
        String mensajeRecibido = new String(paqueteEntrada.getData());
        System.out.println("1 mensaje es: "+mensajeRecibido);


        //Obtener direccion del cliente
        InetAddress direccionIp_cliente = paqueteEntrada.getAddress();
        int puerto_cliente=paqueteEntrada.getPort();
        
        
        //Arreglo de bytes 
        String mensajeSalida = "Hola soy el servidor";
        byte[] bufferSalida= mensajeSalida.getBytes();


        DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionIp_cliente, puerto_cliente);
        try {
            socket.send(paqueteSalida);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
    
