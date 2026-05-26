import java.util.ArrayList;

public class Cofre 
{
    private ArrayList<String> senhas;

    public Cofre() 
    {
        senhas = new ArrayList<>();
    }

    public void addSenha(String senha) 
    {
        senhas.add(senha);
    }

    public void listarSenhas() 
    {
        if(senhas.isEmpty())
        {
            System.out.println("Nenhuma senha armazenada!\n");
            return;
        }
        
        System.out.println("Senhas armazenadas:\n");
        for (String senha : senhas) 
        {
            System.out.println(senha);
        }
        
    }
}
