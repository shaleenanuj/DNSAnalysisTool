package hadoopjobs;


/*COMPUTING THE DOMAIN COUNT FROM THE HADOOP FOR A PARTICULAR IP ADDRESS */

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

public class IpDomainMapReduce extends Configured implements Tool {
	
	//public static String ip;
	@SuppressWarnings("static-access")
	public int run(String arg[]) throws IOException {
		String uri1 ="hdfs://master:54310/user/hadoop/output/logs/"+arg[0] ; 
		//this.ip=arg[1];
		JobConf conf = new JobConf(IpDomainMapReduce.class);
		conf.set("cv",arg[1]);
		conf.setJobName("IpDomain");
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		conf.setReducerClass(Reduce.class);
		conf.setOutputFormat(TextOutputFormat.class);
		int i=2;
		while(arg[i]!=null)
		{
			MultipleInputs.addInputPath(conf,new Path("hdfs://master:54310/user/hadoop/input/logs/"+arg[i]),TextInputFormat.class,Map.class );
			i++;
		}
		
		FileOutputFormat.setOutputPath(conf, new Path(uri1));
		JobClient.runJob(conf);
		return 0;
	}

	public static class Map extends MapReduceBase implements
	Mapper<LongWritable, Text, Text, IntWritable> {
		private final static IntWritable one = new IntWritable(1);
		private static String N;
		 public void configure(JobConf job) { 
			 N=job.get("cv");
		 System.out.println(N);
		 }
		public void map(LongWritable key, Text value,
				OutputCollector<Text, IntWritable> output, Reporter reporter)
		throws IOException {
		String Record = new String(value.toString());
		String domain;
		String rec[] = Record.split(" ");
		String src = rec[3].substring(0, rec[3].indexOf("#"));
		System.out.println(src);
		if(N.compareTo(src)==0)		/*comparing the required ip with the ip's in the data*/
		{
			domain =rec[5];
			output.collect(new Text(domain),one);
		}
		
		
		}
}

	public static class Reduce extends MapReduceBase implements
	Reducer<Text, IntWritable, Text, IntWritable> {

		public void reduce(Text key, Iterator<IntWritable> values,
				OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException
		{
		int count = 0;
		while (values.hasNext()) {
			count += values.next().get();
		}
		output.collect(key, new IntWritable(count));

	}
}



}