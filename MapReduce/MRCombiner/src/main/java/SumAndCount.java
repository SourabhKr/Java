import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.WriteAbortedException;

public class SumAndCount implements Writable {

    int sum;
    int count;

    public SumAndCount(){super();}

    public SumAndCount(int sum, int count){
        this.sum = sum;
        this.count = count;
    }

    public int getSum(){
        return(sum);
    }

    public void setSum(int individualSum){
        this.sum = individualSum;
    }

    public int getCount(){
        return count;
    }

    public void getSum(int individualCount){
        this.count = individualCount;
    }

    @Override
    public  void  readFields(DataInput dataInput) throws IOException {
        sum = WritableUtils.readVInt(dataInput);
        count = WritableUtils.readVInt(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException{
        WritableUtils.writeVInt(dataOutput, sum);
        WritableUtils.writeVInt(dataOutput, count);
    }



}
