import java.util.ArrayList;

public class Cofre 
{
    private ArrayList<Senha> senhas;

    public Cofre() 
    {
        senhas = new ArrayList<Senha>();
    }

    public void addSenha(String servico, String usuario, String senha) 
    {
        Senha password = new Senha(servico, usuario, senha);
        senhas.add(password);
    }

    public void listarSenhas() 
    {
        if(senhas.isEmpty())
        {
            System.out.println("Nenhuma senha armazenada!\n");
            return;
        }
        
        System.out.println("Senhas armazenadas:\n");
        for (Senha senha:senhas) 
        {
            System.out.println("Serviço: "+senha.getServico());
            System.out.println("Usuário: "+senha.getUsuario());
            System.out.println("Senha: "+senha.getSenha()+"\n");
        }
    }

    public void removeSenha(String servico)
    {
        boolean removido=false;
        if(!senhas.isEmpty())
        {
            for(int i=0;i<senhas.size();i++)
            {
                if(senhas.get(i).getServico().equals(servico))
                {
                    senhas.remove(i);
                    removido=true;
                    break;
                }
            }
            if(removido)
                System.out.println("Senha removida com sucesso!");
            else
                System.out.println("Senha não encontrada!");
        }
        else
            System.out.println("Não há senhas para remover!");
    }

    public String buscaSenha(String servico)
    {
        if(!senhas.isEmpty())
        {
            for(int i=0;i<senhas.size();i++)
            {
                if(senhas.get(i).getServico().equals(servico))
                {
                    return senhas.get(i).getSenha();
                }
            }
        }
        return "NULL";
    }
}
