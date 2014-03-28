package hadoopjobs;


/*COMBINING ALREADY STORED RESULTS*/

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.mapred.lib.MultipleInputs;
import org.apache.hadoop.util.Tool;
import java.io.IOException;
import java.util.Iterator;

public class MultiMapReduce extends Configured implements Tool {
	
	
	public int run(String arg[]) throws IOException {
		String uri1 ="hdfs://master:54310/user/hadoop/output/logs/"+arg[0] ; 
		JobConf conf = new JobConf(MultiMapReduce.class);
		conf.setJobName("MultiMR");
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(Text.class);
		conf.setReducerClass(Reduce.class);
		conf.setOutputFormat(TextOutputFormat.class);
		int i=2;
		while(arg[i]!=null)
		{
			MultipleInputs.addInputPath(conf,new Path("hdfs://master:54310/user/hadoop/output/"+arg[i]+"/"+arg[1]+"/part-00000"),TextInputFormat.class,Map.class );
			i++;
		}
		
		FileOutputFormat.setOutputPath(conf, new Path(uri1));
		JobClient.runJob(conf);
		return 0;
	}

	public static class Map extends MapReduceBase implements
	Mapper<LongWritable, Text, Text, Text> {
		
		public void map(LongWritable key, Text value,
		OutputCollector<Text, Text> output, Reporter reporter)
		throws IOException {
		String Record = new String(value.toString());
		Parser1 p = new Parser1(Record);
		output.collect(new Text(p.key),new Text(p.value));
		}
}

public static class Reduce extends MapReduceBase implements
	Reducer<Text, Text, Text, IntWritable> {

	public void reduce(Text key, Iterator<Text> values,
	OutputCollector<Text, IntWritable> output, Reporter reporter)
	throws IOException {
	int count = 0;
	while (values.hasNext()) {
	Text ele = values.next();
	count += Integer.parseInt(ele.toString());
	}
	output.collect(key, new IntWritable(count));
	}
}



}