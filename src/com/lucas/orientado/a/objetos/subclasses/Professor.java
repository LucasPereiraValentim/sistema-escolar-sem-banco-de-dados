package com.lucas.orientado.a.objetos.subclasses;

import com.lucas.orientado.a.objetos.interfaces.PermitirAcesso;
import com.lucas.orientado.a.objetos.superclasses.Pessoa;

public class Professor extends Pessoa implements PermitirAcesso{
	private String matricula;
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getMatricula() {
		return matricula;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nome do professor(a): " + super.nome + " | Matrícula do professor(a): " + this.matricula;
	}

	@Override
	public boolean isPessoaMaiorIdade() {
		return super.idade >= 18;
	}

	@Override
	public boolean autenticar(String login, String senha) {
		return login.equals("admin") && senha.equals("admin");
	}

	
	
	
}
