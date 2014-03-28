package hadoopjobs;


/*COMPUTING THE IP ADDRESSES COUNT FROM THE HADOOP FOR A PARTICULAR DOMAIN */

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
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import java.io.IOException;
import java.util.Iterator;


public class DomainIpMapReduce extends Configured implements Tool {
	@SuppressWarnings("static-access")
	
	public static String domain;
	public int run(String arg[]) throws IOException {
		String uri1 ="hdfs://master:54310/user/hadoop/output/logs/"+arg[0] ; 
		JobConf conf = new JobConf(DomainIpMapReduce.class);
		conf.set("cv",arg[1]);
		//System.out.println(conf.get("cv"));
		conf.setJobName("DomainIp");
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

	 static class Map extends MapReduceBase implements
	Mapper<LongWritable, Text, Text, IntWritable> {
		 private static String N;
		 public void configure(JobConf job) { 
			 N=job.get("cv");
		 //System.out.println(N);
		 }
		 
		private  final  static   IntWritable one = new IntWritable(1);
		public void map(LongWritable key, Text value,
				OutputCollector<Text, IntWritable> output, Reporter reporter)
				throws IOException {
				
		String Record = new String(value.toString());
		String rec[] = Record.split(" ");
		if(N.compareTo(rec[5])==0)		/*comparing the required domain with the domains in the data*/
			{
			String c =rec[3].substring(0, rec[3].indexOf("#"));
			output.collect(new Text(c),one);
			
			}	
		
				
		}
}
	  static class Reduce extends MapReduceBase implements
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


