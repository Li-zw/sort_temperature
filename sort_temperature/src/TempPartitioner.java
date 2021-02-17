import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * 功能描述 指定分区
 * @Author LZW
 * @CreateTime 2020/05/30 10:02
 * @UpdateTime 2020/05/30 10:02
 * @Version 1.0.0
 */

public class TempPartitioner extends Partitioner<Temperature, NullWritable> {
    /*
     * numPartition参数：建立多少个分区
     */
    @Override
    public int getPartition(Temperature temperature, NullWritable nullWritable, int numPartition) {
        //获取月份，并将它转为整型
        int month = Integer.parseInt(temperature.getDate().substring(5, 7));
        if (month == 1) {
            //放入1号分区中
            return 1 % numPartition;
        } else if (month == 2) {
            return 2 % numPartition;
        } else if (month == 3) {
            return 3 % numPartition;
        } else if (month == 4) {
            return 4 % numPartition;
        } else if (month == 5) {
            return 5 % numPartition;
        } else if (month == 6) {
            return 6 % numPartition;
        } else if (month == 7) {
            return 7 % numPartition;
        } else if (month == 8) {
            return 8 % numPartition;
        } else if (month == 9) {
            return 9 % numPartition;
        } else if (month == 10) {
            return 10 % numPartition;
        } else if (month == 11) {
            return 11 % numPartition;
        } else {
            //放入0号分区
            return 12 % numPartition;
        }

    }
}
