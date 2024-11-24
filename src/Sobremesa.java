public class Sobremesa extends Comida {
    public Sobremesa(String nome , double preco){
        super(nome, preco);
    }

    public String toString(){
        return "Nome = " + nome + ", preço = " + preco;
    }
}
