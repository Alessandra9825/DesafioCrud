package DesafioCrud.DAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import DesafioCrud.Comuns.*;

public class RoupaDAO {

    private String path = System.getProperty("user.dir");

    private File validaTxt (){
        File dir = new File(path + "\\Estoque");

        if (!dir.exists())
            dir.mkdir();

        return dir;
    }

    public String salvar(Roupa obj)
    {
        try
        {
            validaTxt();

            FileWriter fw = new FileWriter("Produto.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println("codigoItem"+ obj.getCodigoItem());
            pw.println("dataEntrada"+obj.getDataEntrada());
            pw.println("localCompra"+obj.getLocalCompra());
            pw.println("tipo"+obj.getTipo());
            pw.println("marca"+obj.getMarca());
            pw.println("descrição"+obj.getDescricao());

            pw.flush();
            pw.close();
            fw.close();

        }
        catch (IOException err)
        {
            Logger.getLogger(RoupaDAO.class.getName()).log(Level.SEVERE, null, err);
        }
        return "Cadastrado com sucesso!";
    }

    public String delete (Roupa obj){
        return null;
    }
    public String alterar(Roupa obj)
    {
        return null;
    }
    public String consulta(String id)
    {
        return null;
    }
}
