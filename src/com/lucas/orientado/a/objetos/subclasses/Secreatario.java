package com.lucas.orientado.a.objetos.subclasses;

import com.lucas.orientado.a.objetos.interfaces.PermitirAcesso;

public class Secreatario implements PermitirAcesso{
	private String matricula;
	

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	

	@Override
	public boolean autenticar(String login, String senha) {
		return login.equals("admin") && senha.equals("admin");
	}
	
	
}
