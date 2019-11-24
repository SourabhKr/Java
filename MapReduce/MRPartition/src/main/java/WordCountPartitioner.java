import java.util.HashMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Partitioner;

public class WordCountPartitioner extends Partitioner<Text, Text> implements  Configurable{
    private  Configuration conf;
    HashMap<String, Integer> partitioner = new HashMap<String, Integer>();

    //TODO: Finish this, so that the Alice problem can be solved with Partition.
    public void setConf(Configuration configuration){
        this.conf = configuration;
        partitioner.put("a", 0);
    }

    public Configuration getConf() {
        return conf;
    }

    //TODO: Change this to work with single character. Currently this is only a prototype
    @Override
    public int getPartition(Text key, Text value, int numPartitions) {
        return (int)(partitioner.get(value.toString()));
    }
}
