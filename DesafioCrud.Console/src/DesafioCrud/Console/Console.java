package DesafioCrud.Console;

import DesafioCrud.Business.Acesso;
import java.util.Scanner;
import MaquinaEstado.MaquinaEstadoConsole;
import MaquinaEstado.enumEstadoConsole;

public class Console {
    public static MaquinaEstadoConsole estadoConsole;

    public static void main(String[] args) {
        estadoConsole = enumEstadoConsole.BEM_VINDO.getEstadoConsole();
        boolean saida = false;
        while(!saida){
            saida = estadoConsole.Executa();
        }
    }
}