package com.lucas.orientado.a.objetos.poo.classes;

import java.util.ArrayList;
import java.util.List;

import com.lucas.orientado.a.objetos.subclasses.Professor;

//Essas classe servirá para todos os objetos e instâncias de notas e disciplinas.
public class Disciplina {
	private String disciplina;
	private double nota;
	
	
	private List<Professor> listaProfessores = new ArrayList<Professor>();
	
	public void setListaProfessores(List<Professor> listaProfessores) {
		this.listaProfessores = listaProfessores;
	}
	
	public List<Professor> getListaProfessores() {
		return listaProfessores;
	}
	
	

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		long temp;
		temp = Double.doubleToLongBits(nota);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Disciplina other = (Disciplina) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (Double.doubleToLongBits(nota) != Double.doubleToLongBits(other.nota))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina: " + this.disciplina + " | Nota: " + this.nota;
	}

}
