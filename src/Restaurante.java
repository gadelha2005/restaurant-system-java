import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Restaurante {
    private Set<Cliente> clientes; 
    private Map<Integer, Mesa> mesas;
    private Map<Pessoa , Mesa> reservas;
    private List<PratoPrincipal> pratosPrincipais;
    private List<Sobremesa> sobremesas;
    private List<Bebida> bebidas;
    private List<Funcionario> funcionarios;

    public Restaurante() {
        this.clientes = new HashSet<>();
        this.mesas = new HashMap<>();
        this.reservas = new HashMap<>();
        this.pratosPrincipais = new ArrayList<>();
        this.sobremesas = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.funcionarios = new ArrayList<>();


       
        pratosPrincipais.add(new PratoPrincipal("Carne", 45.0));
        pratosPrincipais.add(new PratoPrincipal("Frango", 30.0));

        sobremesas.add(new Sobremesa("Sorvete", 15.0));
        sobremesas.add(new Sobremesa("Brownie", 18.0));

        bebidas.add(new Bebida("Suco", 8.0));
        bebidas.add(new Bebida("Refrigerante", 5.0));
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public void adicionarMesa(Mesa mesa) {
        if (mesas.containsKey(mesa.getNumeroMesa())) {
            System.out.println("Mesa já cadastrada!");
        } 
        
        else {
            mesas.put(mesa.getNumeroMesa(), mesa);
            System.out.println("Mesa número " + mesa.getNumeroMesa() + " adicionada com sucesso!");
        }
    }

    public void fazerReserva(Cliente cliente, Reserva reserva) throws Exception {

        if (cliente.getReservas().size() > 0) {  
            throw new Exception("Não é possivel um cliente fazer mais de uma reserva.");
        }

        Mesa mesaDisponivel = null;
        for (Mesa mesa : mesas.values()) {
            if (!mesa.getDisponivel()) {
                mesaDisponivel = mesa;
                break;
            }
        }

        if (mesaDisponivel == null) {
            throw new Exception("Não há mesas desocupadas disponíveis para realizar a reserva.");
        }

        
        cliente.adicionarReserva(reserva);
        reserva.associarMesa(mesaDisponivel);
        reserva.confirmarReserva(); 
        mesaDisponivel.setDisponivel(true);  
        System.out.println("Reserva realizada para a mesa número: " + mesaDisponivel.getNumeroMesa());
    }

    public void cancelarReserva(Cliente cliente) throws Exception {
        Mesa mesa = reservas.remove(cliente);
        if (mesa == null) {
            throw new Exception("Nenhuma reserva encontrada para esse cliente.");
        }
        mesa.setDisponivel(true);
        System.out.println("Reserva para a mesa número " + mesa.getNumeroMesa() + " foi cancelada.");
    }


    
    public void exibirCardapio() {
        System.out.println("---- Cardápio Kapo ----");

        System.out.println("\nPratos Principais: ");
        for (PratoPrincipal prato : pratosPrincipais) {
            System.out.println(prato);
        }

        System.out.println("\nSobremesas: ");
        for (Sobremesa sobremesa : sobremesas) {
            System.out.println(sobremesa);
        }

        System.out.println("\nBebidas: ");
        for (Bebida bebida : bebidas) {
            System.out.println(bebida);
        }

        System.out.println("------------------");
    }
    

    public Mesa buscarMesaDisponivel() {
        for (Mesa mesa : mesas.values()) {
            if (mesa.getDisponivel()) {
                return mesa;  
            }
        }
        return null;  
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public boolean verificarFuncionario(String nome , int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome) && funcionario.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
