package hadoopjobs;
import java.io.IOException;
import java.util.Date;
/*this program calls various jobs */
public class CallAnalytics {

	public static void main(String args[]) {
		String arg[] = new String[11];
		arg[0] = "HostInteraction";
		arg[1] = "Ipd";
		arg[2] = "2014-03-24";
		arg[3] = "21:04";
		arg[4] = "2014-03-24";
		arg[5] = "23:08";
		arg[6] = "1230";
		arg[7] = "abc123";
		arg[8] = "192.168.1.77";
		//String n = callFunction(arg);
	//	System.out.println(n);
	}

	public String callFunction(String[] param) { /*
												 * function to call the desired
												 * mapReduce program
												 */
		String option1 = param[0]; /* basic selection */
		String option2 = param[1]; /* special selection */
		String option3 = param[2];	/*deeper selection*/
		String sdate = param[3]; /* start date */
		String stime = param[4]; /* start time */
		String edate = param[5]; /* end date */
		String etime = param[6]; /* end time */
		String uid = param[7]; /* user id */
		String name = param[8]; /* user name */
		String ip = param[9]; /* entered ip  */
		String domain = param[10]; /*entered domain*/ 
		int[] dates = new int[11];
		dates[0] = Integer.parseInt(sdate.substring(0, sdate.indexOf("-")));
		dates[1] = Integer.parseInt(sdate.substring(sdate.indexOf("-") + 1,
				sdate.lastIndexOf("-")));
		dates[2] = Integer.parseInt(sdate.substring(sdate.lastIndexOf("-") + 1,
				sdate.length()));
		dates[3] = Integer.parseInt(stime.substring(0, stime.indexOf(":")));
		dates[4] = Integer.parseInt(stime.substring(stime.indexOf(":") + 1,
				stime.length()));
		dates[5] = Integer.parseInt(edate.substring(0, edate.indexOf("-")));
		dates[6] = Integer.parseInt(edate.substring(edate.indexOf("-") + 1,
				edate.lastIndexOf("-")));
		dates[7] = Integer.parseInt(edate.substring(edate.lastIndexOf("-") + 1,
				edate.length()));
		dates[8] = Integer.parseInt(etime.substring(0, etime.indexOf(":")));
		dates[9] = Integer.parseInt(etime.substring(etime.indexOf(":") + 1,
				etime.length()));

		/*
		 * int p=0; while(p<10) { System.out.println(dates[p]); p++; }
		 */

		FileNameCalc fcn = new FileNameCalc();
		String names[] = fcn.calculateNames(dates);
		int i = 0;

		/* generating the output file name */
		java.text.DateFormat dateFormat = new java.text.SimpleDateFormat(
				"yyyyMMddHHmmss");
		Date ds = new Date();
		String ts = (dateFormat.format(ds));

		String ret = null;
		String pass[] = new String[200];

		while (names[i] != null) {
			 //System.out.println(names[i]);
			i++;
		}
		// System.out.println(i);
		if (i == 1) {

			if (option1.equals("ServerInteraction")) { /*
														 * calling server
														 * interaction TYPE
														 * counts in case of one
														 * hour
														 */
				if (option2.equals("Type")) {
					int j = 0, k = 2;
					pass[0] = ts + uid + ".tsv";
					pass[1] = "type";
					while (names[j] != null) {
						pass[k] = names[j];
						j++;
						k++;
					}
					SBarGen sbg = new SBarGen();
					try {
						ret = sbg.fileCopy(pass);
					} catch (IOException e) {

						System.out.println("we are sorry for inconvinience");
					}
					return ret;
				}
				if (option2.equals("Query")) { /*
												 * calling server interaction
												 * QUERY counts in case of one
												 * hour
												 */
				/*	int j = 0, k = 2;
					pass[0] = ts + uid + ".tsv";
					pass[1] = "query";
					while (names[j] != null) {
						pass[k] = names[j];
						j++;
						k++;
					}
					SBarGen sbg = new SBarGen();
					try {
						ret = sbg.fileCopy(pass);
					} catch (IOException e) {

						System.out.println("we are sorry for inconvinience");
					}*/
					return ("Please widen your range");
					
				}
				if (option2.equals("Ips")) { /*
											 * calling server interaction SOURCE
											 * HITS counts in case of one hour
											 */
					int j = 0, k = 2;
					pass[0] = ts + uid + ".tsv";
					pass[1] = "src";
					while (names[j] != null) {
						pass[k] = names[j];
						j++;
						k++;
					}
					SBarGen sbg = new SBarGen();
					try {
						ret = sbg.fileCopy(pass);
					} catch (IOException e) {

						System.out.println("we are sorry for inconvinience");
					}
					return ret;
				}
			}
			if (option1.equals("Domain-HostInteraction")) {
				if (option3.equals("Ipd")) {
					return ("please widen your time range");
				}
				if (option3.equals("Dip")) {
					return ("please widen your time range");
				}

			}

		}

		else {
			if (option1.equals("ServerInteraction")) {

				if (option2.equals("Type")) { /*
											 * calling server interaction TYPE
											 * counts in case of more than hour
											 */
					int j = 0, k = 2;
					pass[0] = ts + uid + ".tsv";
					pass[1] = "type";
					while (names[j] != null) {
						pass[k] = names[j];
						j++;
						k++;
					}
					MultiMapReduce mmr = new MultiMapReduce();
					SBarMultiGen sbg = new SBarMultiGen();
					try {
						mmr.run(pass);
						ret = sbg.fileCopy(pass[0], pass[1]);
					} catch (IOException e) {

						System.out.println("we are sorry for inconvinience");
					}
					return ret;
				}
				if (option2.equals("Query")) { /*
												 * calling server interaction
												 * QUERY HITS in case of more
												 * than hour
												 */
					int j = 0, k = 2;
					pass[0] = ts + uid + ".csv";
					pass[1] = "query";
					while (names[j] != null) {
						pass[k] = names[j];
						j++;
						k++;
					}

					CfilterGen cf = new CfilterGen();
					try {

						ret = cf.fileCopy(pass);
					} catch (IOException e) {

						System.out.println("we are sorry for inconvinience");
					}
					return ret;
				}
				if (option2.equals("Ips")) { /*
											 * calling server interaction SOURCE
											 * IP HITS in case of more than hour
											 */
					int j = 0, k = 2;
					pass[0] = ts + uid + ".tsv";
					pass[1] = "src";
					while (names[j] != null) {
						pass[k] = names[j];
						j++;
						k++;
					}
					MultiMapReduce mmr = new MultiMapReduce();
					SBarMultiGen sbg = new SBarMultiGen();
					try {
						mmr.run(pass);
						ret = sbg.fileCopy(pass[0], pass[1]);

					} catch (IOException e) {

						System.out.println("we are sorry for inconvinience");
					}
					return ret;
				}
			}
			if (option1.equals("Domain-HostInteraction")) {
				if (option3.equals("Ipd")) {/*
											 * calling host interaction which
											 * counts domains visited by a
											 * particular ip address
											 */
					int j = 0, k = 2;
					pass[0] = ts + uid + ".tsv";
					pass[1] = ip;
					while (names[j] != null) {
						pass[k] = names[j];
						j++;
						k++;
					}
					IpDomainMapReduce ipd = new IpDomainMapReduce();
					SBarMultiGen sbg = new SBarMultiGen();
					try {
						ipd.run(pass);
						ret = sbg.fileCopy(pass[0], "IP's");
					} catch (IOException e) {
						System.out.println("we are sorry for inconvinience");
						e.printStackTrace();
					}
					return ret;
				}

				if (option3.equals("Dip")) { /*
											 * calling host interaction which
											 * counts ip's visiting a particular
											 * domain
											 */
					int j = 0, k = 2;
					pass[0] = ts + uid + ".tsv";
					pass[1] = domain;		/*parameter to be matched for domain*/
					while (names[j] != null) {
						pass[k] = names[j];
						j++;
						k++;
					}
					DomainIpMapReduce ipd = new DomainIpMapReduce();
					SBarMultiGen sbg = new SBarMultiGen();
					try {
						ipd.run(pass);
						ret = sbg.fileCopy(pass[0], "domains");
					} catch (IOException e) {
						System.out.println("we are sorry for inconvinience");

					}
					return ret;
				}
			}

		}
		return null;
	}
}