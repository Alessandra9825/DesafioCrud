package DesafioCrud.Business;

import Basis.FabricaRepositorio;
import DesafioCrud.Comuns.Enuns.enumEntidade;
import DesafioCrud.Comuns.vos.Usuario;
import Repositorio.Repositorio;

public class Acesso {
    private boolean validaSenha(Usuario userRepo, Usuario user){
        return userRepo.getSenha().equals(user.getSenha());
    }

    public boolean validaUsuario(Usuario user){
        Repositorio repositorio = FabricaRepositorio.Fabrica();
        Usuario usuario = (Usuario)repositorio.localiza(user.getLogin(), enumEntidade.USUARIO);
        if(usuario != null)
            return validaSenha(usuario, user);
        return false;
    }
}
