package entities;

import entities.validations.Validate;

import java.util.ArrayList;
import java.util.List;

public class Cpf {
    private List<String> cpfList;
    private List<String> validCpf = new ArrayList<>();
    private List<String> invalidCpf = new ArrayList<>();
    private Validate validate = new Validate();

    public Cpf() { }

    public Cpf(List<String> cpfList, List<String> blackList) {
        this.cpfList = cpfList;
        validate.setBlackList(
                blackList.stream()
                        .map(x -> x.replaceAll("[.-]",""))
                        .toList()
        );
    }

    public void filterCpf() {
        validCpf = cpfList.stream()
                .filter(x -> validate.validateCpf(x))
                .distinct()
                .toList();

        // RETORNA TODOS QUE NAO ESTAO NA LISTA validCpf
        invalidCpf = cpfList.stream()
                .filter(x -> !validate.validateCpf(x))
                .distinct()
                .toList();
    }

    public String getValidCpf() {
        StringBuilder sb = new StringBuilder();
        for (String cpf : validCpf) {
            sb.append(cpf + "\n");
        }
        return sb.toString();
    }
    public String getInvalidCpf() {
        StringBuilder sb = new StringBuilder();
        for (String cpf : invalidCpf) {
            sb.append(cpf + "\n");
        }
        return sb.toString();
    }
}


