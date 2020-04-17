package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.AlunoDAO;
import Model.Aluno;

@Service
@Transactional
public class AlunoServiceImp implements AlunoService {
 
	@Autowired
	private AlunoDAO alunoDao;
	
	@Override
	public boolean saveAluno(Aluno aluno) {
		return alunoDao.saveAluno(aluno);
	}

	@Override
	public List<Aluno> getAlunos() {
		return alunoDao.getAlunos();
	}

	@Override
	public boolean deleteAluno(Aluno aluno) {
		return alunoDao.deleteAluno(aluno);
	}

	@Override
	public List<Aluno> getAlunoByID(Aluno aluno) {
		return alunoDao.getAlunoByID(aluno);
	}

	@Override
	public boolean updateAluno(Aluno aluno) {
		return alunoDao.updateAluno(aluno);
	}

}
