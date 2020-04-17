package DAO;

import java.util.List;

import Model.Aluno;

public interface AlunoDAO {

	public boolean saveAluno(Aluno aluno);
	public List<Aluno> getAlunos();
	public boolean deleteAluno(Aluno aluno);
	public List<Aluno> getAlunoByID(Aluno aluno);
	public boolean updateAluno(Aluno aluno);
	
}
