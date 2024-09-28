package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private Email email;

    public Pessoa(int id, String nome, int idade, Email email) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Email getEmail() {
        return email;
    }

    public List<String> ehValidoParaInclusao() {
        List<String> erros = new ArrayList<String>();

        // Validação do nome (deve conter ao menos 2 partes e ser composto por letras)
        if (nome == null || !nome.matches("^[\\p{L}]+(\\s[\\p{L}]+)+$")) {
            erros.add("O nome deve ter pelo menos duas partes e ser composto por letras.");
        }

        // Validação da idade (deve estar entre 1 e 200)
        if (idade < 1 || idade > 200) {
            erros.add("A idade deve estar no intervalo entre 1 e 200.");
        }

        // Validação do e-mail (formato correto)
        if (email == null || !email.isValid()) {
            erros.add("O e-mail deve estar no formato correto.");
        }

        return erros;
    }
}
