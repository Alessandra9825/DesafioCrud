package MaquinaEstado;

import DesafioCrud.Business.RoupaNegocio;
import DesafioCrud.Comuns.Enuns.enumConsoleColors;
import DesafioCrud.Comuns.vos.Roupa;
import DesafioCrud.Console.Console;
import DesafioCrud.DAO.RoupaTextoDAO;
import java.util.Scanner;

public class EstadoConsoleAtualizar extends MaquinaEstadoConsole {
    private Scanner read = new Scanner(System.in);

    @Override
    public boolean Executa() {
        RoupaTextoDAO dao = new RoupaTextoDAO();
        RoupaNegocio neg = new RoupaNegocio();

        boolean saida = false;
        boolean resp = false;
        int codigoItem;

        System.out.println();
        System.out.println("Digite o codigo do item a ser alterado: ");
        codigoItem = read.nextInt();

        while(!resp){
            try{
                Roupa consultada = (Roupa)dao.seleciona(codigoItem);

                System.out.println();
                System.out.println("O que deseja alterar?");
                System.out.println("1- Local da compra");
                System.out.println("2- Tipo");
                System.out.println("3- Marca");
                System.out.println("4- Descrição");
                System.out.println("5- Cor");
                System.out.println("6- Tamanho");

                int opcao = read.nextInt();
                read.nextLine();

                switch (opcao)
                {
                    case 1:
                        System.out.println("Local da compra:");
                        consultada.setLocalCompra(read.nextLine());
                        break;
                    case 2:
                        System.out.println("Tipo:");
                        consultada.setTipo(read.nextLine());
                        break;
                    case 3:
                        System.out.println("Marca:");
                        consultada.setMarca(read.nextLine());
                        break;
                    case 4 :
                        System.out.println("Descrição:");
                        consultada.setDescricao(read.nextLine());
                        break;
                    case 5 :
                        consultada.setCor(neg.cor(read));
                        break;
                    case 6:
                        consultada.setTamanho(neg.tamanho(read));
                        break;
                    default:
                        System.out.println("A opção selecionada não existe");
                        break;
                }

                if(opcao <= 6 && opcao >= 1)
                    resp = neg.alterar(consultada);

                if(resp)
                    System.out.println(enumConsoleColors.YELLOW + "Produto atualizado com sucesso!" + enumConsoleColors.RESET);
                else{
                    resp = !novaAtualizacao();
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                resp = novaAtualizacao();
            }
        }

        Console.estadoConsole = enumEstadoConsole.HOME.getEstadoConsole();
        return saida;
    }

    private boolean novaAtualizacao(){
        int resp = -1;
        while (true){
            try{
                System.out.println();
                System.out.println("Deseja Reiniciar a Atualização?");
                System.out.println("0 - Não");
                System.out.println("1 - Sim");
                resp = read.nextInt();
                read.nextLine();

                if(resp == 0)
                    return false;
                else if (resp == 1)
                    return true;
                else
                    System.out.println(enumConsoleColors.RED + "Informe somente 0 ou 1!" + enumConsoleColors.RESET);
            }
            catch (Exception e)
            {
                System.out.println(enumConsoleColors.RED + "Informe 0 (sair) ou 1 (Atualizar)!" + enumConsoleColors.RESET);
            }
        }
    }

}

