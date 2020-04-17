package Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="composicao")
public class Composicao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer composicao_id;
	private double peso;
	private double imc;
	private double gordura;
	private double viceral;
	private double musculo;
	private double calorias;
	private double idade;
	

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataMedida;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="aluno_id")
	 @OnDelete(action = OnDeleteAction.CASCADE)
	private Aluno aluno;
	
	public Composicao() {}
	

	


	public Composicao(Integer composicao_id, double peso, double imc, double gordura, double viceral, double musculo,
			double calorias, double idade, Date dataMedida, Aluno aluno) {
		super();
		this.composicao_id = composicao_id;
		this.peso = peso;
		this.imc = imc;
		this.gordura = gordura;
		this.viceral = viceral;
		this.musculo = musculo;
		this.calorias = calorias;
		this.idade = idade;
		this.dataMedida = dataMedida;
		this.aluno = aluno;
	}

	public Integer getComposicao_id() {
		return composicao_id;
	}

	public void setComposicao_id(Integer composicao_id) {
		this.composicao_id = composicao_id;
	}

	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public double getImc() {
		return imc;
	}


	public void setImc(double imc) {
		this.imc = imc;
	}


	public double getGordura() {
		return gordura;
	}


	public void setGordura(double gordura) {
		this.gordura = gordura;
	}


	public double getViceral() {
		return viceral;
	}


	public void setViceral(double viceral) {
		this.viceral = viceral;
	}


	public double getMusculo() {
		return musculo;
	}


	public void setMusculo(double musculo) {
		this.musculo = musculo;
	}


	public double getCalorias() {
		return calorias;
	}


	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}


	public double getIdade() {
		return idade;
	}


	public void setIdade(double idade) {
		this.idade = idade;
	}


	public Date getDataMedida() {
		return dataMedida;
	}


	public void setDataMedida(Date dataMedida) {
		this.dataMedida = dataMedida;
	}


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	
	

	
	
	

	
}
