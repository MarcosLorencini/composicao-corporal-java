package Service;

import java.util.ArrayList;
import java.util.List;

import Model.Aluno;
import Model.Composicao;

public interface ComposicaoService {

	
	public boolean saveComposicao(Composicao composicao);
	public List<Composicao> getComposicoes();
	public boolean deleteComposicao(Composicao composicao);
	public List<Composicao> getComposicaoByID(Composicao composicao);
	public boolean updateComposicao(Composicao siscipline);
	public List<Composicao> saveTodasComposicoes(Iterable<Composicao> composicoes);
	public List<Composicao> getComposicaoByIDAluno(Aluno aluno);
	public Object[] getComposicaoByColunaGraficoUm(Aluno aluno);
	public Object[] getComposicaoByColunaGraficoDois(Aluno aluno);
}
