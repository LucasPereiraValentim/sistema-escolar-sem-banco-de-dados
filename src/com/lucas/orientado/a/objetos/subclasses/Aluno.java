package com.lucas.orientado.a.objetos.subclasses;

import java.util.ArrayList;
import java.util.List;

import com.lucas.orientado.a.objetos.constantes.StatusAluno;
import com.lucas.orientado.a.objetos.poo.classes.Disciplina;
import com.lucas.orientado.a.objetos.superclasses.Pessoa;

//Escrever o nome da classe sempre no singular
//SubClasse
public class Aluno extends Pessoa{
	private String dataMatricula;
	private String nomeEscola;
	private String serieMatricula;
	
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public String getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	public String getNomeEscola() {
		return nomeEscola;
	}
	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}
	public String getSerieMatricula() {
		return serieMatricula;
	}
	public void setSerieMatricula(String serieMatricula) {
		this.serieMatricula = serieMatricula;
	}
	
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataMatricula == null) ? 0 : dataMatricula.hashCode());
		result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
		result = prime * result + ((nomeEscola == null) ? 0 : nomeEscola.hashCode());
		result = prime * result + ((serieMatricula == null) ? 0 : serieMatricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (dataMatricula == null) {
			if (other.dataMatricula != null)
				return false;
		} else if (!dataMatricula.equals(other.dataMatricula))
			return false;
		if (disciplinas == null) {
			if (other.disciplinas != null)
				return false;
		} else if (!disciplinas.equals(other.disciplinas))
			return false;
		if (nomeEscola == null) {
			if (other.nomeEscola != null)
				return false;
		} else if (!nomeEscola.equals(other.nomeEscola))
			return false;
		if (serieMatricula == null) {
			if (other.serieMatricula != null)
				return false;
		} else if (!serieMatricula.equals(other.serieMatricula))
			return false;
		return true;
	}

	public double getMediaAluno() {
		double media = 0.0;
		for (Disciplina disciplina : disciplinas) {
			media += disciplina.getNota();
		}
		return media / this.getDisciplinas().size();
	}
	
	
	public String getAprovarAluno() {
		double media = this.getMediaAluno();
		
		if (media >= 50) {
			if (media >= 70) { //Aprovado
				return StatusAluno.APROVADO;
			} else {
				return StatusAluno.RECUPERACAO;
			}
		} else {
			return StatusAluno.REPROVADO; 
		}
	}

	@Override
	public String toString() {
		return "Nome: " + this.getNome() + " | Idade: " + this.getIdade() + " | Data de nascimento: " + this.getDataNascimento() 
				+ "\nRG: " + this.getRegistroGeral() + " | CPF: " + this.getNumeroCpf() + " | Nome da mãe: " + this.getNomeMae()
				+ "\nData da matrícula: " + this.getDataMatricula() + " | Nome da escola: " + this.getNomeEscola() + " | Série matriculado: " + this.getSerieMatricula()
				+ "\nMédia final: " + this.getMediaAluno()
				+ "\nResultado final: " + this.getAprovarAluno();
	
	}

		
}
