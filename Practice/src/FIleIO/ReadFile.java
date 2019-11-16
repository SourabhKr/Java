package FIleIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/*
Reading a file

*/

public class ReadFile {
    public static void main(String[] args) throws Exception{
        // write your code here
        String fileName = "";
        FileInputStream inputStream = null;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        try{
            fileName = buffer.readLine();
            System.out.println(fileName);
            inputStream = new FileInputStream(fileName);
            while(inputStream.available() > 0) {
                System.out.print((char)inputStream.read());
            }
        }
        catch(Exception e){
            System.out.println("No such file");
        }
        finally {
            inputStream.close();
            buffer.close();
        }
    }
}