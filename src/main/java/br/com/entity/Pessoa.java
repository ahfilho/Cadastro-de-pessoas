package br.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "person")
@Entity
public class Pessoa {

    //TODO validar e formatar cpf  -- VALIDADO
    //TODO consertar a captura da data  --- FEITO
    //TODO 	validação na interface -- FEITO
    //TODO validação na API
    //TODO validação no banco

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    @CPF
    private String cpf;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @NotNull
    private String email;


}
