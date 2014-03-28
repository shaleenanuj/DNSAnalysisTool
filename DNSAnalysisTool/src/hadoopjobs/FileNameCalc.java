package hadoopjobs;
/* This program Calculates the file names of the required requests*/
import java.util.*;
import java.text.*;
public class FileNameCalc {

	
	public String [] calculateNames(int [] values )
	{
		Date dNow,dOld;
		String param[] = new String [250];
		int hoursToAdd=1;
		
		Calendar c = Calendar.getInstance();	/*set the end date*/
		c.set(Calendar.MONTH,values[6]-1);
		c.set(Calendar.DATE,values[7]);
		c.set(Calendar.YEAR,values[5]);
		c.set(Calendar.HOUR_OF_DAY,values[8]);
		
		Calendar cal = Calendar.getInstance();	/*set the start date*/
		cal.set(Calendar.MONTH,values[1]-1);
		cal.set(Calendar.DATE,values[2]);
		cal.set(Calendar.YEAR,values[0]);
		cal.set(Calendar.HOUR_OF_DAY,values[3]);
		int i =0;
		do		/*increments the start date to the end date and calculates the file names hour by hour*/         
		{
			 cal.add(Calendar.HOUR, hoursToAdd);
			 dOld=cal.getTime();
			 SimpleDateFormat ft = new SimpleDateFormat ("ddMMyyyyH");
			 param[i]="DNS"+ft.format(dOld).toString();
			 i++;
		}
		while(cal.before(c));
		return param;	/*return the calculated file names*/
	}	

}