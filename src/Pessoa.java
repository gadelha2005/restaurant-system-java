public abstract class Pessoa {
    
    protected String nome;
    protected String telefone;
   
    public Pessoa(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", telefone=" + telefone + "]";
    }

    

    

    
}
