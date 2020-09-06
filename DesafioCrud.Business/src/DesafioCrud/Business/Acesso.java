package DesafioCrud.Business;

public class Acesso {
    public boolean login(String user, int pass){
        return validaUsuario(user, pass);
    }

    private boolean validaUsuario(String user, int password){
        if(user.equals("admin") && password == 12345678)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
