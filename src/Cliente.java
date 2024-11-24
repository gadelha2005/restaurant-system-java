import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa implements Notificavel{
    private List<Reserva> reservas;
    private int cadastro;

    public Cliente(String nome, String telefone , int cadastro) {
        super(nome, telefone);
        this.cadastro = cadastro;
        this.reservas = new ArrayList<>();

    }

    public int getCadastro() {
        return cadastro;
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public void notificarCliente() {
        System.out.println("Notificando o cliente " + nome + " pelo telefone " + telefone);
    }

    @Override
    public String toString() {
        return super.toString() + ", Reservas: " + reservas;
    }




  
    
    
}
