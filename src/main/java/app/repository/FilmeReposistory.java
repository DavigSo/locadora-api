package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Filme;

public interface FilmeReposistory extends JpaRepository<Filme, Long>{

}
