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
        List<String> blackList = new ArrayList<>();

        try (BufferedReader brCpf = new BufferedReader(new FileReader(new File("C:\\temp\\Lista de CPFs.txt")));
             BufferedReader brBlack = new BufferedReader(new FileReader(new File("C:\\temp\\Blacklist CPFs.txt")))) {

            String line = brCpf.readLine();
            while(line != null) {
                cpfList.add(line);
                line = brCpf.readLine();
            }

            line = brBlack.readLine();
            while(line != null) {
                blackList.add(line);
                line = brBlack.readLine();
            }

            Cpf cpf = new Cpf(cpfList, blackList);
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