package DesafioCrud.Console;

import DesafioCrud.Business.Acesso;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        System.out.println("Seja Bem Vindo !");
        System.out.println();
        Acesso Validacao = new Acesso();
        Scanner read = new Scanner(System.in);
        int password;
        String user;

        do {
            System.out.println("Digite seu usuario:");
            user = read.next();

            System.out.println("Digite sua senha:");
            password = read.nextInt();
        }while(!Validacao.validaSenha(user,password));


        System.out.println("Escolha uma opção:");
        System.out.println("1- Inserir produto:");
        System.out.println("2- Remover produto:");
        System.out.println("3- Alterar Produto:");
        System.out.println("4- Consultar produtos:");
        int opcao = read.nextInt();
        switch (opcao){
            case 1:
                System.out.println("One");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("Three");
            case 4:
                System.out.println("Four");
            default:
                System.out.println("Digite SOMENTE números entre 1 e 4");
                break;
        }

    }
}