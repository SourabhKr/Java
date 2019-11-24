import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public  class MRHRReducer extends Reducer<Text, EmployeeDetails, Text, Text> {
    public void reduce(Text key, EmployeeDetails value, Context context)
            throws IOException, InterruptedException {
        context.write( key, new Text(value.toString()));
    }
}