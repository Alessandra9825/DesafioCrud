package business;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegrasNegocio {
    public boolean ValidaTxt (File arquivo){
        if (arquivo.exists())
        {
            return false;
        }
        else
        {
            File arquivoNovo = new File ("Produto.txt");
        }
        return true;
    }
}
