package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Filme;
import app.service.FilmeService;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

	@Autowired
	private FilmeService filmeService;

	@PostMapping
	public ResponseEntity<String> criarFilme(@RequestBody Filme filme) {
		try {

			String resposta = filmeService.salvarFilme(filme);
			return new ResponseEntity<>(resposta, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu algo errado ao salvar!", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping
	public ResponseEntity<List<Filme>> listarFilmes() {
		try {

			List<Filme> filmes = filmeService.listarFilmes();
			return new ResponseEntity<>(filmes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Filme> findById(@PathVariable Long id) {
		try {
			Filme filme = this.filmeService.findById(id);
			return new ResponseEntity<>(filme, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> atualizarFilme(@PathVariable Long id, @RequestBody Filme filme) {
		try {
			String resposta = filmeService.atualizarFilme(filme, id);
			return new ResponseEntity<>(resposta, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarFilmes(@PathVariable Long id) {
		try {

			String resposta = filmeService.deletarFilme(id);
			return new ResponseEntity<>(resposta, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
