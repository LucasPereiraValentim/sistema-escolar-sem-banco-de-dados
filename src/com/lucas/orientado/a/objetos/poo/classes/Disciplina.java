package com.lucas.orientado.a.objetos.poo.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lucas.orientado.a.objetos.subclasses.Professor;

//Essas classe servirá para todos os objetos e instâncias de notas e disciplinas.
public class Disciplina {
	private String disciplina;
	private double[] notas = new double[4];
	
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

	

	public double[] getNota() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	public double getCalculoNotas() {
		double calculoMedia = 0;
		
		for (int i = 0; i < notas.length; i++) {
			calculoMedia += notas[i];
		}
		
		return calculoMedia / 4;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + ((listaProfessores == null) ? 0 : listaProfessores.hashCode());
		result = prime * result + Arrays.hashCode(notas);
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
		if (listaProfessores == null) {
			if (other.listaProfessores != null)
				return false;
		} else if (!listaProfessores.equals(other.listaProfessores))
			return false;
		if (!Arrays.equals(notas, other.notas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina: " + this.disciplina; 
	}

}
