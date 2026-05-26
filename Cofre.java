import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

public class Cofre 
{
    private final String arquivo="senhas.txt";

    public Cofre() 
    {
    }

    public void addSenha(String servico, String usuario, String senha) 
    {
        //Senha password = new Senha(servico, usuario, senha);
        //senhas.add(password);
        try
        {
            Files.writeString(Paths.get(arquivo),
            servico+";"+usuario+";"+senha, 
            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        catch(IOException e)
        {
            System.out.println("Erro ao escrever arquivo!");
        }
        
    }

    public void listarSenhas() 
    {
        try
        {
            List<String> linhas=Files.readAllLines(Paths.get("senhas.txt"));

            System.out.println("---------------");
            for(String linha:linhas)
            {
                String[] partes=linha.split(";");

                System.out.print("Serviço: ");
                System.out.println(partes[0]);

                System.out.print("Usuário: ");
                System.out.println(partes[1]);

                System.out.print("Senha: ");
                System.out.println(partes[2]);

                System.out.println("---------------");
            }
        }
        catch(IOException e)
        {
            System.out.println("Erro ao ler arquivo!");
        }
    }    

    public void removeSenha(String servico)
    {
        try
        {
            List<String> linhas=Files.readAllLines(Paths.get("senhas.txt"));
            linhas.removeIf(linha->linha.split(";")[0].equals(servico));

            Files.write(Paths.get("senhas.txt"),linhas);
            System.out.println("Senha removida com sucesso!");
        }
        catch(IOException e)
        {
            System.out.println("Erro ao remover senha!");
        }
    }

    public String buscaSenha(String servico)
    {
        try
        {
            List<String> linhas=Files.readAllLines(Paths.get("senhas.txt"));

            for(String linha:linhas)
            {
                String[] partes=linha.split(";");

                if(partes[0].equals(servico))
                {
                    return partes[2];
                }           
            }
            return "NULL"; 
        }
        catch(IOException e)
        {
            System.out.println("Senha não encontrada!");
            return "NULL";
        }
    }

}
