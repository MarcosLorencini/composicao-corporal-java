package Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.ComposicaoDAO;
import Model.Aluno;
import Model.Composicao;

@Service
@Transactional
public class ComposicaoServiceImp implements ComposicaoService {
	
	@Autowired
	private ComposicaoDAO composicaoDao;

	@Override
	public boolean saveComposicao(Composicao composicao) {
		return composicaoDao.saveComposicao(composicao);
	}

	@Override
	public List<Composicao> getComposicoes() {
		return composicaoDao.getComposicoes();
	}

	@Override
	public boolean deleteComposicao(Composicao composicao) {
		return composicaoDao.deleteComposicao(composicao);
	}

	@Override
	public List<Composicao> getComposicaoByID(Composicao composicao) {
		return composicaoDao.getComposicaoByID(composicao);
	}

	@Override
	public boolean updateComposicao(Composicao composicao) {
		return composicaoDao.updateComposicao(composicao);
	}

	@Override
	public List<Composicao> saveTodasComposicoes(Iterable<Composicao> composicoes) {
		return composicaoDao.saveTodasComposicoes(composicoes);
	}

	@Override
	public List<Composicao> getComposicaoByIDAluno(Aluno aluno) {
		return composicaoDao.getComposicaoByIDAluno(aluno);
	}

	@Override
	public Object[] getComposicaoByColunaGraficoUm(Aluno aluno) {
		return composicaoDao.getComposicaoByColunaGraficoUm(aluno);
	}
	
	@Override
	public Object[] getComposicaoByColunaGraficoDois(Aluno aluno) {
		return composicaoDao.getComposicaoByColunaGraficoDois(aluno);
	}
 
	

}
