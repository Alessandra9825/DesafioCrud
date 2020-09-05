package MaquinaEstado;

import DesafioCrud.Business.RoupaNegocio;
import DesafioCrud.Comuns.Roupa;

import java.util.Scanner;

public class EstadoConsoleSalvar extends MaquinaEstadoConsole{
    @Override
    public boolean Executa() {
        boolean saida = false;
        Roupa obj = new Roupa();
        Scanner read = new Scanner(System.in);
/*
        obj.setCodigoItem();
        obj.setCor();
        obj.setDataEntrada();
        obj.setDescricao();
        obj.setLocalCompra();
        obj.setMarca();
        obj.setTamanho();
        obj.setTipo();
*/
        System.out.println("Informe ");

        return true;
    }
}