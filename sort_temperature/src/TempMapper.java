import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * 功能描述 指定输入格式
 * @Author LZW
 * @CreateTime 2020/05/29 17:41
 * @UpdateTime 2020/05/29 17:41
 * @Version 1.0.0
 */

public class TempMapper extends Mapper<LongWritable, Text,Temperature, NullWritable> {

    //数据 2019-10-01,14:21:02,34c
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String data = value.toString();
        //分词
        String [] words = data.split(",");
        //创建温度对象
        Temperature temp = new Temperature();
        //日期
        temp.setDate(words[0]);
        //时间
        temp.setTime(words[1]);
        //温度
        temp.setTemp(words[2]);

        context.write(temp,NullWritable.get());

    }
}
