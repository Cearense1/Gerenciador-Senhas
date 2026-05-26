import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Menu menu = new Menu();
        Cofre cofre = new Cofre();
        
        boolean rodando=true;
        Scanner scanner=new Scanner(System.in);
        

        while(rodando)
        {
            menu.exibirMenu();
            int escolha=scanner.nextInt();
            scanner.nextLine();

            switch (escolha) 
            {
            case 1:
                System.out.println("Opção 1 selecionada");

                
                System.out.print("Digite a senha a ser adicionada: ");

                String senha=scanner.nextLine();
                cofre.addSenha(senha);

                break;
            case 2:
                System.out.println("Opção 2 selecionada");
                cofre.listarSenhas();
                break;
            case 3:
                System.out.println("Opção 3 selecionada\n Encerrando programa...");
                scanner.close();
                rodando=false;
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }

        }
        
    }

}
