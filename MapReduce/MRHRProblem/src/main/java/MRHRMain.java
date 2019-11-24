import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;

public class MRHRMain extends Configured implements Tool {
    public static void main(String[] args) throws Exception{
        int returnsStatus = ToolRunner.run(new Configuration(), new MRHRMain(), args);
        System.exit(returnsStatus);
    }

    public int run(String[] args) throws IOException{

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "HR Problem");

        job.setJobName("HR Problem");

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(EmployeeDetails.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setJarByClass(MRHRMain.class);

        job.setMapperClass(MRHRMapper.class);
        job.setPartitionerClass(MRHRPartitioner.class);
        job.setReducerClass(MRHRReducer.class);

        job.setNumReduceTasks(12);


        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        try {
            return job.waitForCompletion(true) ? 0 : 1;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

}
