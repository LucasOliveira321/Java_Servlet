package br.com.aosdata.gerenciador.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NovaEmpresaAOS")
public class NovaEmpresa extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpres = request.getParameter("data");
		
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = (Date) sdf.parse(paramDataEmpres);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa emp = new Empresa();
		emp.setNome(nomeEmpresa);
		
		Banco banco = new Banco();
		banco.adiciona(emp);
		
		RequestDispatcher req = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("empresa", emp.getNome());
		req.forward(request, response);
	}

}
