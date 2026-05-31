import org.mindrot.jbcrypt.BCrypt;

public class Criptografia 
{
    private static final String PEPPER=System.getenv("PEPPER");

    public static String geraHash(String senha)
    {
        return BCrypt.hashpw(senha+PEPPER,BCrypt.gensalt());
    }

    public static boolean checaHash(String senha, String hash)
    {
        return BCrypt.checkpw(senha+PEPPER,hash);
    }
}
