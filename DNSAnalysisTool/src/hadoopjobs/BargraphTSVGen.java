package hadoopjobs;
/*this program reads the data from HDFS and reformat it and stores in local Machine for a Sortable Bar Graph*/
import org.apache.hadoop.conf.Configuration;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class BargraphTSVGen {

	public static void main(String[] args) throws IOException {
		
	}

	String fileCopy(String arg[]) throws IOException {
		//String arg[] = new String[100];
		
		String uri1 = "/home/hadoop/git/LocalDNSAnalysisTool/DNSAnalysisTool/WebContent/files/" + arg[0];
		FileWriter fw = new FileWriter(uri1);
		//System.out.println(uri1);
		BufferedWriter bw1 = new BufferedWriter(fw);
		Configuration conf = new Configuration();
		File f;
		f = new File(uri1);
		f.createNewFile();
		String line, temp;
		int i = 0, a, c,k=0;
		while(arg[k]!=null){k++;}
		//System.out.println(arg[k]);
		FileSystem local[] = new FileSystem[100];
		
		for (i = 2; i < k; i++) {
			
			local[i] = FileSystem.get(
					URI.create("hdfs://master:54310/user/hadoop/output/"
							+ arg[i] + "/"+arg[1]+"/part-00000"), conf);

			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						local[i].open(new Path(
								"hdfs://master:54310/user/hadoop/output/"
										+ arg[i] +"/"+arg[1] +"/part-00000"))));

				if (i == 2) {
					bw1.write("\ttype\tnumber\n");
				}
				line = br.readLine();
				while (line != null) {
					a = line.indexOf('\t');
					c = line.length();
					temp = line.substring(a, c);
					bw1.write("\t"+line.substring(0, a)+temp + "\n");
					line = br.readLine();

				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("encountered an error");
			}

		}
		bw1.close();
		//System.out.println("hello123");
		return ("files/"+arg[0]);
	}
}