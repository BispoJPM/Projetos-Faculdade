package br.com.fatec.tdd.exercicio3;

public class CalculadoraSalario {

    public double calcularSalarioLiquido(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        }

        double salarioBase = funcionario.getSalarioBase();
        double desconto = obterPercentualDesconto(funcionario.getCargo(), salarioBase);

        return salarioBase - (salarioBase * desconto);
    }

    private double obterPercentualDesconto(Cargo cargo, double salarioBase) {
        if (cargo == null) {
            throw new IllegalArgumentException("Cargo é obrigatório.");
        }

        return switch (cargo) {
            case DESENVOLVEDOR -> salarioBase >= 3000.00 ? 0.20 : 0.10;
            case DBA, TESTADOR -> salarioBase >= 2000.00 ? 0.25 : 0.15;
            case GERENTE -> salarioBase >= 5000.00 ? 0.30 : 0.20;
        };
    }
}
