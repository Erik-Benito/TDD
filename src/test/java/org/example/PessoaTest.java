package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class PessoaTest {

    @org.junit.Test
    public void testPessoaValida() {
        // Teste 1: Nome válido, idade válida, e-mail válido
        Email email = new Email(1, "usuario@exemplo.com");
        Pessoa pessoa = new Pessoa(1, "João Silva", 25, email);

        List<String> erros = pessoa.ehValidoParaInclusao();
        assertTrue(erros.isEmpty(), "Pessoa válida não deveria conter erros.");
    }

    @org.junit.Test
    public void testNomeInvalidoUmaParte() {
        // Teste 2: Nome inválido (apenas uma parte), idade válida, e-mail válido
        Email email = new Email(2, "usuario@exemplo.com");
        Pessoa pessoa = new Pessoa(2, "João", 25, email);

        List<String> erros = pessoa.ehValidoParaInclusao();
        assertFalse(erros.isEmpty(), "Pessoa com nome inválido deveria ter erros.");
        assertTrue(erros.contains("O nome deve ter pelo menos duas partes e ser composto por letras."));
    }

    @org.junit.Test
    public void testIdadeInvalidaMenorQue1() {
        // Teste 3: Nome válido, idade inválida (menor que 1), e-mail válido
        Email email = new Email(3, "usuario@exemplo.com");
        Pessoa pessoa = new Pessoa(3, "João Silva", 0, email);

        List<String> erros = pessoa.ehValidoParaInclusao();
        assertFalse(erros.isEmpty(), "Pessoa com idade inválida deveria ter erros.");
        assertTrue(erros.contains("A idade deve estar no intervalo entre 1 e 200."));
    }

    @org.junit.Test
    public void testEmailInvalidoSemDominio() {
        // Teste 4: Nome válido, idade válida, e-mail inválido (formato errado)
        Email email = new Email(4, "usuario@exemplo");
        Pessoa pessoa = new Pessoa(4, "João Silva", 25, email);

        List<String> erros = pessoa.ehValidoParaInclusao();
        assertFalse(erros.isEmpty(), "Pessoa com e-mail inválido deveria ter erros.");
        assertTrue(erros.contains("O e-mail deve estar no formato correto."));
    }

    @org.junit.Test
    public void testEmailInvalidoSemArroba() {
        // Teste 5: Nome válido, idade válida, e-mail inválido (faltando o @)
        Email email = new Email(5, "usuarioexemplo.com");
        Pessoa pessoa = new Pessoa(5, "João Silva", 25, email);

        List<String> erros = pessoa.ehValidoParaInclusao();
        assertFalse(erros.isEmpty(), "Pessoa com e-mail inválido deveria ter erros.");
        assertTrue(erros.contains("O e-mail deve estar no formato correto."));
    }

    @org.junit.Test
    public void testNomeInvalidoComNumeros() {
        // Teste 6: Nome inválido (contém números), idade válida, e-mail válido
        Email email = new Email(6, "usuario@exemplo.com");
        Pessoa pessoa = new Pessoa(6, "João123 Silva", 25, email);

        List<String> erros = pessoa.ehValidoParaInclusao();
        assertFalse(erros.isEmpty(), "Pessoa com nome contendo números deveria ter erros.");
        assertTrue(erros.contains("O nome deve ter pelo menos duas partes e ser composto por letras."));
    }

    @org.junit.Test
    public void testIdadeInvalidaMaiorQue200() {
        // Teste 7: Nome válido, idade inválida (maior que 200), e-mail válido
        Email email = new Email(7, "usuario@exemplo.com");
        Pessoa pessoa = new Pessoa(7, "João Silva", 201, email);

        List<String> erros = pessoa.ehValidoParaInclusao();
        assertFalse(erros.isEmpty(), "Pessoa com idade inválida deveria ter erros.");
        assertTrue(erros.contains("A idade deve estar no intervalo entre 1 e 200."));
    }
}
