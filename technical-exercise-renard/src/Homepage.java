

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.BlogEntry;
import util.UtilDB;

/**
 * Servlet implementation class Homepage
 */
@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	//boolean warn = false;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homepage() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String entriesHtml = "";
		List<BlogEntry> entries = UtilDB.listEntries();
		for(int i = 0; i < entries.size(); i++) {
			entriesHtml += entries.get(i).toHtml();
		}
		request.setAttribute("entriesHtml", entriesHtml);
		RequestDispatcher view = request.getRequestDispatcher("homepage.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * songName
		 * artist
		 * album
		 * desc
		 * ytlink
		 */
		/*String warn = "";
		if(BlogEntry.checkYtLink(request.getParameter("ytlink"))) {
		
		String song = request.getParameter("songName");
		String artist = request.getParameter("artist");
		String album = request.getParameter("album");
		String desc = request.getParameter("desc");
		String ytlink = request.getParameter("ytlink");
		UtilDB.createEntries(song, album, artist, desc, ytlink);
		} else {
			//entriesHtml += "<script>alert(\"Youtube link was not valid\")</script>";
			//warn = true;
			warn = "<script>alert(\"Youtube link was not valid\")</script>";
		}
		request.setAttribute("warning", warn);*/
		doGet(request, response);
	}

}
