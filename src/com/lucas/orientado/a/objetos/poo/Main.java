package com.lucas.orientado.a.objetos.poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import com.lucas.orientado.a.objetos.constantes.StatusAluno;
import com.lucas.orientado.a.objetos.poo.classes.Disciplina;
import com.lucas.orientado.a.objetos.subclasses.Aluno;
import com.lucas.orientado.a.objetos.subclasses.Professor;

public class Main {

	public static void main(String[] args) {

		try {

			String login = JOptionPane.showInputDialog(null, "Login");
			String senha = JOptionPane.showInputDialog(null, "Senha");

			if (new Professor().autenticar(login, senha)) {

				JOptionPane.showMessageDialog(null, "Bem-vindo ao sistema de cadastro de alunos e notas");

				List<Aluno> alunos = new ArrayList<Aluno>();

				HashMap<String, List<Aluno>> mapsAlunos = new HashMap<String, List<Aluno>>();
				int cadastrarMaisAlunos = 0;

				do {

					Aluno aluno = new Aluno();

					aluno.setNome(JOptionPane.showInputDialog(null, "Digite nome do aluno"));

					aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite idade do aluno")));
					aluno.setDataNascimento(JOptionPane.showInputDialog(null, "Digite data de nascimento"));
					aluno.setRegistroGeral(JOptionPane.showInputDialog(null, "Digite o RG do aluno"));
					aluno.setNumeroCpf(JOptionPane.showInputDialog(null, "Digite o número do CPF"));
					aluno.setNomeMae(JOptionPane.showInputDialog(null, "Digite o nome da Mãe"));
					aluno.setSerieMatricula(JOptionPane.showInputDialog(null, "Digite o semestre"));
					aluno.setNomeEscola(JOptionPane.showInputDialog(null, "Digite da instituição"));
					aluno.setDataMatricula(JOptionPane.showInputDialog(null, "Digite data de matrícula"));

					for (int posicao = 1; posicao <= 4; posicao++) {

						Disciplina disciplina = new Disciplina();

						Professor professor = new Professor();

						professor.setNome(
								JOptionPane.showInputDialog("Digite o nome do Professor da Disciplina " + posicao));

						professor.setMatricula(JOptionPane
								.showInputDialog("Digite a Matrícula do professor da disciplina " + posicao));

						disciplina.setDisciplina(JOptionPane.showInputDialog(null, "Nome da Disciplina " + posicao));

						disciplina.setNota(
								Double.valueOf(JOptionPane.showInputDialog(null, "Digite sua nota " + posicao)));

						aluno.getDisciplinas().add(disciplina);

						disciplina.getListaProfessores().add(professor);

					}

					// Opção sim é zero.
					int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");
					int posicao = 1;
					if (escolha == 0) {

						int continuarRemover = 0;

						while (continuarRemover == 0) {

							String removerDisciplina = JOptionPane.showInputDialog(null,
									"Qual disciplina você quer remover? (1, 2, 3, 4)");
							aluno.getDisciplinas().remove(Integer.valueOf(removerDisciplina).intValue() - posicao);
							posicao++;
							continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja remover mais alguma?");

						}
					}

					cadastrarMaisAlunos = JOptionPane.showConfirmDialog(null, "Deseja cadastrar mais aluno?");

					alunos.add(aluno);

				} while (cadastrarMaisAlunos == 0);

				int removerAluno = JOptionPane.showConfirmDialog(null, "Deseja remover alguma aluno da lista");

				if (removerAluno == 0) {
					String nomeAlunoRemover = JOptionPane.showInputDialog(null, "Digite o nome do aluno para remover?");
					for (Aluno aluno : alunos) {
						if (aluno.getNome().equalsIgnoreCase(nomeAlunoRemover)) {
							alunos.remove(aluno);
							break;
						}
					}
				}

				int substituirAluno = JOptionPane.showConfirmDialog(null, "Deseja substituir algum aluno da lista?");

				if (substituirAluno == 0) {
					String nomeAlunoSubstituir = JOptionPane.showInputDialog(null,
							"Digite o nome do aluno para fazer subtituição");
					for (int i = 0; i < alunos.size(); i++) {
						Aluno aluno = alunos.get(i);
						if (aluno.getNome().equalsIgnoreCase(nomeAlunoSubstituir)) {
							Aluno trocar = new Aluno();
							trocar.setNome(JOptionPane.showInputDialog(null, "Digite nome do aluno"));

							trocar.setIdade(
									Integer.parseInt(JOptionPane.showInputDialog(null, "Digite idade do aluno")));
							trocar.setDataNascimento(JOptionPane.showInputDialog(null, "Digite data de nascimento"));
							trocar.setRegistroGeral(JOptionPane.showInputDialog(null, "Digite o RG do aluno"));
							trocar.setNumeroCpf(JOptionPane.showInputDialog(null, "Digite o número do CPF"));
							trocar.setNomeMae(JOptionPane.showInputDialog(null, "Digite o nome da Mãe"));
							trocar.setSerieMatricula(JOptionPane.showInputDialog(null, "Digite o semestre"));
							trocar.setNomeEscola(JOptionPane.showInputDialog(null, "Digite da instituição"));
							trocar.setDataMatricula(JOptionPane.showInputDialog(null, "Digite data de matrícula"));

							for (int j = 1; j <= 4; j++) {
								Disciplina disciplina = new Disciplina();

								disciplina.setDisciplina(
										JOptionPane.showInputDialog(null, "Digite o nome da disciplina " + j));

								disciplina.setNota(Double
										.parseDouble(JOptionPane.showInputDialog(null, "Digite nota do aluno " + j)));

								trocar.getDisciplinas().add(disciplina);

							}

							// Substituir Objeto da Lista(list).
							alunos.set(i, trocar);

							aluno = alunos.get(i);
						}
					}
				}

				mapsAlunos.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
				mapsAlunos.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
				mapsAlunos.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

				for (Aluno aluno : alunos) {
					if (aluno.getAprovarAluno().equalsIgnoreCase(StatusAluno.APROVADO)) {
						mapsAlunos.get(StatusAluno.APROVADO).add(aluno);
						continue;
					} else if (aluno.getAprovarAluno().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
						mapsAlunos.get(StatusAluno.RECUPERACAO).add(aluno);
						continue;
					} else if (aluno.getAprovarAluno().equalsIgnoreCase(StatusAluno.REPROVADO)) {
						mapsAlunos.get(StatusAluno.REPROVADO).add(aluno);
						continue;
					}
				}

				System.out.println("---Alunos Aprovados---");

				for (Aluno aluno : mapsAlunos.get(StatusAluno.APROVADO)) {
					System.out.println(aluno.toString());
					for (Disciplina disciplina : aluno.getDisciplinas()) {
						System.out.println("\n");
						System.out.println(disciplina.toString());

						for (Professor professor : disciplina.getListaProfessores()) {
							System.out.println(professor.toString());
						}
					}
				}

				System.out.println("\n---Alunos em Recuperação---\n");

				for (Aluno aluno : mapsAlunos.get(StatusAluno.RECUPERACAO)) {
					System.out.println(aluno.toString());

					for (Disciplina disciplina : aluno.getDisciplinas()) {
						System.out.println("\n");
						System.out.println(disciplina.toString());

						for (Professor professor : disciplina.getListaProfessores()) {
							System.out.println(professor.toString());
						}
					}
				}

				System.out.println("\n---Alunos Reprovados---\n");

				for (Aluno aluno : mapsAlunos.get(StatusAluno.REPROVADO)) {
					System.out.println(aluno.toString());

					for (Disciplina disciplina : aluno.getDisciplinas()) {
						System.out.println("\n");
						System.out.println(disciplina.toString());

						for (Professor professor : disciplina.getListaProfessores()) {
							System.out.println(professor.toString());
						}
					}
				}

			} else {
				JOptionPane.showMessageDialog(null, "Acesso negado!");
			}

		} catch (NumberFormatException e) { // Tratando exceção especifíca

			e.printStackTrace(); // Imprime erro no console
			System.err.println("Erro: " + e.getMessage());

			for (int i = 0; i < e.getStackTrace().length; i++) {
				System.err.println("Classe com erro: " + e.getStackTrace()[i].getClassName());
				System.err.println("Erro está na linha: " + e.getStackTrace()[i].getLineNumber());
			}
			JOptionPane.showMessageDialog(null, "Digite apenas números nessse campo");
		} catch (NullPointerException e) { // Tratando exceção especifíca

			e.printStackTrace(); // Imprime erro no console
			System.err.println("Erro: " + e.getMessage());

			System.err.println("Erro está na linha: " + e.getStackTrace()[0].getLineNumber());

		} catch (Exception e) { // Tratando exceção abstrata

			e.printStackTrace();

		} finally { // Sempre é excecutado, independente se vai a ver exceção ou não
			JOptionPane.showMessageDialog(null, "Sistema escolar encerrado.");
		}
	}
}
