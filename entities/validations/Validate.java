package entities.validations;
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
        return validateLength() && validateDigit() && validateBlackList() && validateMathematic();
    }

    // FILTRA OS 11 DIGITOS
    public boolean validateLength() {
        return cpf.length() == 11;
    }

    // VERIFICA SE HA SOMENTE DIGITOS NO CPF
    public boolean validateDigit() {
        boolean valid = true;
        for (char x : cpf.toCharArray()) { if (!Character.isDigit(x)) { valid = false; break; } }
        return valid;
    }

    // VERIFICA SE O CPF NAO ESTA NA BLACKLIST
    public boolean validateBlackList() {
        return !blackList.contains(cpf);
    }

    // FAZ O CALCULO PARA VERIFICAR OS DOIS ULTIMOS DIGITOS
    public boolean validateMathematic() {
        String value = cpf.substring(0, 9);
        for (int i = 0; i < 2; i++) {
            int total = 0;
            int counter = 10+i;
            for (char a : value.toCharArray()) {
                int cpfDigit = Character.getNumericValue(a);
                total += cpfDigit * counter;
                counter --;
            }
            value += String.valueOf(((11 - (total % 11)) < 10) ? 11 - (total % 11) : 0);
        }
        return value.equals(cpf) && !blackList.contains(value);
    }
}
