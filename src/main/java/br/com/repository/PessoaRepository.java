package br.com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("select p from Pessoa p where p.cpf = ?1")
    public Optional<Pessoa> findByCpf(String cpf);

    @Query("select p from Pessoa p where p.cpf = ?1")
    public List<Pessoa> findCpf(String cpf);

    //esse em teste
    @Query("select p from Pessoa p where p.cpf = ?1")
    public String verificaCpfAntesDeSalvar(String cpf);
}
