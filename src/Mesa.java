public class Mesa implements Reservavel  {
    private int numeroMesa;
    private boolean disponivel;
   
    public Mesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.disponivel = false;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public boolean getDisponivel(){
        return disponivel;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    @Override
    public void reservar(){
        if (disponivel) {
            this.disponivel = false; 
            System.out.println("Mesa " + numeroMesa + " reservada com sucesso.");
        } 
        else{
            System.out.println("Mesa " + numeroMesa + " já está ocupada.");
        }
    }

    @Override
    public String toString() {
        return "Mesa [numeroMesa=" + numeroMesa + ", disponivel=" + disponivel + "]";
    }
    
    
    
}
