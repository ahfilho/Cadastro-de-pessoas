package br.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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
    //TODO- SPRING E MYSQL - OK
    //TODO API REST - OK
    //TODO -- DADOS PERSISTIDOS NO BANCO COM INTERFACE PARA CRUD  -- OK
    //TODO -- A APLICAÇÃO CONFIGURA A BASE DE INICIALIZAÇÃO -- OK
    //TODO validar e formatar cpf  -- OK
    //TODO 	validação na interface -- OK
    //TODO validação na API -- OK
    //TODO validação no banco  -- OK

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull
    @CPF
    @NotBlank(message = "Cpf é obrigatório")
    private String cpf;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @NotNull
    @NotBlank(message = "E-mail é obrigatório")
    private String email;


}
