package br.com.controller;

import java.util.List;
import java.util.Optional;

import br.com.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.com.entity.Pessoa;
import br.com.repository.PessoaRepository;

@org.springframework.stereotype.Controller
@RequestMapping("/pessoas/")
public class PessoaController {

    @Autowired
    private PessoaRepository repo;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/inicio")
    public String index() {
        return "index";
    }

    @GetMapping("cadastrar")
    public String index(Pessoa pessoa) {
        return "add";
    }

    @PostMapping("/add")
    public String add(@Validated Pessoa pessoa, BindingResult result) throws Exception{



        if (result.hasErrors()) {
            return "redirect:cadastrar";
        }
        pessoaService.adc(pessoa);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String listarTodos(Model model) {
        List<Pessoa> pesssoaList = pessoaService.listarTodos();
        model.addAttribute("person", this.repo.findAll());
        ResponseEntity.ok().body("TESTANDO FUNÇÃO");
        return "list";

    }

    @PostMapping("/search_code")
    public String getCountryCode(@RequestParam("country_code") String country_code, Model model, Pessoa pessoa) {
        Optional<Pessoa> p = repo.findByCountryCode(country_code);
        if (p.isPresent()) {
            model.addAttribute("person", p.get());
        }
        return ("pesquisa");
    }

    @GetMapping("edit/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Pessoa pessoa = this.repo.findById(id).orElseThrow(() -> new IllegalArgumentException("pessoa invalid" + id));
        model.addAttribute("person", pessoa);
        return "update";
    }

    @PostMapping("atualiz{id}")
    public String atualiza(@PathVariable("id") Long id, @Validated Pessoa pessoa, BindingResult result, Model model) {
        if (result.hasErrors()) {
            pessoa.setId(id);
            return "update";
        }
        this.repo.save(pessoa);
        repo.save(pessoa);
        model.addAttribute("person", this.repo.findAll());
        return "list";
    }

    @GetMapping("del/{id}")
    public String deleta(@PathVariable("id") Long id, Model model) {
        Pessoa pessoa = this.repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("teste deleta" + id));
        this.repo.delete(pessoa);
        model.addAttribute("person", this.repo.findAll());
        return "list";
    }
}
