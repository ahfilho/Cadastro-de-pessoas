package br.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
//
//	@Query("select p from Pessoa p where p.cpf like %?1% group by Pessoas")
//	public Optional<Pessoa> findByCountryCode(String country_code);


	@Query("select p from Pessoa p where p.cpf like %?1% group by Pessoas")
	public Optional<Pessoa> findByCpf(String cpf);


}
