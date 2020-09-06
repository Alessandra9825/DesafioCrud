package DesafioCrud.DAO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DesafioCrud.Comuns.*;

public class RoupaDAO {
    public final static String diretorio = "C:\\Repo\\DesafioCrud\\Produto.txt";

    public FileWriter  validaTxt () throws IOException {
        FileWriter arquivo;
        if (Files.exists(Paths.get(diretorio)))
        {
            arquivo = new FileWriter("Produto.txt",true);
        }
        else
        {
            arquivo = new FileWriter("Produto.txt");
        }
       return arquivo;
    }

    public String salvar(Roupa obj)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(validaTxt());
            bw.write(obj.getCodigoItem()+",");
            bw.write(obj.getDataEntrada()+",");
            bw.write(obj.getLocalCompra()+",");
            bw.write(obj.getTipo()+",");
            bw.write(obj.getMarca()+",");
            bw.write(obj.getDescricao()+",");


            bw.close();
            validaTxt().close();
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

    public String consulta(String id) throws FileNotFoundException
    {
        Roupa h= new Roupa();
        try
        {
            ArrayList<Roupa> listProdutos = new ArrayList<>();
            FileReader leitor = new FileReader(diretorio);
            BufferedReader leitorBuffer = new BufferedReader(leitor);
            String linha = "";

            while ((linha = leitorBuffer.readLine()) != null)
            {
                Roupa produto = new Roupa();
                String [] info = linha.split(",");

                produto.setCodigoItem(Integer.parseInt(info[0]));
                produto.setDescricao(info[1]);

            }

        }
        catch (IOException err)
        {
            Logger.getLogger(RoupaDAO.class.getName()).log(Level.SEVERE, null, err);
        }
        return id;
    }
}
