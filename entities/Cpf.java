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
        filterCpfList();

        // RETORNA TODOS QUE NAO ESTAO NA LISTA validCpf
        invalidCpf = cpfList.stream()
                .filter(x -> !validCpf.contains(x))
                .toList();
    }

    public void filterCpfList() {
        for (String cpf : cpfList) {
            String c = cpf.replaceAll("[.-]","");

            // FILTRA OS 11 DIGITOS
            if (c.length() == 11) {

                // VERIFICA SE HA SOMENTE DIGITOS NO CPF
                boolean valid = true;
                for (char x : c.toCharArray()) { if (!Character.isDigit(x)) { valid = false; } }
                if (valid) { validCpf.add(cpf); }
            }
        }
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


