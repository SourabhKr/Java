
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class fileProc extends UnicastRemoteObject implements fileProcInterface
{
	// stores the relevents data porints in the memory
	private Map<String,String> data = null; 
	private static final long serialVersionUID = 1L;

	public fileProc() throws RemoteException{
		super();
	}

	public void loadFile(String path) throws RemoteException {
		// read the file and store the relevent records in the hash map.[in memory]
	}

	public int[] sum() throws RemoteException {
		// Delay = ArrDelay + DepDelay
            // This method returns an array 5 elements, containing per year total delay.
            // The 0th index contains delay for the year 2004 1st index contains total delay for the year 2005 and so on. 
	}

	public int[] avg() throws RemoteException{
		// This methods returns an array 5 elements, containing per year average delay. 
		//The 0th index contains average delay for the year 2004,
		// 1st index contains average delay for the year 2005 and so on.
	}

	public int[] count() throws RemoteException{
		// This methods returns an array 5 elements, containing per year total cancelled flights. 
		// The 0th index contains total cancelled flights for the year 2004,
		// 1st index contains total cancelled flights for the year 2005 and so on.

	}

}
	