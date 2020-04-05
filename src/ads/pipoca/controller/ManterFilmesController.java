package ads.pipoca.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.pipoca.model.entity.Filme;
import ads.pipoca.model.entity.Genero;
import ads.pipoca.model.service.FilmeService;
import ads.pipoca.model.service.GeneroService;


@WebServlet("/manter_filmes.do")
public class ManterFilmesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String acao = request.getParameter("acao");
		
		switch(acao) {
		case "mostrar":
		
		String id_filme = request.getParameter("id_filme");		
		int idFilme = Integer.parseInt(id_filme);
		FilmeService fservice = new FilmeService();
		Filme filme = fservice.buscarFilme(idFilme);
		System.out.println(filme);
		
		request.setAttribute("filme", filme);
		
		RequestDispatcher view = request.getRequestDispatcher("Filme.jsp");
		view.forward(request, response);
			break;
		case "inserir" :
			String titulo = request.getParameter("titulo");
			String descricao = request.getParameter("descricao");
			double popularidade = Double.parseDouble(request.getParameter("popularidade"));
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			Date dataLanc = null;
			try {
				 dataLanc = formatter.parse(request.getParameter("datalanc"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			String poster = request.getParameter("poster");
			String diretor = request.getParameter("diretor");
			int idGenero = Integer.parseInt(request.getParameter("idgenero"));
			GeneroService generoservice = new GeneroService();
			Genero genero = generoservice.buscarGenero(idGenero);
			
			Filme filmeMontado = new Filme();
			filmeMontado.setTitulo(titulo);
			filmeMontado.setDescricao(descricao);
			filmeMontado.setPopularidade(popularidade);
			filmeMontado.setDataLancamento(dataLanc);
			filmeMontado.setPosterPath(poster);
			filmeMontado.setDiretor(diretor);
			filmeMontado.setGenero(genero);
			
			FilmeService filmesvc = new FilmeService();
			int idFilmeUsuario = filmesvc.inserirFilme(filmeMontado);
			
			request.setAttribute("filme", filmeMontado);
			
			RequestDispatcher viewInserir = request.getRequestDispatcher("Filme.jsp");
			viewInserir.forward(request, response);
			
			
			
			
			break;
		case "atualizar":
			break;
		case "excluir":
			break;
		}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
