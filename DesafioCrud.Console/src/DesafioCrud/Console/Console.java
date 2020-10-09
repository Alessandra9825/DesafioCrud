package DesafioCrud.Console;

import Config.Config;
import java.io.FileNotFoundException;
import java.io.IOException;

import DesafioCrud.Comuns.Enuns.enumRepositorio;
import MaquinaEstado.MaquinaEstadoConsole;
import MaquinaEstado.enumEstadoConsole;

public class Console {
    public static MaquinaEstadoConsole estadoConsole;

    public static void main(String[] args) throws IOException {
        Config.getInstance().setDataBase(enumRepositorio.TEXTO);

        String repositorio = Config.getInstance().getEnumRepositorio().getDescricao();
        System.out.println("Sistema configurado para " + repositorio);

        estadoConsole = enumEstadoConsole.BEM_VINDO.getEstadoConsole();
        boolean saida = false;
        while(!saida)
        {
            saida = estadoConsole.Executa();
        }
    }
}