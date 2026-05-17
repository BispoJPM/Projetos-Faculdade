package br.com.fatec.tdd.exercicio3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraSalarioTest {

    private static final double DELTA = 0.001;
    private final CalculadoraSalario calculadora = new CalculadoraSalario();

    @Test
    void deveDescontarVintePorCentoParaDesenvolvedorComSalarioMaiorOuIgualATresMil() {
        Funcionario funcionario = new Funcionario("Ana", "ana@email.com", 3000.00, Cargo.DESENVOLVEDOR);

        assertEquals(2400.00, calculadora.calcularSalarioLiquido(funcionario), DELTA);
    }

    @Test
    void deveDescontarDezPorCentoParaDesenvolvedorComSalarioMenorQueTresMil() {
        Funcionario funcionario = new Funcionario("Ana", "ana@email.com", 2999.00, Cargo.DESENVOLVEDOR);

        assertEquals(2699.10, calculadora.calcularSalarioLiquido(funcionario), DELTA);
    }

    @Test
    void deveDescontarVinteECincoPorCentoParaDbaComSalarioMaiorOuIgualADoisMil() {
        Funcionario funcionario = new Funcionario("Bruno", "bruno@email.com", 2000.00, Cargo.DBA);

        assertEquals(1500.00, calculadora.calcularSalarioLiquido(funcionario), DELTA);
    }

    @Test
    void deveDescontarQuinzePorCentoParaDbaComSalarioMenorQueDoisMil() {
        Funcionario funcionario = new Funcionario("Bruno", "bruno@email.com", 1999.00, Cargo.DBA);

        assertEquals(1699.15, calculadora.calcularSalarioLiquido(funcionario), DELTA);
    }

    @Test
    void deveDescontarVinteECincoPorCentoParaTestadorComSalarioMaiorOuIgualADoisMil() {
        Funcionario funcionario = new Funcionario("Carlos", "carlos@email.com", 2000.00, Cargo.TESTADOR);

        assertEquals(1500.00, calculadora.calcularSalarioLiquido(funcionario), DELTA);
    }

    @Test
    void deveDescontarQuinzePorCentoParaTestadorComSalarioMenorQueDoisMil() {
        Funcionario funcionario = new Funcionario("Carlos", "carlos@email.com", 1999.00, Cargo.TESTADOR);

        assertEquals(1699.15, calculadora.calcularSalarioLiquido(funcionario), DELTA);
    }

    @Test
    void deveDescontarTrintaPorCentoParaGerenteComSalarioMaiorOuIgualACincoMil() {
        Funcionario funcionario = new Funcionario("Diana", "diana@email.com", 5000.00, Cargo.GERENTE);

        assertEquals(3500.00, calculadora.calcularSalarioLiquido(funcionario), DELTA);
    }

    @Test
    void deveDescontarVintePorCentoParaGerenteComSalarioMenorQueCincoMil() {
        Funcionario funcionario = new Funcionario("Diana", "diana@email.com", 4999.00, Cargo.GERENTE);

        assertEquals(3999.20, calculadora.calcularSalarioLiquido(funcionario), DELTA);
    }

    @Test
    void deveLancarErroQuandoFuncionarioForNulo() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcularSalarioLiquido(null));
    }
}
