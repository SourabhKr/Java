import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<LongWritable, Text, IntWritable, SumAndCount> {
    @Override
    public  void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] wordList = line.split("\\s");

        for (String eachWord: wordList) {
            String word = eachWord.replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty())
                context.write(new IntWritable(1), new SumAndCount(eachWord.length(), 1));
            else continue;
        }

    }
}
