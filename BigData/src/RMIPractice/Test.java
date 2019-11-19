package RMIPractice;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Test{
    // stores the relevant data portion in the memory
    private Map<String,String> data = null;
    private static final long serialVersionUID = 1L;
    private List<String> fileLines = new ArrayList<String>();

    public static void main(String[] args) {
        Test tempObject = new Test();
        tempObject.loadFile("/home/sourabh/Studies/Code/Java/BigData/Data/data.csv");
        System.out.println(tempObject.fileLines.size());
        for(int temp : tempObject.count())System.out.println(temp);


    }

    public void loadFile(String path){
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

    public int[] sum()  {
        // Delay = ArrDelay + DepDelay
        // This method returns an array 5 elements, containing per year total delay.
        // The 0th index contains delay for the year 2004 1st index contains total delay for the year 2005 and so on.

        int firstIndex = 2004;
        int[] returnDelayList = new int[5];
        int index;
        int arrDelay;
        int depDelay;


        for (String eachLine : fileLines) {
            String[] individualElements = eachLine.split(",");
            index = Integer.parseInt(individualElements[1]) - firstIndex ;

            try { arrDelay = Integer.parseInt(individualElements[15]);}
            catch(NumberFormatException e){arrDelay = 0;}
            try{depDelay =  Integer.parseInt(individualElements[16]);}
            catch(NumberFormatException e){depDelay = 0;}

            returnDelayList[index] += arrDelay + depDelay;
            /*

            if(data.get(individualElements[1]) == null){
                data.put(individualElements[1], String.valueOf((Integer.parseInt(individualElements[15])) +
                        Integer.parseInt(individualElements[16])));
            }
            else{
                data.put(individualElements[1], String.valueOf( Integer.parseInt(data.get(individualElements[1]))
                        + (Integer.parseInt(individualElements[15])) +
                        (Integer.parseInt(individualElements[16]))));
            }*/
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

