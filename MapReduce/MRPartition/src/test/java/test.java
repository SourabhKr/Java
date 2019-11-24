import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String value = "\"Brown, Mia\",1103024456,1,1,0,1,1,3,30,28.5,MA,1450,11/24/1987,Female,Married,US Citizen,No,Black or African American,10/27/2008,3317,,N/A - still employed,Active,Admin Offices,Accountant I,Brandon R. LeBlanc,Diversity Job Fair,Fully Meets";
        String line = value.toString();
        String[] employeeSplit = line.split(",");

        System.out.println(Arrays.toString(employeeSplit));


        String[] dateSplit = employeeSplit[13].toString().split("/");
        System.out.println(Arrays.toString(dateSplit));
        System.out.println(employeeSplit[0] + employeeSplit[1] + employeeSplit[2] + dateSplit[0]);
    }

}
