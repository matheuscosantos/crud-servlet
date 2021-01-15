package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Mapeamento da url listaEmpresas
@WebServlet("/listaEmpresas")
public class ListaEmpresaServlet extends HttpServlet {
	
//    Acessa o verbo Get do protocolo HTTP   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		
//		Armazena todas empresas do banco à lista de empresas
		List<Empresa> lista = banco.getEmpresas();		
		
//		Adiciona a lista de empresas ao request
		request.setAttribute("empresas", lista);
		
//		Envia o request para o JSP listaEmpresas
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);
	}

}
