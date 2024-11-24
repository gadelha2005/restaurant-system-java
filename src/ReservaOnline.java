import java.util.Date;

public class ReservaOnline extends Reserva {

    private double desconto;
    

   public ReservaOnline(String data , int quantidadePessoas , double desconto){
    super(data, quantidadePessoas);
    this.desconto = desconto;
   }

    public double getDesconto() {
    return desconto;
    }

    @Override
    public double precoReserva() {
        return quantidadePessoas * desconto;
    }

    @Override
    public void confirmarReserva() throws ReservaNaoEncontradaException {
        System.out.println("Reserva online confirmada para " + quantidadePessoas + " pessoas na data " + data);
    }

    @Override
    public String toString() {
        return "ReservaOnline [desconto=" + desconto + ", mesa=" + mesa + "]";
    }

    
}
