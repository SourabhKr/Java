import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountCombiner extends Reducer<IntWritable, SumAndCount, IntWritable, SumAndCount> {
    public  void reduce(IntWritable key, Iterable<SumAndCount> values,  Context context)
            throws IOException, InterruptedException {

        int sum = 0; int count = 0;
        for (SumAndCount eachEntry: values
             ) {
            count += eachEntry.getCount();
            sum += eachEntry.getSum();
        }
        context.write(new IntWritable(1), new SumAndCount(sum, count));
    }
}
