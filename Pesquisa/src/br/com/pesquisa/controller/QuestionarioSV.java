package br.com.pesquisa.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.pesquisa.dao.QuestionarioDAO;
import br.com.pesquisa.model.Questionario;

@WebServlet("/QuestionarioControl.do")
public class QuestionarioSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public QuestionarioSV() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionarioDAO dao = new QuestionarioDAO();
		BufferedReader reader = request.getReader();
		StringBuffer json = new StringBuffer();
		String linha = "";
		while ((linha = reader.readLine()) != null) {
			json.append(linha);
		}
		System.out.println("resposta:" + json.toString());
		try {
			while ((linha = reader.readLine()) != null) {
				json.append(linha);
			}
			Questionario questionario= new Gson().fromJson(json.toString(), Questionario.class);
			System.out.println("resposta:" + json.toString());
			if (json.toString() != "") {
				if (questionario != null) {
					dao.persist(questionario);
					System.out.println("resposta:" + json.toString());
					System.out.println("contato" + questionario.toString());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
