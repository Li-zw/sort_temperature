/**
 * 功能描述 主函数运行类
 * @Author LZW
 * @CreateTime 2020/05/30 11:29
 * @UpdateTime 2020/05/30 11:29
 * @Version 1.0.0
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TempMain {
    public static void main(String[] args) throws Exception{
        //  创建一个job
        Job job = Job.getInstance(new Configuration());
        job.setJarByClass(TempMain.class);

        //指定job的mapper和输出的类型   k2  v2
        job.setMapperClass(TempMapper.class);
        job.setMapOutputKeyClass(Temperature.class);
        job.setMapOutputValueClass(NullWritable.class);

        //指定任务的分区规则
        job.setPartitionerClass(TempPartitioner.class);
        //指定建立几个分区
        job.setNumReduceTasks(12);

        //指定job的输入和输出的路径
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        //执行任务
        job.waitForCompletion(true);
    }
}
