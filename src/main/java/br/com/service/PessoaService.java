package br.com.service;

import br.com.entity.Pessoa;
import br.com.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;


@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public void adc(Pessoa pessoa) {
        this.pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarTodos() {
        return this.pessoaRepository.findAll();
    }

    public Optional<Pessoa> getCpf(String cpf) {
        return this.pessoaRepository.findByCpf(cpf);
    }

    public Optional<Pessoa> edit(Long id) {
        this.pessoaRepository.findById(id);

        return this.pessoaRepository.findById(id);
    }

    public void deleta(Long id) throws Exception {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            pessoaRepository.delete(pessoa.get());
        }
    }

    public void findById(Long id) {
        this.pessoaRepository.findById(id);
    }

}





