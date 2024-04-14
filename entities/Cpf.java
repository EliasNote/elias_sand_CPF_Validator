package entities;

import java.util.ArrayList;
import java.util.List;

public class Cpf {
    private List<String> cpfList;
    private List<String> blackList;
    private List<String> validCpf = new ArrayList<>();
    private List<String> invalidCpf = new ArrayList<>();

    public Cpf(List<String> cpfList, List<String> blackList) {
        this.cpfList = cpfList;
        this.blackList = blackList.stream()
                .map(x -> x.replaceAll("[.-]",""))
                .toList();
    }

    public void validateCpf() {
        validCpf = cpfList.stream()
                .filter(x -> filterCpf(x))
                .distinct()
                .toList();

        // RETORNA TODOS QUE NAO ESTAO NA LISTA validCpf
        invalidCpf = cpfList.stream()
                .filter(x -> !filterCpf(x))
                .distinct()
                .toList();
    }

    private Boolean filterCpf(String cpf) {
        String c = cpf.replaceAll("[.-]","");

        // FILTRA OS 11 DIGITOS
        if (c.length() == 11) {

            // VERIFICA SE HA SOMENTE DIGITOS NO CPF
            boolean valid = true;
            for (char x : c.toCharArray()) { if (!Character.isDigit(x)) { valid = false; break; } }

            // SE HA SOMENTE DIGITOS NO CPF E ELE NAO ESTIVER NA BLACKLIST RETORNA TRUE
            return valid && !blackList.contains(c);
        }
        return false;
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


