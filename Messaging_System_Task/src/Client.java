import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {


    public static void main(String[] args) throws IOException {


        InetAddress address=InetAddress.getByName("localhost");

//        Socket myServer = new Socket(address, 6666);

        Socket myServer = new Socket(address, 6666);

        ObjectOutputStream output = new ObjectOutputStream(myServer.getOutputStream());
        ObjectInputStream input = new ObjectInputStream(myServer.getInputStream());

        output.writeObject("123456678");
        output.writeObject("Subscribe");
        output.flush();
//        String messageIn=(String)input.readObject();
//        System.out.println("message from the client: "+messageIn);
//        output.writeObject("bye");
//        output.flush();



        output.close();
        input.close();


    }
}
