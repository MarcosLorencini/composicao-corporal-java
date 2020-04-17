package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer aluno_id;
	private String aluno_nome;
	
	@OneToMany(mappedBy="aluno", cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Composicao> composicao = new ArrayList<>();
	
	public Aluno() {
		
	}
	
	public Aluno(Integer aluno_id, String aluno_nome) {
		super();
		this.aluno_id = aluno_id;
		this.aluno_nome = aluno_nome;
	}

	public Integer getAluno_id() {
		return aluno_id;
	}

	public void setAluno_id(Integer aluno_id) {
		this.aluno_id = aluno_id;
	}

	public String getAluno_nome() {
		return aluno_nome;
	}

	public void setAluno_nome(String aluno_nome) {
		this.aluno_nome = aluno_nome;
	}

	public List<Composicao> getComposicao() {
		return composicao;
	}

	public void setComposicao(List<Composicao> composicao) {
		this.composicao = composicao;
	}


	
	

	
}
