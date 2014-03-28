package hadoopjobs;

/*this program reads the data from HDFS and reformat it for Cross Filter and stores it on local machine*/
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

public class CfilterGen {

	

	String fileCopy(String arg[]) throws IOException {
		String uri1 = "/home/hadoop/git/LocalDNSAnalysisTool/DNSAnalysisTool/WebContent/files/" + arg[0];
		FileWriter fw = new FileWriter(uri1);
		BufferedWriter bw1 = new BufferedWriter(fw);
		Configuration conf = new Configuration();
		File f;
		f = new File(uri1);
		f.createNewFile();
		String line, temp;
		int i = 0, a, c,k=0;
		while(arg[k]!=null){k++;}
		FileSystem local[] = new FileSystem[100];
		for (i = 2; i < k; i++) {
			
			local[i] = FileSystem.get(		/*fetching the required files*/
					URI.create("hdfs://master:54310/user/hadoop/output/"
							+ arg[i] + "/"+arg[1]+"/part-00000"), conf);

			try {					/*reading the required files*/
				BufferedReader br = new BufferedReader(new InputStreamReader(
						local[i].open(new Path(
								"hdfs://master:54310/user/hadoop/output/"
										+ arg[i] +"/"+arg[1] +"/part-00000"))));

				if (i == 2) {	/*generating the required file format*/
					bw1.write("date,hits\n");
				}
				line = br.readLine();
				while (line != null) {
					a = line.indexOf('\t');
					c = line.length();
					temp = line.substring(a, c);
					bw1.write(arg[i].substring(3, 5) + "-"
							+ arg[i].substring(5, 7) + ":"
							+ arg[i].substring(11, (arg[i].length())) + ","
							+ temp.trim() + "\n");
					line = br.readLine();
				}
				br.close();
			} catch (Exception e) {
				System.out.println("encountered an error");
			}


		}
		bw1.close();
	return ("files/"+arg[0]);
	}
}
