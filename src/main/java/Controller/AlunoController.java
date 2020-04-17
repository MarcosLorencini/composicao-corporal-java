package Controller;

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
import Service.AlunoService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@PostMapping("save-aluno")
	public boolean saveAluno(@RequestBody Aluno aluno) {
		 return alunoService.saveAluno(aluno);
		
	}
	
	@GetMapping("alunos-list")
	public List<Aluno> allAlunos() {
		 return alunoService.getAlunos();
	}
	
	
	@DeleteMapping("delete-aluno/{aluno_id}")
	public boolean deleteAluno(@PathVariable("aluno_id") int aluno_id, Aluno aluno) {
		aluno.setAluno_id(aluno_id);
		return alunoService.deleteAluno(aluno);
	}

	@GetMapping("aluno/{aluno_id}")
	public List<Aluno> allAlunoByID(@PathVariable("aluno_id") int aluno_id, Aluno aluno) {
		 aluno.setAluno_id(aluno_id);
		 return alunoService.getAlunoByID(aluno);
		
	}
	
	@PostMapping("update-aluno/{aluno_id}")
	public boolean updateAluno(@RequestBody Aluno aluno,@PathVariable("aluno_id") int aluno_id) {
		aluno.setAluno_id(aluno_id);
		return alunoService.updateAluno(aluno);
	}
}
