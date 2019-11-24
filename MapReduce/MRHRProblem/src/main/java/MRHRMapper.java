import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MRHRMapper extends Mapper<LongWritable, Text,Text, EmployeeDetails > {
    @Override
    public  void map(LongWritable key, Text value, Context cont)
            throws IOException, InterruptedException{

        String line = value.toString();
        String[] employeeSplit = line.split(",");

        String[] dateSplit = employeeSplit[13].toString().split("/");

        cont.write(new Text(dateSplit[0]), new EmployeeDetails(employeeSplit[0] + employeeSplit[1], employeeSplit[2], dateSplit[1]));

    }
}
