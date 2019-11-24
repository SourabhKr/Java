import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReducer extends Reducer<IntWritable,SumAndCount, Text,Text> {

    @Override
    public void reduce(IntWritable key, Iterable<SumAndCount> values, Context context)
        throws IOException, InterruptedException {

        int sum = 0; int count = 0;

        for(SumAndCount eachList : values){
           sum = eachList.getSum();
           count = eachList.getCount();
        }
        float avg = (sum/(float)count);

        String op="Average length of " + count + " words = " + avg;
        context.write(new Text(op), new Text(""));

    }
}
