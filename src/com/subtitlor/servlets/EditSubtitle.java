package com.subtitlor.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subtitlor.beans.Line;
import com.subtitlor.beans.Translation;
import com.subtitlor.utilities.SubtitlesHandler;

@WebServlet("/EditSubtitle")
public class EditSubtitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_NAME = "/WEB-INF/password_presentation.srt";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		System.out.println(context.getRealPath(FILE_NAME));
		SubtitlesHandler subtitles = new SubtitlesHandler(context.getRealPath(FILE_NAME));
		
		request.setAttribute("subtitles", subtitles.getSubtitles());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/edit_subtitle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Objet de gestion de la traduction
		Translation trad = new Translation();
		// Création d'un ArrayList de la traduction créée
		trad.setTradArray(request);
		// trad contient maintenant un ArrayList de la traduction
//		for(Line li:trad.getTradArray()) {
//			System.out.println("EditSubtitle 40 : " + li.getLineNb() + " : " + li.getTrad());
//		}
		ArrayList<Line> tr = trad.getTradArray();
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/edit_subtitle.jsp").forward(request, response);
	}

}
