

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
		String html = "";
		List<BlogEntry> entries = UtilDB.listEntries();
		for(int i = 0; i < entries.size(); i++) {
			html += entries.get(i).toHtml();
		}
		response.getWriter().append(html);
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
		String song = request.getParameter("songName");
		String artist = request.getParameter("artist");
		String album = request.getParameter("album");
		String desc = request.getParameter("desc");
		String ytlink = request.getParameter("ytlink");
		UtilDB.createEntries(song, album, artist, desc, ytlink);
		doGet(request, response);
	}

}
