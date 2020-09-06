package DesafioCrud.DAO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
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
            bw.write(obj.getCor()+",");
            bw.write(obj.getTamanho()+"\n");

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

    public Roupa  consulta(int id) throws FileNotFoundException
    {
        Roupa consultada = new Roupa();
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
                produto.setDataEntrada(LocalDateTime.parse(info[1]));
                produto.setLocalCompra(info[2]);
                produto.setTipo(info[3]);
                produto.setMarca(info[4]);
                produto.setDescricao(info[5]);
                produto.setCor(enumCor.valueOf(info[6]));
                produto.setTamanho(enumTamanho.valueOf(info[7]));

                listProdutos.add(produto);
            }
             consultada = listProdutos.get(id);
        }
        catch (IOException err)
        {
            Logger.getLogger(RoupaDAO.class.getName()).log(Level.SEVERE, null, err);
        }
        return consultada;

    }
}
