import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        catch(IOException erro)
        {
            System.out.println("Erro ao ler arquivo!");
        }
    }

    public Senha converterLinha(String linha)
    {
        String[] partes=linha.split(";");

        return new Senha(partes[0],partes[1],partes[2]);
    }

    private void salvarArquivo()
    {
        try
        {
           List<String> linhas=new ArrayList<>();

            for(Senha senha:listaSenha)
            {
                linhas.add(senha.getLogin());
            }

            Files.write(Paths.get(arquivo), linhas);
        }

        catch(IOException e)
        {
        System.out.println("Erro ao salvar arquivo!");
        }
    }

    public void addSenha(String servico, String usuario, String senha) 
    {
        Senha novaSenha=new Senha(servico,usuario,senha);
        listaSenha.add(novaSenha);

        salvarArquivo();
        
        System.out.println("Senha adicionada com sucesso!");
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
        boolean removido=listaSenha.removeIf(senha->senha.getServico().equals(servico));

        if(removido)
        {
            salvarArquivo();
            System.out.println("Senha removida com sucesso!");
        }

        else
        {
            System.out.println("Serviço não encontrado!");
        }
    }

    public Senha buscaSenha(String servico)
    {
        for(Senha senha:listaSenha)
        {
            if(senha.getServico().equals(servico))
            {
                return senha;
            }
        }

        return null;
    }

}
