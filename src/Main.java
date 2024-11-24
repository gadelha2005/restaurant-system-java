import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();
        
        while (true) {
            System.out.println("Bem-vindo ao sistema de reservas do Kapo!");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Entrar no Sistema");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = sc.nextInt();
            sc.nextLine(); 

            if (escolha == 1) {
                cadastrarFuncionario(sc, restaurante);
            } else if (escolha == 2) {
                if (loginFuncionario(sc, restaurante)) {
                    exibirMenu(restaurante, sc);
                } else {
                    System.out.println("Acesso negado. Tente novamente.");
                }
            } else if (escolha == 0) {
                System.out.println("Saindo do sistema.");
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }

        sc.close();
    }

    private static void cadastrarFuncionario(Scanner sc, Restaurante restaurante) {
        System.out.print("Digite o nome do novo funcionário para cadastro: ");
        String nomeFuncionario = sc.nextLine();
        System.out.print("Digite o telefone do novo funcionário: ");
        String telefone = sc.nextLine();
        System.out.print("Digite o id do novo funcionário: ");
        int id = sc.nextInt();
        Funcionario novoFuncionario = new Funcionario(nomeFuncionario , telefone , id);
        restaurante.adicionarFuncionario(novoFuncionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static boolean loginFuncionario(Scanner sc, Restaurante restaurante) {
        System.out.print("Digite o nome do funcionário para entrar no sistema: ");
        String nomeLogin = sc.nextLine();
        System.out.print("Digite o id do funcionário: ");
        int idLogin = sc.nextInt();
        return restaurante.verificarFuncionario(nomeLogin , idLogin);
    }

    private static void exibirMenu(Restaurante restaurante, Scanner sc) {
        int opcao;
        do {
            System.out.println("\nBem-Vindo ao sistema de reservas do Kapo!");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Adicionar Mesa");
            System.out.println("3. Fazer Reserva Online");
            System.out.println("4. Fazer Reserva Presencial");
            System.out.println("5. Mostrar Cardapio");
            System.out.println("6. Notificar Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    registrarCliente(sc, restaurante);
                    break;
                case 2:
                    adicionarMesa(sc, restaurante);
                    break;
                case 3:
                    fazerReservaOnline(sc, restaurante);
                    break;
                case 4:
                    fazerReservaPresencial(sc, restaurante);
                    break;
                case 5:
                    mostrarCardapio(restaurante);
                    break;
                case 6:
                    notificarCliente(sc, restaurante);
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void registrarCliente(Scanner sc, Restaurante restaurante) {
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("Telefone do cliente: ");
        String telefone = sc.nextLine();
        System.out.print("Digite o cadastro do cliente: ");
        int cadastro = sc.nextInt();

        Cliente cliente = new Cliente(nome, telefone, cadastro);
        restaurante.adicionarCliente(cliente);
        System.out.println("Cliente registrado com sucesso!");
    }

    private static void adicionarMesa(Scanner sc, Restaurante restaurante) {
        System.out.print("Número da mesa: ");
        int numeroMesa = sc.nextInt();

        Mesa mesa = new Mesa(numeroMesa);
        restaurante.adicionarMesa(mesa);
        System.out.println("Mesa adicionada com sucesso!");
    }

    private static void fazerReservaOnline(Scanner sc, Restaurante restaurante) {
        System.out.print("Nome do cliente: ");
        String nomeCliente = sc.nextLine();
        System.out.print("Cadastro do cliente: ");
        int cadastro = sc.nextInt();
        Cliente cliente = restaurante.buscarCliente(nomeCliente , cadastro);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.print("Data da reserva (dd/MM/yyyy): ");
        String data = sc.nextLine();
        System.out.print("Quantidade de pessoas: ");
        int quantidadePessoas = sc.nextInt();
        System.out.print("Desconto : ");
        double desconto = sc.nextDouble();

        ReservaOnline reserva = new ReservaOnline(data, quantidadePessoas, desconto);
        try {
            restaurante.fazerReserva(cliente, reserva);
            System.out.println("Reserva online realizada com sucesso!");
            gravarReservaNoArquivo(cliente, reserva);
        } 
       
        catch (Exception e) {
            System.out.println("Erro ao fazer reserva: " + e.getMessage());
        }
    }

    private static void fazerReservaPresencial(Scanner sc, Restaurante restaurante) {
        System.out.print("Nome do cliente: ");
        String nomeCliente = sc.nextLine();
        System.out.print("Cadastro do cliente: ");
        int cadastro = sc.nextInt();
        Cliente cliente = restaurante.buscarCliente(nomeCliente , cadastro);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.print("Data da reserva (dd/MM/yyyy): ");
        String data = sc.nextLine();
        System.out.print("Quantidade de pessoas: ");
        int quantidadePessoas = sc.nextInt();
        System.out.print("Taxa de serviço : ");
        double taxaServico = sc.nextDouble();

        ReservaPresencial reserva = new ReservaPresencial(data, quantidadePessoas, taxaServico);
        
        try {
            restaurante.fazerReserva(cliente, reserva);
            System.out.println("Reserva presencial realizada com sucesso!");
            gravarReservaNoArquivo(cliente, reserva);
        } 
        
        catch (Exception e) {
            System.out.println("Erro ao fazer reserva: " + e.getMessage());
        }
    }

    private static void mostrarCardapio(Restaurante restaurante) {
        restaurante.exibirCardapio();
    }


    private static void notificarCliente(Scanner sc, Restaurante restaurante) {
        System.out.print("Nome do cliente: ");
        String nomeCliente = sc.nextLine();
        System.out.print("Cadastro do cliente: ");
        int cadastro = sc.nextInt();
        Cliente cliente = restaurante.buscarCliente(nomeCliente , cadastro);
        if (cliente != null) {
            cliente.notificarCliente();
        } 
        
        else {
            System.out.println("Cliente não encontrado!");
        }
    }

    
    private static void gravarReservaNoArquivo(Cliente cliente, Reserva reserva) {
        try {
            File arquivo = new File("reservas.txt");
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
                writer.write("Cliente: " + cliente.getNome());
                writer.newLine();
                writer.write("Cadastro: " + cliente.getCadastro());
                writer.newLine();
                writer.write("Data da Reserva: " + reserva.getData());
                writer.newLine();
                writer.write("Quantidade de Pessoas: " + reserva.getQuantidadePessoas());
                writer.newLine();
                
                
                if (reserva instanceof ReservaOnline) {
                    writer.write("Desconto: " + ((ReservaOnline) reserva).getDesconto());
                } 
                
                else if (reserva instanceof ReservaPresencial) {
                    writer.write("Taxa de serviço: " + ((ReservaPresencial) reserva).getTaxaServico());
                }
                writer.newLine();
    
               
                if (reserva.getMesa() != null) {
                    writer.write("Mesa: " + reserva.getMesa().getNumeroMesa());
                } 
                
                else {
                    writer.write("Mesa: Não associada");
                }
                writer.newLine();
    
                writer.write("=================================");
                writer.newLine();
            }
        } 
        
        catch (IOException e) {
            System.out.println("Erro ao gravar a reserva no arquivo: " + e.getMessage());
        }
    }
}
