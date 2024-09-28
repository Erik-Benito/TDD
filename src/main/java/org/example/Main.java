package org.example;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Email email = new Email(1, "usuario@exemplo.com");
        Pessoa pessoa = new Pessoa(1, "João Silva", 25, email);

        List<String> erros = pessoa.ehValidoParaInclusao();
        if (erros.isEmpty()) {
            System.out.println("Pessoa válida para inclusão.");
        } else {
            System.out.println("Erros encontrados:");
            for (int i = 0; i < erros.size(); i++) {
                System.out.println(erros.get(i));
            }
        }
    }
}
