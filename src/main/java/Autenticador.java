import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Autenticador 
{
    private static final String ARQUIVO="senhaMestra.txt";

    public static void criaSenha(String senha)
    {
        try
        {
            String hash=Criptografia.geraHash(senha);
            Files.writeString(Paths.get(ARQUIVO),hash);
        }
        catch(IOException erro)
        {
            System.out.println("Erro ao escrever arquivo!");
        }
    }

    public static boolean validar(String senha)
    {
        try
        {
            String hash=Files.readString(Paths.get(ARQUIVO));
            return Criptografia.checaHash(senha,hash);
        }
        catch(IOException erro)
        {
            System.out.println("Erro ao ler arquivo!");
            return false;
        }
    }

    public static boolean senhaExiste()
    {
        return Files.exists(Paths.get(ARQUIVO));
    }

    public static void alteraSenha(String novaSenha)
    {
        criaSenha(novaSenha);
    }

    public static boolean deletaSenha(String senhaAtual)
    {
        if(!validar(senhaAtual))
        {
            return false;
        }

        try
        {
            Files.delete(Paths.get(ARQUIVO));
            return true;
        }
        catch(IOException e)
        {
            return false;
        }
    }
}
