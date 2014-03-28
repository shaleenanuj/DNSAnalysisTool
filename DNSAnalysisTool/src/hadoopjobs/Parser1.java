package hadoopjobs;

public class Parser1 {
	String key,value;
	int i;
	Parser1(String r)
	{
		String rec[] = r.split("	");
		this.key = rec[0];
		this.value = rec[1];
		this.i=Integer.parseInt(value);
	}
	
	
}