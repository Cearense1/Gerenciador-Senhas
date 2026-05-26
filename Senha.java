public class Senha 
{
    private String servico;
    private String usuario;
    private String senha;

    public Senha(String servico, String usuario, String senha)
    {
        this.servico=servico;
        this.usuario=usuario;
        this.senha=senha;
    }

    public String getSenha()
    {
        return senha;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public String getServico()
    {
        return servico;
    }
}
