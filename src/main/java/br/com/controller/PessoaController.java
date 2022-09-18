package br.com.controller;

import br.com.entity.Pessoa;
import br.com.repository.PessoaRepository;
import br.com.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static java.sql.Date.valueOf;
import static java.util.Date.*;

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
    public String add(@Validated Pessoa pessoa, BindingResult result, HttpServletRequest request,
                      HttpServletResponse response) throws Exception {

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

    @PostMapping("/search_cpf")
    public String getCountryCode(@RequestParam("cpf") String cpf, Model model, Pessoa pessoa) {
        Optional<Pessoa> p = pessoaService.getCpf(cpf);
        if (p.isPresent()) {
            model.addAttribute("person", p.get());
            return ("pesquisa");
        }
        return ("inicio");
    }

    @GetMapping("edit/{id}")
    public String update(Model model, @PathVariable(name = "id") Long id) {
        Pessoa pessoa = this.pessoaService.update(id).orElseThrow(() -> new IllegalArgumentException("pessoa invalid" + id));

        model.addAttribute("person", pessoa);
        pessoa.getCpf();
        System.out.println(pessoa.getNome());

        System.out.println(pessoa.getCpf());
        return "update";
    }

    @PostMapping("atualiza/{id}")
    public String atualiza(@Validated Pessoa pessoa, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "update";
        }
        pessoaService.adc(pessoa);
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
