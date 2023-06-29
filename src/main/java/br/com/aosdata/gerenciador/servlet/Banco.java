package br.com.aosdata.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	
	static {
		Empresa empresa1 = new Empresa();
		Empresa empresa2 = new Empresa();
		
		empresa1.setNome("Company One");
		empresa2.setNome("Company Two");
		
		lista.add(empresa1);
		lista.add(empresa2);
		
	}

	public void adiciona(Empresa emp) {
		lista.add(emp);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}
}
