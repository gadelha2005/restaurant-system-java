public class PratoPrincipal extends Comida {
    
    public PratoPrincipal(String nome , double preco){
        super(nome , preco);
    }

    @Override
    public String toString() {
        return "Nome = " + nome + ", preço = " + preco;
    }

    

   
}
