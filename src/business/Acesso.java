package business;

public class Acesso {
    public boolean validaSenha(String user, int password){
        if(user.equals("admin")&& password == 12345678)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
