package RMIPractice;

import java.rmi.RemoteException;
import java.rmi.*;

public class Server {
    public static void main(String[] args) throws RemoteException {

        String serverIp = "localhost";
        String serverPort = "1997";
        String bname = "RemoteFunction";
        String bindLocation = "rmi://" + serverIp + ":" +  serverPort + "/" + bname;

        FileProc remoteMethods = new FileProc();
        try{
        Naming.bind(bindLocation, remoteMethods);
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("Error");

        }
        System.out.println("Server ready");

    }
}
