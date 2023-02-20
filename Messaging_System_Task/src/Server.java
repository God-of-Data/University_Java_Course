import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Map<String, Socket> subscribers = new HashMap<>();


        ArrayList<String> messages = new ArrayList<>();

        ServerSocket server=new ServerSocket(6666);

        messages.add("msg1");


        while (true) {

            Socket someClient = server.accept();
            ObjectOutputStream output =new ObjectOutputStream(someClient.getOutputStream());
            ObjectInputStream input=new ObjectInputStream(someClient.getInputStream());

            output.writeObject("Enter your choice: ");
            output.flush();

            String messageIn=(String)input.readObject();

            if (messageIn.equals("Subscribe")) {

                subscribers.put(someClient.toString(), someClient);

            }
            if (messageIn.equals("Unsubscribe")) {

                subscribers.remove(someClient.toString());

            }


            for (Map.Entry keyEntry : subscribers.entrySet()) {


                ObjectOutputStream outputToClient =new ObjectOutputStream(someClient.getOutputStream());

                ObjectInputStream input=new ObjectInputStream(someClient.getInputStream());

                keyEntry.getValue().



            }
            System.out.println("message from the client: "+messageIn);
            output.writeObject("bye");
            output.flush();
            output.close();
            input.close();
            someClient.close();



        }

//        server.setSoTimeout(2000);


//    } catch (Exception e) {
//        System.out.println("tiered of waiting for connection");
//    }
//    How many clients our sever can handle?
//    How
}
}
