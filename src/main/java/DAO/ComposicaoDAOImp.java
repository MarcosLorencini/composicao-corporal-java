package DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Aluno;
import Model.Composicao;

@Repository
public class ComposicaoDAOImp  implements ComposicaoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveComposicao(Composicao composicao) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(composicao);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Composicao> getComposicoes() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Composicao> query=currentSession.createQuery("from Composicao", Composicao.class);
		List<Composicao> list=query.getResultList();
		return list;
	}

	@Override
	public boolean deleteComposicao(Composicao composicao) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().delete(composicao);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Composicao> getComposicaoByID(Composicao composicao) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Composicao> query=currentSession.createQuery("from Composicao where composicao_id=:composicao_id", Composicao.class);
		query.setParameter("composicao_id", composicao.getComposicao_id());
		List<Composicao> list=query.getResultList();
		return list;
	}

	@Override
	public boolean updateComposicao(Composicao composicao) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(composicao);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Composicao> saveTodasComposicoes(Iterable<Composicao> composicoes) {
		List<Composicao> result = new ArrayList<Composicao>();

		for (Composicao entity : composicoes) {
			sessionFactory.getCurrentSession().save(entity);
		}

		return result;
	}

	@Override
	public List<Composicao> getComposicaoByIDAluno(Aluno aluno) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Composicao> query=currentSession.createQuery("from Composicao where aluno_id=:aluno_id", Composicao.class);
		query.setParameter("aluno_id", aluno.getAluno_id());
		List<Composicao> list=query.getResultList();
		return list;
	}

	@Override
	public Object[] getComposicaoByColunaGraficoUm(Aluno aluno) {
				
		Session currentSession = sessionFactory.getCurrentSession();
		
		 List<Composicao> composicaoList = new ArrayList<Composicao>();
		 
		 Query<Composicao> queryPeso=currentSession.createQuery("SELECT c.peso FROM Composicao c where aluno_id=:aluno_id");
		 queryPeso.setParameter("aluno_id", aluno.getAluno_id());
		 
		 Query<Composicao> queryIdade=currentSession.createQuery("SELECT c.idade FROM Composicao c where aluno_id=:aluno_id");
		 queryIdade.setParameter("aluno_id", aluno.getAluno_id());
		 
		 Query<Composicao> queryImc=currentSession.createQuery("SELECT c.imc FROM Composicao c where aluno_id=:aluno_id");
		 queryImc.setParameter("aluno_id", aluno.getAluno_id());
		 
		 Query<Composicao> queryCalorias=currentSession.createQuery("SELECT c.calorias FROM Composicao c where aluno_id=:aluno_id");
		 queryCalorias.setParameter("aluno_id", aluno.getAluno_id());
		 
		 Query<Composicao> queryGordura=currentSession.createQuery("SELECT c.gordura FROM Composicao c where aluno_id=:aluno_id");
		 queryGordura.setParameter("aluno_id", aluno.getAluno_id());
		 
		 Query<Composicao> queryMusculo=currentSession.createQuery("SELECT c.musculo FROM Composicao c where aluno_id=:aluno_id");
		 queryMusculo.setParameter("aluno_id", aluno.getAluno_id());
		 
		 Query<Composicao> queryViceral=currentSession.createQuery("SELECT c.viceral FROM Composicao c where aluno_id=:aluno_id");
		 queryViceral.setParameter("aluno_id", aluno.getAluno_id());
		 
		 Query<Composicao> queryDataMedida=currentSession.createQuery("SELECT c.dataMedida FROM Composicao c where aluno_id=:aluno_id");
		 queryDataMedida.setParameter("aluno_id", aluno.getAluno_id());
		 
		 
		 List<Composicao> listPeso=queryPeso.getResultList(); 
		 List<Composicao> listIdade=queryIdade.getResultList();
		 List<Composicao> listImc=queryImc.getResultList();
		 List<Composicao> listCalorias=queryCalorias.getResultList();
		 
		 List<Composicao> listGordura=queryGordura.getResultList();
		 List<Composicao> listMusculo=queryMusculo.getResultList();
		 List<Composicao> listViceral=queryViceral.getResultList();
		 
		 List<Composicao> listDataMedida=queryDataMedida.getResultList();
		 
		
		  ArrayList<ArrayList<Composicao>> aList = new  ArrayList<ArrayList<Composicao>>(7); 
		  aList.add((ArrayList<Composicao>) listGordura);
		  aList.add((ArrayList<Composicao>) listMusculo); 
		  aList.add((ArrayList<Composicao>) listViceral);
		  
//		  aList.add((ArrayList<Composicao>) listPeso); 
//		  aList.add((ArrayList<Composicao>) listImc);
//		  aList.add((ArrayList<Composicao>) listIdade);
//		  aList.add((ArrayList<Composicao>) listCalorias);

		  aList.add((ArrayList<Composicao>) listDataMedida);
		 
		  Object[] array = aList.toArray();
		
			 
			 System.out.println( Arrays.toString(array) );
			 
			for(Object o : array) { 
				 Object s = (Object) o;
			 
			 System.out.println(s); 
			}
			 
		 
		 
		 return array;
		 
		
	}
	
	@Override
	public Object[] getComposicaoByColunaGraficoDois(Aluno aluno) {
				
		Session currentSession = sessionFactory.getCurrentSession();
		
		 List<Composicao> composicaoList = new ArrayList<Composicao>();
		 
		 Query<Composicao> queryPeso=currentSession.createQuery("SELECT c.peso FROM Composicao c where aluno_id=:aluno_id");
		 queryPeso.setParameter("aluno_id", aluno.getAluno_id());
		 
		 Query<Composicao> queryIdade=currentSession.createQuery("SELECT c.idade FROM Composicao c where aluno_id=:aluno_id");
		 queryIdade.setParameter("aluno_id", aluno.getAluno_id());
		 
		 Query<Composicao> queryImc=currentSession.createQuery("SELECT c.imc FROM Composicao c where aluno_id=:aluno_id");
		 queryImc.setParameter("aluno_id", aluno.getAluno_id());
		 
		 Query<Composicao> queryCalorias=currentSession.createQuery("SELECT c.calorias FROM Composicao c where aluno_id=:aluno_id");
		 queryCalorias.setParameter("aluno_id", aluno.getAluno_id());
		 
		 Query<Composicao> queryGordura=currentSession.createQuery("SELECT c.gordura FROM Composicao c where aluno_id=:aluno_id");
		 queryGordura.setParameter("aluno_id", aluno.getAluno_id());
		 
		 Query<Composicao> queryMusculo=currentSession.createQuery("SELECT c.musculo FROM Composicao c where aluno_id=:aluno_id");
		 queryMusculo.setParameter("aluno_id", aluno.getAluno_id());
		 
		 Query<Composicao> queryViceral=currentSession.createQuery("SELECT c.viceral FROM Composicao c where aluno_id=:aluno_id");
		 queryViceral.setParameter("aluno_id", aluno.getAluno_id());
		 
		 Query<Composicao> queryDataMedida=currentSession.createQuery("SELECT c.dataMedida FROM Composicao c where aluno_id=:aluno_id");
		 queryDataMedida.setParameter("aluno_id", aluno.getAluno_id());
		 
		 
		 List<Composicao> listPeso=queryPeso.getResultList(); 
		 List<Composicao> listIdade=queryIdade.getResultList();
		 List<Composicao> listImc=queryImc.getResultList();
		 List<Composicao> listCalorias=queryCalorias.getResultList();
		 
		 List<Composicao> listGordura=queryGordura.getResultList();
		 List<Composicao> listMusculo=queryMusculo.getResultList();
		 List<Composicao> listViceral=queryViceral.getResultList();
		 
		 List<Composicao> listDataMedida=queryDataMedida.getResultList();
		 
		
		  ArrayList<ArrayList<Composicao>> aList = new  ArrayList<ArrayList<Composicao>>(7);
		  
		/*
		 * aList.add((ArrayList<Composicao>) listGordura);
		 * aList.add((ArrayList<Composicao>) listMusculo);
		 * aList.add((ArrayList<Composicao>) listViceral);
		 */
		  
		  aList.add((ArrayList<Composicao>) listPeso); 
		  aList.add((ArrayList<Composicao>) listImc);
		  aList.add((ArrayList<Composicao>) listIdade);
		  //aList.add((ArrayList<Composicao>) listCalorias);

		  aList.add((ArrayList<Composicao>) listDataMedida);
		 
		  Object[] array = aList.toArray();
		
			 
			 System.out.println( Arrays.toString(array) );
			 
			for(Object o : array) { 
				 Object s = (Object) o;
			 
			 System.out.println(s); 
			}
			 
		 
		 
		 return array;
		 
		
	}
	
	

}
