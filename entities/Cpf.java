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
        // FILTA OS 11 DIGITOS
        List<String> list = cpfList.stream()
                .filter(x -> x.length() == 11)
                .toList();

        // FILTRA POR NUMEROS
        for (String string : list) {
            boolean valid = true;
            for (char c : string.toCharArray()) {
                if (!Character.isDigit(c)) {
                    valid = false;
                }
            }
            if (valid) {
                validCpf.add(string);
            }
        }

        invalidCpf = cpfList.stream()
                .filter(x -> !validCpf.contains(x))
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


