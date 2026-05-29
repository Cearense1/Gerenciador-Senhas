import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.ArrayList;

public class Cofre 
{
    private final String arquivo="senhas.txt";
    private ArrayList<Senha> listaSenha=new ArrayList<>();

    public Cofre() 
    {
        try
        {
            List<String> linhas=Files.readAllLines(Paths.get(arquivo));

            for(String linha:linhas)
            {
                listaSenha.add(converterLinha(linha));
            }
        }
        catch(IOException e)
        {
            System.out.println("Erro ao ler arquivo!");
        }
    }

    public Senha converterLinha(String linha)
    {
        String[] partes=linha.split(";");

        return new Senha(partes[0],partes[1],partes[2]);
    }

    public void addSenha(String servico, String usuario, String senha) 
    {
        try
        {
            Senha novaSenha=new Senha(servico,usuario,senha);
            Files.writeString(Paths.get(arquivo),
            novaSenha.getLogin(), 
            StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            System.out.println("Senha adicionada com sucesso!");
        }
        catch(IOException e)
        {
            System.out.println("Erro ao escrever arquivo!");
        }
        
    }

    public void listarSenhas() 
    {
        if(listaSenha.isEmpty())
        {
            System.out.println("Não há senhas para listar!");
            return;
        }
        System.out.println("---------------");
        for(Senha senha:listaSenha)
        {
            System.out.println("Serviço: "+senha.getServico());
            System.out.println("Usuário: "+senha.getUsuario());
            System.out.println("Senha: "+senha.getSenha());

            System.out.println("---------------");
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
