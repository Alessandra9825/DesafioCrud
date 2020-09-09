package DesafioCrud.DAO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DesafioCrud.Comuns.*;

public class RoupaDAO {
    public final static String diretorio = System.getProperty("user.dir")+"\\Produto.txt";

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

    public boolean salvar(Roupa obj) {
        try
        {
            BufferedWriter bw = new BufferedWriter(validaTxt());
            bw.write(obj.getCodigoItem()+"|");
            bw.write(obj.getDataEntrada()+"|");
            bw.write(obj.getLocalCompra()+"|");
            bw.write(obj.getTipo()+"|");
            bw.write(obj.getMarca()+"|");
            bw.write(obj.getDescricao()+"|");
            bw.write(obj.getCor()+"|");
            bw.write(obj.getTamanho()+"|");
            bw.write(obj.getValorCompra()+"|");
            bw.write(obj.getValorSugerido()+"|");
            bw.write(obj.getValorEtiqueta()+"|");
            bw.write(obj.getValorMargem()+"\n");

            bw.close();
            validaTxt().close();
            return true;
        }
        catch (IOException err)
        {
            Logger.getLogger(RoupaDAO.class.getName()).log(Level.SEVERE, null, err);
            return false;
        }
    }

    public String delete ( int id){
        try
        {
            ArrayList<Roupa> listProdutos = new ArrayList<>();

            validaTxt();
            FileReader leitor = new FileReader(diretorio);
            BufferedReader leitorBuffer = new BufferedReader(leitor);
            String linha;

            while ((linha = leitorBuffer.readLine()) != null)
            {
                Roupa produto = new Roupa();
                String [] info = linha.split("\\|");

                produto.setCodigoItem(Integer.parseInt(info[0]));
                produto.setDataEntrada(LocalDateTime.parse(info[1]));
                produto.setLocalCompra(info[2]);
                produto.setTipo(info[3]);
                produto.setMarca(info[4]);
                produto.setDescricao(info[5]);
                produto.setCor(enumCor.valueOf(info[6]));
                produto.setTamanho(enumTamanho.valueOf(info[7]));
                produto.setValorCompra(Double.parseDouble(info[8]));
                produto.setValorSugerido(Double.parseDouble(info[9]));
                produto.setValorEtiqueta(Double.parseDouble(info[10]));
                produto.setValorMargem(Double.parseDouble(info[11]));

                listProdutos.add(produto);
            }

            Roupa consultada;
            consultada = find(id,listProdutos);
            if(listProdutos.remove(consultada))
            {
                FileWriter arquivo = new FileWriter("Produto.txt",true);
                Writer limparTxt  = new BufferedWriter( new FileWriter(String.valueOf(arquivo)));
                limparTxt.close();

                FileWriter Atualizado = new FileWriter("Produto.txt");
                BufferedWriter bw = new BufferedWriter(Atualizado);

                for (Roupa obj:listProdutos ){
                    bw.write(obj.getCodigoItem()+"|");
                    bw.write(obj.getDataEntrada()+"|");
                    bw.write(obj.getLocalCompra()+"|");
                    bw.write(obj.getTipo()+"|");
                    bw.write(obj.getMarca()+"|");
                    bw.write(obj.getDescricao()+"|");
                    bw.write(obj.getCor()+"|");
                    bw.write(obj.getTamanho()+"|");
                    bw.write(obj.getValorCompra()+"|");
                    bw.write(obj.getValorSugerido()+"|");
                    bw.write(obj.getValorEtiqueta()+"|");
                    bw.write(obj.getValorMargem()+"\n");
                }

                bw.close();
            }
            else{
                return "Produto não consta no Estoque!";
            }

        }
        catch (IOException err)
        {
            Logger.getLogger(RoupaDAO.class.getName()).log(Level.SEVERE, null, err);
        }

        return "Produto excluido com sucesso!";
    }

    public String  alterar(Roupa obj) {
        //validar se o arquivo existe e verificar ops campos que poderam sofrer alteracao
        try
        {
            Roupa nova  = new Roupa();
            nova.setCodigoItem(obj.getCodigoItem());
            nova.setDataEntrada(obj.getDataEntrada());
            nova.setLocalCompra(obj.getLocalCompra());
            nova.setMarca(obj.getMarca());
            nova.setDescricao(obj.getDescricao());
            nova.setTipo(obj.getTipo());
            nova.setCor(obj.getCor());
            nova.setTamanho(obj.getTamanho());
            nova.setValorCompra(obj.getValorCompra());
            nova.setValorSugerido(obj.getValorSugerido());
            nova.setValorEtiqueta(obj.getValorEtiqueta());
            nova.setValorMargem(obj.getValorMargem());

            delete(obj.getCodigoItem());
            salvar(nova);
        }
        catch (Exception err)
        {
            Logger.getLogger(RoupaDAO.class.getName()).log(Level.SEVERE, null, err);
        }
        return "Produto alterado com sucesso !!";
    }

    public Roupa consulta(int id)  {
        Roupa consultRoupa = new Roupa();
        try
        {
            ArrayList<Roupa> listProdutos = new ArrayList<>();

            validaTxt();
            FileReader leitor = new FileReader(diretorio);
            BufferedReader leitorBuffer = new BufferedReader(leitor);
            String linha;

            while ((linha = leitorBuffer.readLine()) != null)
            {
                Roupa produto = new Roupa();
                String [] info = linha.split("\\|");

                produto.setCodigoItem(Integer.parseInt(info[0]));
                produto.setDataEntrada(LocalDateTime.parse(info[1]));
                produto.setLocalCompra(info[2]);
                produto.setTipo(info[3]);
                produto.setMarca(info[4]);
                produto.setDescricao(info[5]);
                produto.setCor(enumCor.valueOf(info[6]));
                produto.setTamanho(enumTamanho.valueOf(info[7]));
                produto.setValorCompra(Double.parseDouble(info[8]));
                produto.setValorSugerido(Double.parseDouble(info[9]));
                produto.setValorEtiqueta(Double.parseDouble(info[10]));
                produto.setValorMargem(Double.parseDouble(info[11]));

                listProdutos.add(produto);
            }
            consultRoupa = find(id, listProdutos);
        }
        catch (IOException err)
        {
            Logger.getLogger(RoupaDAO.class.getName()).log(Level.SEVERE, null, err);
        }
        return consultRoupa;
    }

    private Roupa find (int id, ArrayList<Roupa> list) {
        Roupa consultada = null;

        for (Roupa obj : list)
        {
            if (obj.getCodigoItem() == id)
            {
                consultada = obj;
            }
        }

        return consultada;
    }
}
