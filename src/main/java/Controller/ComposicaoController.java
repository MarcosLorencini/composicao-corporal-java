package Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Aluno;
import Model.Composicao;
import Service.AlunoService;
import Service.ComposicaoService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class ComposicaoController {
	
	@Autowired
	private ComposicaoService composicaoService;
	
	@Autowired
	private AlunoService alunoService;
	
	
	@PostMapping("save-composicao/{alunoId}")
	public boolean saveComposicao(@RequestBody Composicao composicao, @PathVariable("alunoId") int alunoId) {
		Aluno aluno = new Aluno();
		aluno.setAluno_id(alunoId);
		
		List<Aluno> s = alunoService.getAlunoByID(aluno);
		composicao.setAluno(s.get(0));
		//composicao.setDataMedida(new Date());
		return composicaoService.saveComposicao(composicao);
		
	}
	
	@PostMapping("update-composicao/{composicao_id}")
	public boolean updateComposicao(@RequestBody Composicao composicao,@PathVariable("composicao_id") int composicao_id) {
		composicao.setComposicao_id(composicao_id);
		return composicaoService.updateComposicao(composicao);
	}
	
	@GetMapping("composicoes-list")
	public List<Composicao> getComposicoes() {
		 return composicaoService.getComposicoes();
	}
	
	
	@DeleteMapping("delete-composicao/{composicao_id}")
	public boolean deleteComposicao(@PathVariable("composicao_id") int composicao_id, Composicao composicao) {
		composicao.setComposicao_id(composicao_id);
		return composicaoService.deleteComposicao(composicao);
	}

	@GetMapping("composicao/{composicao_id}")
	public List<Composicao> todasComposicoesByID(@PathVariable("composicao_id") int composicao_id, Composicao composicao) {
		 composicao.setComposicao_id(composicao_id);
		 return composicaoService.getComposicaoByID(composicao);
		
	}
	
	@GetMapping("composicao-por-aluno/{aluno_id}")
	public List<Composicao> todasComposicoesByIDAluno(@PathVariable("aluno_id") int aluno_id, Aluno aluno) {
		aluno.setAluno_id(aluno_id);
		return composicaoService.getComposicaoByIDAluno(aluno);
		
	}
	
	@GetMapping("composicoes-por-coluna-grafico-um/{aluno_id}")
	public Object[] todasComposicoesByColunaGraficoUm(@PathVariable("aluno_id") int aluno_id, Aluno aluno) {
		aluno.setAluno_id(aluno_id);
		return composicaoService.getComposicaoByColunaGraficoUm(aluno);
		
	}
	
	@GetMapping("composicoes-por-coluna-grafico-dois/{aluno_id}")
	public Object[] todasComposicoesByColunaGraficoDois(@PathVariable("aluno_id") int aluno_id, Aluno aluno) {
		aluno.setAluno_id(aluno_id);
		return composicaoService.getComposicaoByColunaGraficoDois(aluno);
		
	}
	
	
}
