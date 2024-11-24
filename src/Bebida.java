public class Bebida extends Comida {
    public Bebida(String nome , double preco){
        super(nome, preco);
    }

    @Override
    public String toString() {
        return "Nome = " + nome + ", preço = " + preco;
    }
}
