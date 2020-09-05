package DesafioCrud.Business;

public class Acesso {
    public boolean login(String user, String pass){
        return validaUsuario(user, pass);
    }

    private boolean validaUsuario(String user, String password){
        if(user.equals("admin") && password.equals("1234"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
