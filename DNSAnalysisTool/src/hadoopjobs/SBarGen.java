package hadoopjobs;

/*this program reads the data from HDFS files and reformat it and stores in local Machine for a Sortable Bar Graph*/
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

public class SBarGen {

	public static void main(String[] args) throws IOException {

	}

	String fileCopy(String arg[]) throws IOException {

		String uri1 = "/home/hadoop/git/LocalDNSAnalysisTool/DNSAnalysisTool/WebContent/files/"
				+ arg[0]; /* create the destination file */
		FileWriter fw = new FileWriter(uri1);
		BufferedWriter bw1 = new BufferedWriter(fw);
		Configuration conf = new Configuration();
		File f;
		f = new File(uri1);
		f.createNewFile();
		String line, temp;
		int i = 0, a, c, k = 0;
		while (arg[k] != null) {
			k++;
		}
		FileSystem local[] = new FileSystem[100];

		for (i = 2; i < k; i++) {

			local[i] = FileSystem.get(
					URI.create("hdfs://master:54310/user/hadoop/output/"
							+ arg[i] + "/" + arg[1] + "/part-00000"), conf);

			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						local[i].open(new Path( /* reading the source files */
						"hdfs://master:54310/user/hadoop/output/" + arg[i]
								+ "/" + arg[1] + "/part-00000"))));

				if (i == 2) {/* generating the desired output */
					if (arg[1].matches("type")) {
						bw1.write("\ttype\tnumber\n");
					}
					if (arg[1].matches("query")) {
						bw1.write("\tquery\tnumber\n");
					}
					if (arg[1].matches("src")) {
						bw1.write("\tsource\tnumber\n");
					}
				}
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

		}
		bw1.close();
		return ("files/" + arg[0]);
	}
}
