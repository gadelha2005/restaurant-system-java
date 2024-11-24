public abstract class Comida {
    protected String nome;
    protected double preco;
    
    public Comida(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Comida [nome=" + nome + ", preco=" + preco + "]";
    }

    

    
}
