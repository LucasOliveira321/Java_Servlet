package br.com.aosdata.gerenciador.servlet;

import java.io.IOException;
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
		Empresa emp = new Empresa();
		emp.setNome(nomeEmpresa);
		
		Banco banco = new Banco();
		banco.adiciona(emp);
		
		RequestDispatcher req = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("empresa", emp.getNome());
		req.forward(request, response);
	}

}
