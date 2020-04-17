package DAO;

import java.util.ArrayList;
import java.util.List;

import Model.Aluno;
import Model.Composicao;

public interface ComposicaoDAO {

	public boolean saveComposicao(Composicao composicao);
	public List<Composicao> getComposicoes();
	public boolean deleteComposicao(Composicao composicao);
	public List<Composicao> getComposicaoByID(Composicao composicao);
	public boolean updateComposicao(Composicao composicao);
	public List<Composicao> saveTodasComposicoes(Iterable<Composicao> Composicoes);
	public List<Composicao> getComposicaoByIDAluno(Aluno aluno);
	public Object[] getComposicaoByColunaGraficoUm(Aluno aluno);
	public Object[] getComposicaoByColunaGraficoDois(Aluno aluno);
}
