package entities.validations;
import java.util.List;

public class Validate {
    private String cpf;

    public Validate() { }

    public boolean validateCpf(String cpf) {
        // REMOVE OS PONTOS E TRAÇO
        this.cpf = cpf.replaceAll("[.-]", "");

        // RETORNA VERDADEIRO SE O CPF PASSAR EM TODAS AS VALIDACOES
        return validateLength() && validateDigit();
    }

    // FILTRA OS 11 DIGITOS
    public boolean validateLength() {
        return cpf.length() == 11;
    }

    // VERIFICA SE HA SOMENTE DIGITOS NO CPF
    public boolean validateDigit() {
        for (char x : cpf.toCharArray()) { if (!Character.isDigit(x)) { return false; } }
        return true;
    }
}