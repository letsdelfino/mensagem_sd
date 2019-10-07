package br.com.leticia.banco;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
       ContaDAO conta = new ContaDAOImplementacao();
       
       String nome1 = conta.consultar("Diego");
       String nome2 = conta.consultar("Guedes");
       
       System.out.println(nome1);
       System.out.println(nome2);
    }
}
