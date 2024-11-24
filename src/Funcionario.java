
public class Funcionario extends Pessoa {

    private int id;

    public Funcionario(String nome, String telefone , int id ) {
        super(nome, telefone);
        this.id = id;
    }

     public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Funcionario - " + super.toString() + " ID: " + id;
    }
   
}
