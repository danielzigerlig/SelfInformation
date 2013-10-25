package ch.hsr.pl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.hsr.bll.EnvironmentVariables;
import ch.hsr.bll.HardwareInformation;
import ch.hsr.bll.NetworkInformation;
import ch.hsr.bll.SystemInformation;

/**
 * Servlet implementation class SelfInformation
 */
/**
 * @author dzigerli@hsr.ch (Daniel Zigerlig)
 *
 */
public class SelfInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelfInformationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		printHeader(response, request);
		printForm(response, request);
		printFooter(response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void printHeader(HttpServletResponse response, HttpServletRequest request) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 5//EN\" \"http://www.w3.org/TR/html5/html5.dtd\">");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<title>SelfInformation</title>");
		out.println("<LINK href=\"" + request.getContextPath() + "/css/selfInformation.css"
				+ "\" rel=\"stylesheet\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id=\"content\">");
		out.println("<h1>Self Information</h1>");
	}

	protected void printFooter(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void printForm(HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		PrintWriter out = response.getWriter();
		out.println(new HardwareInformation().getHTML());
		out.println(new NetworkInformation().getHTML());
		out.println(new SystemInformation().getHTML());
		out.println(new EnvironmentVariables().getHTML());
	}

	protected static String removeQueryString(String aURI) {
		int i = aURI.indexOf('?');
		if (i != -1) {
			aURI = aURI.substring(0, i);
		}
		return aURI;
	}
}
