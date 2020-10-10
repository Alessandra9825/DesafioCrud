package DesafioCrud.Comuns.vos;

import DesafioCrud.Comuns.Basis.Entidade;
import DesafioCrud.Comuns.Annotations.CampoNoBanco;

public class Usuario extends Entidade {

    @CampoNoBanco(nome = "login", chave = true)
    private String login;
    @CampoNoBanco(nome = "senha", chave = false)
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
