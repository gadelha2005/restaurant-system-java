
public abstract class Reserva implements Pagavel{
    protected String data;
    protected int quantidadePessoas;
    protected Mesa mesa;
    
    public Reserva(String data, int quantidadePessoas) {
        this.data = data;
        this.quantidadePessoas = quantidadePessoas;
        
    }

    public String getData() {
        return data;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void associarMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Mesa getMesa() {
        return mesa;
    }

   
    
    @Override
    public String toString() {
        return "Reserva [data=" + data + ", quantidadePessoas=" + quantidadePessoas + ", mesa=" + mesa + "]";
    }

    public abstract void confirmarReserva() throws ReservaNaoEncontradaException;

    

    
    
}
