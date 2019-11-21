package RMIPractice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.Collections;
import java.util.List;





public class FileProc extends UnicastRemoteObject implements FileProcInterface
{
    // stores the relevant data portion in the memory
    private List<String> fileLines = Collections.emptyList();


    public FileProc() throws RemoteException{
        super();
    }

    public void loadFile(String path) {
        // read the file and store the relevant records in the hash map.[in memory]
        String eachLine;
        try(BufferedReader bufferReader = new BufferedReader(new FileReader(path))){
            while(true) {
                eachLine = bufferReader.readLine();
                if (eachLine == null)
                    break;
                fileLines.add(eachLine);
            }

        }
        catch (IOException e){
            System.out.println(e);
        }
    }


    public int[] sum() {
        // Delay = ArrDelay + DepDelay
        // This method returns an array 5 elements, containing per year total delay.
        // The 0th index contains delay for the year 2004 1st index contains total delay for the year 2005 and so on.

        int firstIndex = 2004;
        int[] returnDelayList = new int[5];
        int index, arrDelay, depDelay;


        for (String eachLine : fileLines) {
            String[] individualElements = eachLine.split(",");
            index = Integer.parseInt(individualElements[1]) - firstIndex;

            try {
                arrDelay = Integer.parseInt(individualElements[15]);
            } catch (NumberFormatException e) {
                arrDelay = 0;
            }
            try {
                depDelay = Integer.parseInt(individualElements[16]);
            } catch (NumberFormatException e) {
                depDelay = 0;
            }

            returnDelayList[index] += arrDelay + depDelay;

        }
        return returnDelayList;
    }

    public int[] avg(){
        // This methods returns an array 5 elements, containing per year average delay.
        //The 0th index contains average delay for the year 2004,
        // 1st index contains average delay for the year 2005 and so on.
            int [] totalDelays =  this.sum();
        int[] returnArray = new int[5];
        for (int i = 0; i < totalDelays.length; i++)
            returnArray[i] = totalDelays[i] / fileLines.size();

        return returnArray;
    }

    public int[] count(){
        // This methods returns an array 5 elements, containing per year total cancelled flights.
        // The 0th index contains total cancelled flights for the year 2004,
        // 1st index contains total cancelled flights for the year 2005 and so on.
        int[] returnArray = new int[5];
        int cancelCheck ;
        int firstIndex = 2004;
        int index;

        for (String eachLine : fileLines) {

            String[] individualElements = eachLine.split(",");
            index = Integer.parseInt(individualElements[1]) - firstIndex ;

            try { cancelCheck = Integer.parseInt(individualElements[22]);}
            catch (NumberFormatException e){
                cancelCheck = 0;
            }
            returnArray[index] += cancelCheck;
        }

        return returnArray;
    }


}
	