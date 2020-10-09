package DesafioCrud.Comuns.vos;

import DesafioCrud.Comuns.Basis.Entidade;

public class Usuario extends Entidade {

    private String login;
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
