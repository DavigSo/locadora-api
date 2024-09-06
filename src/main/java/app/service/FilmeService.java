package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Filme;
import app.repository.FilmeReposistory;

@Service
public class FilmeService {

	@Autowired
	private FilmeReposistory filmeRepository;

	public String salvarFilme(Filme filme) {
		this.filmeRepository.save(filme);
		return "Filme salvo com sucesso!";
	}

	public List<Filme> listarFilmes() {
		return filmeRepository.findAll();
	}

	public Filme findById(Long id) {
		Optional<Filme> filme = this.filmeRepository.findById(id);
		return filme.get();
	}

	public String atualizarFilme(Filme filme, Long id) {
		Optional<Filme> filmeExistente = filmeRepository.findById(id);
		if (filmeExistente.isPresent()) {
			filme.setId(id);
			filmeRepository.save(filme);
			return "Seu filme foi atualizado com sucesso!";
		} else
			return "Filme não encontrado!";

	}
	
	public String deletarFilme(Long id) {
		Optional<Filme> filmeExistente = filmeRepository.findById(id);
		if(filmeExistente.isPresent()) {
			filmeRepository.deleteById(id);
			return "Seu filme foi deletado!";
		} else
			return "O filme não pode ser encontrado.";
	}
}
