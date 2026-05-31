import java.util.Scanner;
import java.util.InputMismatchException;

public class Main 
{
    public static void main(String[] args) throws InterruptedException
    {
        Menu menu = new Menu();
        Cofre cofre = new Cofre();
        int escolha,falhas=0;
        String senhaMestre, novaSenha;

        boolean rodando=true;
        Scanner scanner=new Scanner(System.in);
        
        if(!Autenticador.senhaExiste())
        {
            System.out.println("Crie a senha mestre:");
            senhaMestre=scanner.nextLine();
            Autenticador.criaSenha(senhaMestre);
        }

        menu.menuMestre();
        senhaMestre=scanner.nextLine();

        while(!Autenticador.validar(senhaMestre))
        {
            Thread.sleep((long)Math.pow(2,falhas)*1000);//dificulta ataques brute force
            falhas++;

            System.out.println("Senha incorreta! Tente novamente:");
            senhaMestre=scanner.nextLine();
        }

        while(rodando)
        {
            menu.exibirMenu();
            try
            {
                escolha=scanner.nextInt();
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

                if(!cofre.buscaSenha(servicoBuscar).equals(null))
                {
                    System.out.println("Senha: "+cofre.buscaSenha(servicoBuscar).getSenha());
                }
                else
                    System.out.println("Senha não encontrada!");

                break;
            case 5:
                System.out.println("Digite a senha atual:");
                senhaMestre=scanner.nextLine();

                if(!Autenticador.validar(senhaMestre))
                {
                    System.out.println("Senha incorreta!");
                    break;
                }

                System.out.println("Digite a nova senha");
                novaSenha=scanner.nextLine();
                Autenticador.alteraSenha(novaSenha);
                break;
            case 6:
                System.out.println("Digite a senha atual:");
                senhaMestre=scanner.nextLine();

                if(!Autenticador.validar(senhaMestre))
                {
                    System.out.println("Senha incorreta!");
                    break;
                }

                if(!Autenticador.deletaSenha(senhaMestre))
                {
                    System.out.println("Erro ao deletar a senha!");
                    break;
                }

                System.out.println("Senha deletada com sucesso!");
                break;
            case 7:
                System.out.println("Opção 7 selecionada\nEncerrando programa...");
                scanner.close();
                rodando=false;
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }

        }
        
    }

}
