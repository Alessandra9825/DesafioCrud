package DesafioCrud.DAO;

import Basis.DAO;
import DesafioCrud.Comuns.Basis.Entidade;
import DesafioCrud.Comuns.Enuns.enumCor;
import DesafioCrud.Comuns.Enuns.enumTamanho;
import DesafioCrud.Comuns.vos.Roupa;
import DesafioCrud.Comuns.vos.Usuario;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioTextoDAO extends DAO {
    public final static String diretorio = System.getProperty("user.dir")+"\\Usuario.txt";

    public UsuarioTextoDAO() {
        super(Usuario.class);
    }

    private FileWriter validaTxt () throws IOException {
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

    public boolean salvar(Usuario obj) {
        try
        {
            BufferedWriter bw = new BufferedWriter(validaTxt());
            bw.write(obj.getLogin()+"|");
            bw.write(obj.getSenha()+"\n");

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

    public boolean delete (Usuario object){
        try
        {
            ArrayList<Usuario> listaUsuarios = lista();
            if(listaUsuarios.removeIf(user -> (user.getLogin() == object.getLogin() && user.getSenha() == object.getSenha())))
            {
                FileWriter arquivo = new FileWriter("Produto.txt",true);
                Writer limparTxt  = new BufferedWriter( new FileWriter(String.valueOf(arquivo)));
                limparTxt.close();

                FileWriter Atualizado = new FileWriter("Produto.txt");
                BufferedWriter bw = new BufferedWriter(Atualizado);

                for (Usuario obj:listaUsuarios ){
                    bw.write(obj.getLogin()+"|");
                    bw.write(obj.getSenha()+"\n");
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

    public boolean alterar(Usuario obj) {
        //validar se o arquivo existe e verificar ops campos que poderam sofrer alteracao
        try
        {
            Usuario nova = new Usuario();
            nova.setSenha(obj.getSenha());

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

    @Override
    public Entidade seleciona(int id) {
        return null;
    }

    @Override
    public Entidade localiza(String codigo) throws SQLException {
        Usuario consultUser = null;

        try
        {
            ArrayList<Usuario> listUsuarios = lista();
            consultUser = find(codigo, listUsuarios);
        }
        catch (Exception e)
        {
            Logger.getLogger(RoupaTextoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return consultUser;
    }

    private Usuario find (String login, ArrayList<Usuario> list) {
        for (Usuario user : list) {
            if (login.equals(user.getLogin()))
                return user;
        }

        return null;
    }

    @Override
    public ArrayList lista() throws SQLException {
        ArrayList<Usuario> listUsuarios = new ArrayList<Usuario>();

        try
        {
            validaTxt();
            FileReader leitor = new FileReader(diretorio);
            BufferedReader leitorBuffer = new BufferedReader(leitor);
            String linha;

            while ((linha = leitorBuffer.readLine()) != null)
            {
                Usuario user = new Usuario();
                String [] info = linha.split("\\|");

                user.setLogin(info[0]);
                user.setSenha(info[1]);

                listUsuarios.add(user);
            }
        }
        catch (IOException err)
        {
            Logger.getLogger(RoupaTextoDAO.class.getName()).log(Level.SEVERE, null, err);

            return null;
        }

        return listUsuarios;
    }
}
