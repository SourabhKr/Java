import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    public  void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] wordList = line.split("\\s");

        for (String eachWord: wordList) {
            char[] eachCharacter = eachWord.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
           context.write(new Text(Character.toString(eachCharacter[0])), new IntWritable(eachWord.length()));
        }

    }
}
