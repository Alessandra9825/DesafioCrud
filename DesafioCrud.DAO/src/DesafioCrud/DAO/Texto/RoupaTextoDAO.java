package DesafioCrud.DAO.Texto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Basis.DAO;
import DesafioCrud.Comuns.Basis.Entidade;
import DesafioCrud.Comuns.Enuns.enumCor;
import DesafioCrud.Comuns.Enuns.enumTamanho;
import DesafioCrud.Comuns.vos.Roupa;

public class RoupaTextoDAO extends DAO {
    public final static String diretorio = System.getProperty("user.dir")+"\\Produto.txt";

    public RoupaTextoDAO() {
        super(Roupa.class);
    }

    private FileWriter  validaTxt () throws IOException {
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
            Logger.getLogger(RoupaTextoDAO.class.getName()).log(Level.SEVERE, null, err);
            return false;
        }
    }

    public boolean delete (Roupa object){
        try
        {
            ArrayList<Roupa> listProdutos = lista();
            if(listProdutos.removeIf(roupa -> (roupa.getCodigoItem() == object.getCodigoItem())))
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
                return false;
            }
        }
        catch (IOException | SQLException err)
        {
            Logger.getLogger(RoupaTextoDAO.class.getName()).log(Level.SEVERE, null, err);
        }

        return true;
    }

    public boolean alterar(Roupa obj) {
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

            delete(obj);
            salvar(nova);
        }
        catch (Exception err)
        {
            Logger.getLogger(RoupaTextoDAO.class.getName()).log(Level.SEVERE, null, err);
            return false;
        }

        return true;
    }

    public ArrayList<Roupa> consultaCor(enumCor cor) throws SQLException {
        ArrayList<Roupa> listaProdutos = lista();
        listaProdutos.removeIf(obj -> (obj.getCor() != cor));
        return listaProdutos;
    }

    public ArrayList<Roupa> consultaTamanho(enumTamanho tamanho) throws SQLException {
        ArrayList<Roupa> listaProdutos = lista();
        listaProdutos.removeIf(obj -> (obj.getTamanho() != tamanho));
        return listaProdutos;
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

    @Override
    public Entidade seleciona(int id) {
        Roupa consultRoupa = null;

        try
        {
            ArrayList<Roupa> listProdutos = lista();
            consultRoupa = find(id, listProdutos);
        }
        catch (Exception e)
        {
            Logger.getLogger(RoupaTextoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return consultRoupa;
    }

    @Override
    public Entidade localiza(String codigo) throws SQLException {
        return null;
    }

    @Override
    public ArrayList lista() throws SQLException {
        ArrayList<Roupa> listProdutos = new ArrayList<Roupa>();

        try
        {
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
        }
        catch (IOException err)
        {
            Logger.getLogger(RoupaTextoDAO.class.getName()).log(Level.SEVERE, null, err);

            return null;
        }

        return listProdutos;
    }
}
