package hadoopjobs;

/*this program reads the data from HDFS single file and reformat it and stores in local Machine for a Sortable Bar Graph in case of multiple MR*/
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

public class SBarMultiGen {

	public static void main(String[] args) throws IOException {

	}

	String fileCopy(String arg, String opt) throws IOException {
		String uri1 = "/home/hadoop/git/LocalDNSAnalysisTool/DNSAnalysisTool/WebContent/files/" + arg;
		FileWriter fw = new FileWriter(uri1); /* create a new file */
		BufferedWriter bw1 = new BufferedWriter(fw);
		Configuration conf = new Configuration();
		File f;
		f = new File(uri1);
		f.createNewFile();
		String line, temp;
		int i = 0, a, c;
		FileSystem local[] = new FileSystem[100];

		local[i] = FileSystem.get(
				URI.create("hdfs://master:54310/user/hadoop/output/logs/" + arg
						+ "/part-00000"), conf);

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					local[i].open(new Path(
							"hdfs://master:54310/user/hadoop/output/logs/"
									+ arg + "/part-00000"))));
											/*Generating the desired output as per the requirement */
			if (opt.matches("type")) {
				bw1.write("\ttype\tnumber\n");
			}
			if (opt.matches("query")) {
				bw1.write("\tquery\tnumber\n");
			}
			if (opt.matches("src")) {
				bw1.write("\tsource\tnumber\n");
			}
			if (opt.matches("domains")) {
				bw1.write("\tIP\tnumber\n");
			}
			if (opt.matches("IP's")) {
				bw1.write("\tdomain\tnumber\n");
			}
			/* generating the tsv with required format */
			line = br.readLine();
			while (line != null) {
				a = line.indexOf('\t');
				c = line.length();
				temp = line.substring(a, c);
				bw1.write("\t" + line.substring(0, a) + temp + "\n");
				line = br.readLine();

			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("encountered an error");
		}

		bw1.close();
		return ("files/"+arg);
	}
}