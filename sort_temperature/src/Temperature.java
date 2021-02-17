import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 功能描述 温度实体类
 * @Author LZW
 * @CreateTime 2020/05/29 17:00
 * @UpdateTime 2020/05/29 17:00
 * @Version 1.0.0
 */

public class Temperature implements WritableComparable<Temperature> {
    private String date;
    private String time;
    private String months;
    private String temp;

    /**
     * 自定义比较
     * @param o 传入参数
     * @return
     */
    @Override
    public int compareTo(Temperature o) {

        if (this.getTemp().substring(0, 2).compareTo(o.getTemp().substring(0, 2)) >= 0) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * 序列化
     * @param dataOutput
     * @throws IOException
     */
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.date);
        dataOutput.writeUTF(this.time);
        dataOutput.writeUTF(this.temp);

    }

    /**
     * 反序列化
     * @param dataInput
     * @throws IOException
     */
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.date = dataInput.readUTF();
        this.time = dataInput.readUTF();
        this.temp = dataInput.readUTF();
    }

    /**
     * 重写toString()方法
     * @return
     */
    @Override
    public String toString() {
        return "Temperature[date=" + date + ",time=" + time + ",temp=" + temp + "]";
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }
}
