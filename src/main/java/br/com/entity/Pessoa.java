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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "person")
@Entity
public class Pessoa {

	//TODO validar e formatar cpf
	//TODO consertar a captura da data
    //TODO 	validação na interface
    //TODO validação na API
    //TODO validação no banco

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String cpf;

    //@NotNull
    //private Date dataNascimento;

    @NotNull
    private String email;


}
