

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.BlogEntry;
import util.UtilDB;

/**
 * Servlet implementation class AddEntry
 */
@WebServlet("/AddEntry")
public class AddEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("addEntry.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String warn = "";
		if(BlogEntry.checkYtLink(request.getParameter("ytlink"))) {
		
		String song = request.getParameter("songName");
		String artist = request.getParameter("artist");
		String album = request.getParameter("album");
		String desc = request.getParameter("desc");
		String ytlink = request.getParameter("ytlink");
		UtilDB.createEntries(song, album, artist, desc, ytlink);
		warn = "<label for=\"ytlink\">Entry created successfully</label>";
		} else {
			//entriesHtml += "<script>alert(\"Youtube link was not valid\")</script>";
			//warn = true;
			warn = "<label for=\"ytlink\" class=\"warn\">Enter a valid Youtube link</label>";
		}
		request.setAttribute("warning", warn);
		doGet(request, response);
	}

}
