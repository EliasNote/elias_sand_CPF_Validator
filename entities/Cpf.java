package entities;

import java.util.ArrayList;
import java.util.List;

public class Cpf {
    private List<String> cpfList = new ArrayList<>();
    private List<String> validCpf = new ArrayList<>();
    private List<String> invalidCpf = new ArrayList<>();

    public Cpf(List<String> cpfList) {
        this.cpfList = cpfList;
    }

    public void validateCpf() {
        validCpf = cpfList.stream()
                .filter(x -> x.length() == 11)
                .toList();
        invalidCpf = cpfList.stream()
                .filter(x -> x.length() != 11)
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


