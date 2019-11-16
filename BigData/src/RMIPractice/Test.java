package RMIPractice;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Test{
    // stores the relevant data portion in the memory
    private Map<String,String> data = null;
    private static final long serialVersionUID = 1L;
    private List<String> fileLines = Collections.emptyList();

    public void loadFile(String path){
        // read the file and store the relevant records in the hash map.[in memory]
        try{
            fileLines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
            System.out.println(fileLines);
        }
        catch (IOException e){
            System.out.println(e);
        }
    }


    public int[] sum()  {
        // Delay = ArrDelay + DepDelay
        // This method returns an array 5 elements, containing per year total delay.
        // The 0th index contains delay for the year 2004 1st index contains total delay for the year 2005 and so on.

        for (String eachLine : fileLines) {
            String[] individualElements = eachLine.split(",");
            if(data.get(individualElements[1]) == null){
                data.put(individualElements[1], String.valueOf((Integer.parseInt(individualElements[15])) +
                        Integer.parseInt(individualElements[16])));
            }
            else{
                data.put(individualElements[1], String.valueOf( Integer.parseInt(data.get(individualElements[1]))
                        + (Integer.parseInt(individualElements[15])) +
                        (Integer.parseInt(individualElements[16]))));
            }
        }
        return (new int[1]);
    }

    public int[] avg(){
        // This methods returns an array 5 elements, containing per year average delay.
        //The 0th index contains average delay for the year 2004,
        // 1st index contains average delay for the year 2005 and so on.
        return (new int[1]);
    }

    public int[] count(){
        // This methods returns an array 5 elements, containing per year total cancelled flights.
        // The 0th index contains total cancelled flights for the year 2004,
        // 1st index contains total cancelled flights for the year 2005 and so on.
        return (new int[1]);
    }

    public static void main(String[] args) {
        Test tempObject = new Test();
        tempObject.loadFile("D:\\\\OneDrive - Mindtree Limited\\\\Code\\\\Java\\\\BigData\\\\Data\\\\data.csv");
    }

}

