package entities.validations;

import java.util.ArrayList;
import java.util.List;

public class Validate {
    protected List<String> blackList;
    private String cpf;

    public Validate() { }

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }

    public boolean validateCpf(String cpf) {
        this.cpf = cpf.replaceAll("[.-]", "");
        // RETORNA VERDADEIRO SE O CPF PASSAR EM TODAS AS VALIDACOES
        return validateLength() && validateDigit() && validateBlackList();
    }

    public boolean validateLength() {
        // FILTRA OS 11 DIGITOS
        return cpf.length() == 11;
    }

    public boolean validateDigit() {
        // VERIFICA SE HA SOMENTE DIGITOS NO CPF
        boolean valid = true;
        for (char x : cpf.toCharArray()) { if (!Character.isDigit(x)) { valid = false; break; } }
        return valid;
    }

    public boolean validateBlackList() {
        // VERIFICA SE O CPF NAO ESTA NA BLACKLIST
        return !blackList.contains(cpf);
    }
}
