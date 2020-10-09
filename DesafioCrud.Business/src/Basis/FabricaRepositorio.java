package Basis;

import Config.Config;
import DesafioCrud.Comuns.Enuns.enumRepositorio;
import Repositorio.MySQL.RepositorioMySQL;
import Repositorio.Repositorio;
import Repositorio.Texto.RepositorioTexto;

public class FabricaRepositorio {
    public static Repositorio Fabrica(){
        if(Config.getInstance().getEnumRepositorio() == enumRepositorio.MYSQL)
            return new RepositorioMySQL();
        else
            return new RepositorioTexto();
    }
}
