import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.io.Text;
import java.io.IOException;

public class WordCountReducer extends Reducer<Text,IntWritable,Text,IntWritable> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
        throws IOException, InterruptedException {
        int totalWordCharacterCount = 0;
        int count = 0;
        for(IntWritable wordList : values){
            totalWordCharacterCount += wordList.get();
            count++;
        }
        context.write(key, new IntWritable((int)totalWordCharacterCount/count));

    }
}
