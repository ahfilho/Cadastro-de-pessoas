package br.com.service;

import br.com.entity.Pessoa;
import br.com.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public void adc(Pessoa pessoa) {
        this.pessoaRepository.save(pessoa);
    }
    public List<Pessoa> listarTodos(){
        return this.pessoaRepository.findAll();
    }
}