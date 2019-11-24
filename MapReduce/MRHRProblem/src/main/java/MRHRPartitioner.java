import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;

public class MRHRPartitioner  extends Partitioner<Text, EmployeeDetails> implements Configurable {

    private Configuration configuration;
    HashMap<String, Integer> months = new HashMap<String, Integer>();

    /**
     * Set up the months hash map in the setConf method.
     */
    public void setConf(Configuration configuration) {
        this.configuration = configuration;
        months.put("1", 0);
        months.put("2", 1);
        months.put("3", 2);
        months.put("4", 3);
        months.put("5", 4);
        months.put("6", 5);
        months.put("7", 6);
        months.put("8", 7);
        months.put("9", 8);
        months.put("10", 9);
        months.put("11", 10);
        months.put("12", 11);
    }



    public Configuration getConf() {
        return configuration;
    }

    public int getPartition(Text key, EmployeeDetails value, int numReduceTasks) {
        return (int) (months.get(key.toString()));
    }

}
