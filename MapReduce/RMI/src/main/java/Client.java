import java.rmi.*;

public class Client {
    public static void main(String[] args) throws  Exception{
        String serverIp = "localhost";
        String serverPort = "1997";
        String bname = "RemoteFunction";
        String connectionLocation = "rmi://" + serverIp + ":" +  serverPort + "/" + bname;

        FileProcInterface remoteObject =  (FileProcInterface)Naming.lookup(connectionLocation);
        remoteObject.loadFile("/home/sourabh/Studies/Code/Java/BigData/Data/data.csv");

    }
}
