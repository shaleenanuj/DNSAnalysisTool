package container;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PerformAnalytics
 */
public class PerformAnalytics extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PerformAnalytics() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// out = response.getWriter();
		HttpSession s;

		if (request.getSession(false) == null)
			response.sendRedirect("Login.jsp");
		else {
			s = request.getSession(false);
			String basis1 = request.getParameter("basis1");
			String basis2 = request.getParameter("basis2");
			String basis3 = request.getParameter("basis3");
			String d1 = request.getParameter("date1");
			String t1 = request.getParameter("time1");
			String d2 = request.getParameter("date2");
			String t2 = request.getParameter("time2");
			String ip = request.getParameter("ipaddress");
			String domain = request.getParameter("domain");
			String user_id;
			user_id = (String) s.getAttribute("user_id");
			String name = (String) s.getAttribute("name");

			/*
			 * out.println(basis1); out.println(basis2); out.println(basis3);
			 * out.println(d1); out.println(t1); out.println(d2);
			 * out.println(t2); out.println(user_id); out.println(ip);
			 * out.println(domain);
			 */
			/*
			 * try { Thread.sleep(1000); } catch (InterruptedException e1) { //
			 * TODO Auto-generated catch block e1.printStackTrace(); }
			 */
			String[] para_list = new String[11];
			para_list[0] = basis1;
			para_list[1] = basis2;
			para_list[2] = basis3;
			para_list[3] = d1;
			para_list[4] = t1;
			para_list[5] = d2;
			para_list[6] = t2;
			para_list[7] = user_id;
			para_list[8] = name;
			para_list[9] = ip;
			para_list[10] = domain;

			Date dNow, dOld;
			int[] dates = new int[11];

			dates[0] = Integer.parseInt(d1.substring(0, d1.indexOf("-")));
			dates[1] = Integer.parseInt(d1.substring(d1.indexOf("-") + 1,
					d1.lastIndexOf("-")));
			dates[2] = Integer.parseInt(d1.substring(d1.lastIndexOf("-") + 1,
					d1.length()));
			dates[3] = Integer.parseInt(t1.substring(0, t1.indexOf(":")));
			dates[4] = Integer.parseInt(t1.substring(t1.indexOf(":") + 1,
					t1.length()));
			dates[5] = Integer.parseInt(d2.substring(0, d2.indexOf("-")));
			dates[6] = Integer.parseInt(d2.substring(d2.indexOf("-") + 1,
					d2.lastIndexOf("-")));
			dates[7] = Integer.parseInt(d2.substring(d2.lastIndexOf("-") + 1,
					d2.length()));
			dates[8] = Integer.parseInt(t2.substring(0, t2.indexOf(":")));
			dates[9] = Integer.parseInt(t2.substring(t2.indexOf(":") + 1,
					t2.length()));

			Calendar c = Calendar.getInstance(); /* set the end date */
			c.set(Calendar.MONTH, dates[6] - 1);
			c.set(Calendar.DATE, dates[7]);
			c.set(Calendar.YEAR, dates[5]);
			c.set(Calendar.HOUR_OF_DAY, dates[8]);
			c.set(Calendar.MINUTE, dates[4]);

			Calendar cal = Calendar.getInstance(); /* set the start date */
			cal.set(Calendar.MONTH, dates[1] - 1);
			cal.set(Calendar.DATE, dates[2]);
			cal.set(Calendar.YEAR, dates[0]);
			cal.set(Calendar.HOUR_OF_DAY, dates[3]);
			cal.set(Calendar.MINUTE, dates[9]);

			if (dates[6] == dates[1] && dates[5] == dates[0]
					&& dates[7] == dates[2]) {
				if (dates[3] < dates[8]) {
					System.out.println("1asdafw");
					//response.sendRedirect("ErrorUserHome.jsp");
					
				}

			}
			/*
			 * Date d =new Date(); if((d.compareTo(cal.getTime()))<0 ||
			 * (d.compareTo(c.getTime()))<0 ) { System.out.println("hello");
			 * response.sendRedirect("ErrorUserHome.jsp"); }
			 */

			try {
				hadoopjobs.CallAnalytics hac = new hadoopjobs.CallAnalytics();

				String a= hac.callFunction(para_list);
				//System.out.println(a);
				s.setAttribute("file_path", a);
				s.setAttribute("tsv_path", "\"" + a + "\"");

				if (para_list[0].equals("ServerInteraction")) {
					if (para_list[1].equals("Type")) {
						System.out.print("Oh god!!");
						response.sendRedirect("bar_graphtest.jsp");
					} else if (para_list[1].equals("Ips")) {
						response.sendRedirect("bar_graphsource.jsp");
					} else if (para_list[1].equals("Query")) {
						response.sendRedirect("CrossFilterQuery.jsp");
					}
				}	
				 else if (para_list[0].equals("Domain-HostInteraction")) {
					 if (para_list[2].equals("Dip")) {
				 			
				 			response.sendRedirect("bar_graphip.jsp");
				 	}	
					 if (para_list[2].equals("Ipd")) {
					 			response.sendRedirect("bar_graphdomain.jsp");
					 	}  
					 	
				} 
				
				 else {
					 	response.sendRedirect("ErrorUserHome.jsp");
						//System.out.println("I was here dude");
				 }

			} catch (NullPointerException e) {
					response.sendRedirect("NewUserHome.jsp");
					e.printStackTrace();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
