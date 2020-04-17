package config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Model.Composicao;
import Model.Aluno;
import Service.ComposicaoServiceImp;
import Service.AlunoServiceImp;

@SpringBootApplication
public class ComposicaoCorporalApplication implements CommandLineRunner  {
	
	
	 @Autowired 
	 private AlunoServiceImp alunoDao;
	 
	 @Autowired 
	 private ComposicaoServiceImp composicaoDao;
	 

	public static void main(String[] args) {
		SpringApplication.run(ComposicaoCorporalApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		 
		/*
		 * Aluno a1 = new Aluno(null, "Marcos Ferreira"); Date d = new Date();
		 * Composicao d1 = new Composicao(null, 65.9, 23.1, 17, 6, 40.3, 1562, 31, d,
		 * a1); Composicao d2 = new Composicao(null, 70.9, 25.1, 18.7, 9, 51.3, 1700,
		 * 36, new Date(), a1); alunoDao.saveAluno(a1);
		 * composicaoDao.saveTodasComposicoes(Arrays.asList(d1,d2));
		 */
		 
	 
	 }
	 

}
