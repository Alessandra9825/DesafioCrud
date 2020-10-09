package Config;

import DesafioCrud.Comuns.Enuns.enumRepositorio;

public class Config {

    private static Config uniqueInstance;

    private Config(){
    }

    public static synchronized Config getInstance(){
        if(uniqueInstance == null)
            uniqueInstance = new Config();

        return uniqueInstance;
    }

    private enumRepositorio enumRepositorio;

    public enumRepositorio getEnumRepositorio() {
        return enumRepositorio;
    }

    public void setDataBase(enumRepositorio repositorio){
        this.enumRepositorio = repositorio;
    }
}
