package br.com.fatec.tdd.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public void save(Person person) {
        List<String> errors = isValidToInclude(person);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join("; ", errors));
        }
    }

    public List<String> isValidToInclude(Person person) {
        List<String> errors = new ArrayList<>();

        if (person == null) {
            errors.add("Pessoa não pode ser nula.");
            return errors;
        }

        validateName(person.getName(), errors);
        validateAge(person.getAge(), errors);
        validateEmails(person.getEmails(), errors);

        return errors;
    }

    private void validateName(String name, List<String> errors) {
        if (name == null || name.isBlank()) {
            errors.add("Nome é obrigatório.");
            return;
        }

        String[] parts = name.trim().split("\\s+");
        if (parts.length < 2) {
            errors.add("Nome deve conter ao menos duas partes.");
        }

        for (String part : parts) {
            if (!part.matches("[A-Za-zÀ-ÖØ-öø-ÿ]+")) {
                errors.add("Nome deve conter apenas letras.");
                break;
            }
        }
    }

    private void validateAge(int age, List<String> errors) {
        if (age < 1 || age > 200) {
            errors.add("Idade deve estar no intervalo de 1 a 200.");
        }
    }

    private void validateEmails(List<Email> emails, List<String> errors) {
        if (emails == null || emails.isEmpty()) {
            errors.add("Pessoa deve possuir pelo menos um e-mail.");
            return;
        }

        for (Email email : emails) {
            if (email == null || email.getName() == null || !email.getName().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
                errors.add("E-mail deve estar no formato _____@____._____.");
            }
        }
    }
}
