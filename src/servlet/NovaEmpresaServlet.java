package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	Mapeia a url novaEmpresa
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Cadastrando nova empresa");
		
//		Pega o parâmetro "nome" passado via POST
		String nomeDaEmpresa = request.getParameter("nome");
		
//		Pega o parâmetro "data" passado via POST
		String paramDataEmpresa = request.getParameter("data");
		
		Date dataAbertura = null;
		
//		Faz a tentativa de converter o formato da data para dd/MM/yyyy
//		Caso contrário lança uma exception
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeDaEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
//		Adiciona a empresa ao banco
		banco.adiciona(empresa);
		
		request.setAttribute("empresa", empresa.getNome());

		response.sendRedirect("listaEmpresas");
	
//		Imprime no html a mensagem de sucesso ao criar uma empresa
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title>Cadastro de empresa</title></head></html>");
		writer.println("<html><body>Empresa " + nomeDaEmpresa +" cadastrada com sucesso</body></html>");
		
	}
	
}
