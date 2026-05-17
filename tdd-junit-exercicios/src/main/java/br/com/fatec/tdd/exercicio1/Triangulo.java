package br.com.fatec.tdd.exercicio1;

public class Triangulo {

    public TipoTriangulo classificar(int ladoA, int ladoB, int ladoC) {
        if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0) {
            throw new IllegalArgumentException("Todos os lados devem ser maiores que zero.");
        }

        if (ladoA + ladoB <= ladoC || ladoA + ladoC <= ladoB || ladoB + ladoC <= ladoA) {
            throw new IllegalArgumentException("Os lados informados não formam um triângulo.");
        }

        if (ladoA == ladoB && ladoB == ladoC) {
            return TipoTriangulo.EQUILATERO;
        }

        if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
            return TipoTriangulo.ISOSCELES;
        }

        return TipoTriangulo.ESCALENO;
    }
}
