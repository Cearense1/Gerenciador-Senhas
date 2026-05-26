import java.util.Scanner;
import java.util.InputMismatchException;

public class Main 
{
    public static void main(String[] args) 
    {
        Menu menu = new Menu();
        Cofre cofre = new Cofre();
        int escolha;

        boolean rodando=true;
        Scanner scanner=new Scanner(System.in);
        

        while(rodando)
        {
            menu.exibirMenu();
            try
            {
                escolha = scanner.nextInt();
                scanner.nextLine();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Digite apenas números!");
                scanner.nextLine();

                continue;
                }   

            switch (escolha) 
            {
            case 1:
                System.out.println("Opção 1 selecionada");

                
                System.out.println("Digite o nome de usuário: ");
                String senha, servico, usuario=scanner.nextLine();

                System.out.println("Digite a senha: ");
                senha=scanner.nextLine();

                System.out.println("Digite o serviço associado: ");
                servico=scanner.nextLine();

                cofre.addSenha(servico,usuario,senha);

                break;
            case 2:
                System.out.println("Opção 2 selecionada");
                cofre.listarSenhas();
                break;
            case 3:
                System.out.println("De que serviço deseja remover a senha?");
                String servicoRemove=scanner.nextLine();
                cofre.removeSenha(servicoRemove);
                
                break;
            case 4:
                System.out.println("De que serviço deseja buscar a senha?");
                String servicoBuscar=scanner.nextLine();

                if(!cofre.buscaSenha(servicoBuscar).equals("NULL"))
                {
                    System.out.println("Senha: "+cofre.buscaSenha(servicoBuscar));
                }
                else
                    System.out.println("Senha não encontrada!");

                break;
            case 5:
                System.out.println("Opção 5 selecionada\nEncerrando programa...");
                scanner.close();
                rodando=false;
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }

        }
        
    }

}
