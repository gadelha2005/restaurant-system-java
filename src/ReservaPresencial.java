import java.util.Date;

public class ReservaPresencial extends Reserva {
    private double taxaServico;
    
    public ReservaPresencial(String data, int quantidadePessoas, double taxaServico) {
        super(data, quantidadePessoas);
        this.taxaServico = taxaServico;
    }

    @Override
    public double precoReserva() {
        return quantidadePessoas * taxaServico;
    }

    public double getTaxaServico() {
        return taxaServico;
    }

    @Override
    public void confirmarReserva() throws ReservaNaoEncontradaException {
        System.out.println("Reserva presencial confirmada para " + quantidadePessoas + " pessoas na data " + data);
    }

    @Override
    public String toString() {
        return "ReservaPresencial [taxaServico=" + taxaServico + ", mesa=" + mesa + "]";
    }

    
}
