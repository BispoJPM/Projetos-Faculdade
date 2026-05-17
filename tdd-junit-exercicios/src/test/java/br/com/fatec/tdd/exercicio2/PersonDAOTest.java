package br.com.fatec.tdd.exercicio2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonDAOTest {

    private final PersonDAO dao = new PersonDAO();

    @Test
    void deveRetornarListaVaziaQuandoPessoaForValida() {
        Person person = new Person(1, "João Silva", 25, List.of(new Email(1, "joao@email.com")));

        assertTrue(dao.isValidToInclude(person).isEmpty());
    }

    @Test
    void deveRetornarErroQuandoNomeTiverApenasUmaParte() {
        Person person = new Person(1, "João", 25, List.of(new Email(1, "joao@email.com")));

        List<String> errors = dao.isValidToInclude(person);

        assertEquals(1, errors.size());
        assertTrue(errors.contains("Nome deve conter ao menos duas partes."));
    }

    @Test
    void deveRetornarErroQuandoNomeTiverNumero() {
        Person person = new Person(1, "João Silva2", 25, List.of(new Email(1, "joao@email.com")));

        List<String> errors = dao.isValidToInclude(person);

        assertTrue(errors.contains("Nome deve conter apenas letras."));
    }

    @Test
    void deveRetornarErroQuandoIdadeForZero() {
        Person person = new Person(1, "João Silva", 0, List.of(new Email(1, "joao@email.com")));

        assertTrue(dao.isValidToInclude(person).contains("Idade deve estar no intervalo de 1 a 200."));
    }

    @Test
    void deveRetornarErroQuandoIdadeForMaiorQueDuzentos() {
        Person person = new Person(1, "João Silva", 201, List.of(new Email(1, "joao@email.com")));

        assertTrue(dao.isValidToInclude(person).contains("Idade deve estar no intervalo de 1 a 200."));
    }

    @Test
    void deveRetornarErroQuandoPessoaNaoTiverEmail() {
        Person person = new Person(1, "João Silva", 25, List.of());

        assertTrue(dao.isValidToInclude(person).contains("Pessoa deve possuir pelo menos um e-mail."));
    }

    @Test
    void deveRetornarErroQuandoEmailNaoTiverArroba() {
        Person person = new Person(1, "João Silva", 25, List.of(new Email(1, "joao.email.com")));

        assertTrue(dao.isValidToInclude(person).contains("E-mail deve estar no formato _____@____._____."));
    }

    @Test
    void deveRetornarErroQuandoEmailNaoTiverDominio() {
        Person person = new Person(1, "João Silva", 25, List.of(new Email(1, "joao@com")));

        assertTrue(dao.isValidToInclude(person).contains("E-mail deve estar no formato _____@____._____."));
    }

    @Test
    void deveRetornarMaisDeUmErroQuandoPessoaTiverVariosProblemas() {
        Person person = new Person(1, "João1", 0, List.of(new Email(1, "email-invalido")));

        List<String> errors = dao.isValidToInclude(person);

        assertEquals(4, errors.size());
    }
}
