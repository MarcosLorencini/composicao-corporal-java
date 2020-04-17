package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Aluno;

@Repository
public class AlunoDAOImp  implements AlunoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveAluno(Aluno aluno) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(aluno);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Aluno> getAlunos() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Aluno> query=currentSession.createQuery("from Aluno", Aluno.class);
		List<Aluno> list=query.getResultList();
		return list;
	}

	@Override
	public boolean deleteAluno(Aluno aluno) {
		boolean status=false;
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("Delete FROM Composicao As d WHERE d.aluno.aluno_id = :id_do_aluno");
		query.setParameter("id_do_aluno", aluno.getAluno_id());
		
		int result = query.executeUpdate();
		 
		if (result > 0) {
		    System.out.println("A tabela Composicao ligada a tabela Aluno foi apagada");
		}
		
		try {
			sessionFactory.getCurrentSession().delete(aluno);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Aluno> getAlunoByID(Aluno aluno) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Aluno> query=currentSession.createQuery("from Aluno where aluno_id=:aluno_id", Aluno.class);
		query.setParameter("aluno_id", aluno.getAluno_id());
		List<Aluno> list=query.getResultList();
		return list;
	}

	@Override
	public boolean updateAluno(Aluno aluno) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(aluno);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	

}
