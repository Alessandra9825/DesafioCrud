import java.util.Scanner;
import business.Acesso;

public class Console {
    public static void main(String[] args) {
        System.out.println("Seja Bem Vindo !");
        System.out.println();

        System.out.println("Digite seu usuario:");
        Scanner read = new Scanner(System.in);
        String user = read.next();

        System.out.println("Digite sua senha:");
        int password = read.nextInt();

        Acesso Validacao = new Acesso();
        if ( Validacao.validaSenha(user,password))
        {
            System.out.println("Logado");
        }
    }
}