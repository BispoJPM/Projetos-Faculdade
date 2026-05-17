package br.com.fatec.tdd.exercicio1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrianguloTest {

    private final Triangulo triangulo = new Triangulo();

    @Test
    void deveRetornarEscalenoQuandoTrianguloValido() {
        assertEquals(TipoTriangulo.ESCALENO, triangulo.classificar(3, 4, 5));
    }

    @Test
    void deveRetornarIsoscelesQuandoTrianguloValido() {
        assertEquals(TipoTriangulo.ISOSCELES, triangulo.classificar(5, 5, 8));
    }

    @Test
    void deveRetornarEquilateroQuandoTrianguloValido() {
        assertEquals(TipoTriangulo.EQUILATERO, triangulo.classificar(6, 6, 6));
    }

    @Test
    void deveRetornarIsoscelesComPermutacaoUm() {
        assertEquals(TipoTriangulo.ISOSCELES, triangulo.classificar(5, 5, 8));
    }

    @Test
    void deveRetornarIsoscelesComPermutacaoDois() {
        assertEquals(TipoTriangulo.ISOSCELES, triangulo.classificar(5, 8, 5));
    }

    @Test
    void deveRetornarIsoscelesComPermutacaoTres() {
        assertEquals(TipoTriangulo.ISOSCELES, triangulo.classificar(8, 5, 5));
    }

    @Test
    void deveLancarErroQuandoUmLadoForZero() {
        assertThrows(IllegalArgumentException.class, () -> triangulo.classificar(0, 4, 5));
    }

    @Test
    void deveLancarErroQuandoUmLadoForNegativo() {
        assertThrows(IllegalArgumentException.class, () -> triangulo.classificar(-3, 4, 5));
    }

    @Test
    void deveLancarErroQuandoSomaDeDoisLadosForIgualAoTerceiroPermutacaoUm() {
        assertThrows(IllegalArgumentException.class, () -> triangulo.classificar(1, 2, 3));
    }

    @Test
    void deveLancarErroQuandoSomaDeDoisLadosForIgualAoTerceiroPermutacaoDois() {
        assertThrows(IllegalArgumentException.class, () -> triangulo.classificar(1, 3, 2));
    }

    @Test
    void deveLancarErroQuandoSomaDeDoisLadosForIgualAoTerceiroPermutacaoTres() {
        assertThrows(IllegalArgumentException.class, () -> triangulo.classificar(3, 1, 2));
    }

    @Test
    void deveLancarErroQuandoSomaDeDoisLadosForMenorQueTerceiroPermutacaoUm() {
        assertThrows(IllegalArgumentException.class, () -> triangulo.classificar(1, 2, 4));
    }

    @Test
    void deveLancarErroQuandoSomaDeDoisLadosForMenorQueTerceiroPermutacaoDois() {
        assertThrows(IllegalArgumentException.class, () -> triangulo.classificar(1, 4, 2));
    }

    @Test
    void deveLancarErroQuandoSomaDeDoisLadosForMenorQueTerceiroPermutacaoTres() {
        assertThrows(IllegalArgumentException.class, () -> triangulo.classificar(4, 1, 2));
    }

    @Test
    void deveLancarErroQuandoTodosOsLadosForemZero() {
        assertThrows(IllegalArgumentException.class, () -> triangulo.classificar(0, 0, 0));
    }
}
