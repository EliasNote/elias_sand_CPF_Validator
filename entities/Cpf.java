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

        // SEPARA CADA CPF DE ACORDO COM O NONO DIGITO DA REGIAO
        String[] state = new String[10];
        for (String cpf : validCpf) {
            char digit = cpf.replaceAll("[.-]","").charAt(8);
            state[Character.getNumericValue(digit)] += cpf+",";
        }

        // FAZ A IMPRESSAO DE CADA CPF DE ACORDO COM A REGIAO
        for (int i = 0; i < state.length; i++) {
            if (state[i] != null) {
                switch(i) {
                    case 0:
                        sb.append("\nRegião: Rio Grande do Sul:\n");
                        break;
                    case 1:
                        sb.append("\nRegião: Distrito Federal, Goiás, Mato Grosso do Sul e Tocantins:\n");
                        break;
                    case 2:
                        sb.append("\nRegião: Pará, Amazonas, Acre, Amapá, Rondônia e Roraima:\n");
                        break;
                    case 3:
                        sb.append("\nRegião: Ceará, Maranhão e Piauí:\n");
                        break;
                    case 4:
                        sb.append("\nRegião: Pernambuco, Rio Grande do Norte, Paraíba e Alagoas:\n");
                        break;
                    case 5:
                        sb.append("\nRegião: Bahia; e Sergipe:\n");
                        break;
                    case 6:
                        sb.append("\nRegião: Minas Gerais:\n");
                        break;
                    case 7:
                        sb.append("\nRegião: Rio de Janeiro e Espírito Santo:\n");
                        break;
                    case 8:
                        sb.append("\nRegião: São Paulo:\n");
                        break;
                    case 9:
                        sb.append("\nRegião: Paraná e Santa Catarina:\n");
                        break;
                }
                for (String cpf : state[i].split(",")) {
                    sb.append(cpf.replace("null","") + "\n");
                }
            }
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


