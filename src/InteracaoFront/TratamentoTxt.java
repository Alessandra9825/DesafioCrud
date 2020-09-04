package InteracaoFront;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import comuns.Roupa;

public class TratamentoTxt {

    public String salvar(Roupa obj)
    {
        try
        {
            FileWriter fw = new FileWriter("Produto.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println("codigoItem"+ obj.getCodigoItem());
            pw.println("dataEntrada"+obj.getDataEntrada());
            pw.println("localCompra"+obj.getLocalCompra());
            pw.println("tipo"+obj.getTipo());
            pw.println("marca"+obj.getMarca());
            pw.println("descrição"+obj.getDescricao());

            pw.flush();
            pw.close();
            fw.close();

        }
        catch (IOException err)
        {
            Logger.getLogger(TratamentoTxt.class.getName()).log(Level.SEVERE, null, err);
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
    public String consulta(String id)
    {
        return null;
     }
}
