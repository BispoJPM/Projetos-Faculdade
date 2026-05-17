# TDD com JUnit — Exercícios

Projeto em **Java 17**, usando **JUnit 5** para testes automatizados e **JaCoCo** para evidência de cobertura de código.

## URL do repositório Git

Após criar o repositório no GitHub, substitua abaixo pela URL real:

```text
https://github.com/SEU_USUARIO/tdd-junit-exercicios
```

## Tecnologias

- Java 17
- Maven
- JUnit 5
- JaCoCo

## Como executar o build

```bash
mvn clean install
```

## Como executar os testes

```bash
mvn test
```

## Como gerar cobertura de código

```bash
mvn clean test
```

Após executar o comando, abra o relatório em:

```text
target/site/jacoco/index.html
```

## Estrutura do projeto

```text
src
├── main
│   └── java/br/com/fatec/tdd
│       ├── exercicio1
│       ├── exercicio2
│       └── exercicio3
└── test
    └── java/br/com/fatec/tdd
        ├── exercicio1
        ├── exercicio2
        └── exercicio3
```

---

# Exercício 1 — Triângulo

## Objetivo

Implementar uma classe que recebe três lados inteiros e informa se eles formam um triângulo:

- Escaleno
- Isósceles
- Equilátero

Caso os lados não formem um triângulo, o programa lança `IllegalArgumentException`.

## Regra principal

A soma de dois lados deve ser maior que o terceiro lado.

## Classes implementadas

- `Triangulo`
- `TipoTriangulo`

## Testes implementados

Arquivo:

```text
src/test/java/br/com/fatec/tdd/exercicio1/TrianguloTest.java
```

Casos cobertos:

- Triângulo escaleno válido
- Triângulo isósceles válido
- Triângulo equilátero válido
- 3 permutações de isósceles válido
- Um valor zero
- Um valor negativo
- Soma de dois lados igual ao terceiro lado
- Permutações da soma igual ao terceiro lado
- Soma de dois lados menor que o terceiro lado
- Permutações da soma menor que o terceiro lado
- Três valores iguais a zero

## Evidência de cobertura

Gerar com:

```bash
mvn clean test
```

Relatório:

```text
target/site/jacoco/index.html
```

Print sugerido para entrega:

```text
Relatório JaCoCo mostrando cobertura da classe Triangulo.
```

---

# Exercício 2 — PersonDAO

## Objetivo

Implementar o método `isValidToInclude(Person person)` usando TDD.

O método retorna uma lista de erros com base nas validações da pessoa.

## Regras validadas

- O nome deve possuir pelo menos duas partes
- O nome deve conter apenas letras
- A idade deve estar no intervalo `[1, 200]`
- A pessoa deve possuir pelo menos um e-mail
- O e-mail deve estar no formato `_____@____._____`

## Classes implementadas

- `Person`
- `Email`
- `PersonDAO`

## Testes implementados

Arquivo:

```text
src/test/java/br/com/fatec/tdd/exercicio2/PersonDAOTest.java
```

Casos cobertos:

- Pessoa válida
- Nome com apenas uma parte
- Nome contendo número
- Idade igual a zero
- Idade maior que 200
- Pessoa sem e-mail
- E-mail sem arroba
- E-mail sem domínio válido
- Pessoa com múltiplos erros

## Evidência de cobertura

Gerar com:

```bash
mvn clean test
```

Relatório:

```text
target/site/jacoco/index.html
```

Print sugerido para entrega:

```text
Relatório JaCoCo mostrando cobertura das classes PersonDAO, Person e Email.
```

---

# Exercício 3 — Calculadora de Salário

## Objetivo

Implementar uma calculadora de salário líquido de funcionários usando TDD.

Cada funcionário possui:

- Nome
- E-mail
- Salário-base
- Cargo

## Regras de desconto

| Cargo | Condição | Desconto |
|---|---:|---:|
| DESENVOLVEDOR | salário >= 3000 | 20% |
| DESENVOLVEDOR | salário < 3000 | 10% |
| DBA | salário >= 2000 | 25% |
| DBA | salário < 2000 | 15% |
| TESTADOR | salário >= 2000 | 25% |
| TESTADOR | salário < 2000 | 15% |
| GERENTE | salário >= 5000 | 30% |
| GERENTE | salário < 5000 | 20% |

## Classes implementadas

- `Funcionario`
- `Cargo`
- `CalculadoraSalario`

## Testes implementados

Arquivo:

```text
src/test/java/br/com/fatec/tdd/exercicio3/CalculadoraSalarioTest.java
```

Casos cobertos:

- Desenvolvedor com salário maior ou igual a 3000
- Desenvolvedor com salário menor que 3000
- DBA com salário maior ou igual a 2000
- DBA com salário menor que 2000
- Testador com salário maior ou igual a 2000
- Testador com salário menor que 2000
- Gerente com salário maior ou igual a 5000
- Gerente com salário menor que 5000
- Funcionário nulo

## Evidência de cobertura

Gerar com:

```bash
mvn clean test
```

Relatório:

```text
target/site/jacoco/index.html
```

Print sugerido para entrega:

```text
Relatório JaCoCo mostrando cobertura da classe CalculadoraSalario.
```

---

# Comandos Git sugeridos

```bash
git init
git add .
git commit -m "feat: implementa exercícios de TDD com JUnit"
git branch -M main
git remote add origin https://github.com/SEU_USUARIO/tdd-junit-exercicios.git
git push -u origin main
```
