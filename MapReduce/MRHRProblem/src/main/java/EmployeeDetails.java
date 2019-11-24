import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class EmployeeDetails implements Writable {
    private String name;
    private String id;
    private  String dayOfBirth;

    public EmployeeDetails(){super();}

    public EmployeeDetails(String name, String id, String dayOfBirth){
        this.name = name ;
        this.id = id;
        this.dayOfBirth = dayOfBirth;
    }

    public String getName(){
        return  this.name;
    }

    public String getId(){
        return this.id;
    }

    public String getDayOfBirth(){
        return this.dayOfBirth;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException{
        name = WritableUtils.readString(dataInput);
        id = WritableUtils.readString(dataInput);
        dayOfBirth = WritableUtils.readString(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException{
        WritableUtils.writeString(dataOutput, name);
        WritableUtils.writeString(dataOutput, id);
        WritableUtils.writeString(dataOutput, dayOfBirth);
    }
    @Override
    public String toString(){
        return "ID: " + this.id + " Name: " + this.name + " Birth Day: " + this.dayOfBirth;
    }
}
