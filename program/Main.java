package program;

import entities.Cpf;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<String> cpfList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File("C:\\temp\\Lista de CPFs.txt")))) {
            String line = br.readLine();
            while(line != null) {
                cpfList.add(line);
                line = br.readLine();
            }
            Cpf cpf = new Cpf(cpfList);
            cpf.filterCpf();


            System.out.println("Lista de CPFs válidos:");
            System.out.println(cpf.getValidCpf());

            System.out.println("Lista de CPFs inválidos:");
            System.out.println(cpf.getInvalidCpf());
        } catch (FileNotFoundException e) {
            System.out.print("Arquivo(s) não encontrado(s): " + e);
        } catch (IOException e) {
            System.out.print("Erro inesperado!: " + e);
        }
    }
}



