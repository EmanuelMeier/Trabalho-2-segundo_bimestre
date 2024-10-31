package trabalho;

import java.util.Scanner;
import trabalho.objeto.Hotel;
import trabalho.objeto.Quarto;
import trabalho.objeto.Reserva;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        boolean running = true;

        while (running) {
            System.out.println("Sistema de Gerenciamento do Hotel");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Cadastrar Reserva");
            System.out.println("3. Realizar Check-in");
            System.out.println("4. Realizar Check-out");
            System.out.println("5. Gerar Relatório de Ocupação");
            System.out.println("6. Gerar Histórico de Reservas por Hóspede");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de Quarto:");
                    System.out.print("Número do Quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Tipo do Quarto (solteiro/casal/suite): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Preço Diário: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quarto Disponível (true/false): ");
                    boolean disponivel = scanner.nextBoolean();
                    scanner.nextLine(); 

                    Quarto quarto = new Quarto(numero, tipo, preco, disponivel);
                    hotel.cadastrarQuarto(quarto); 
                    break;

                case 2:
                    System.out.println("Cadastro de Reserva:");
                    System.out.print("Nome do Hóspede: ");
                    String nome = scanner.nextLine();
                    System.out.print("Data de Check-in (dd/MM/yyyy): ");
                    String checkIn = scanner.nextLine();
                    System.out.print("Data de Check-out (dd/MM/yyyy): ");
                    String checkOut = scanner.nextLine();
                    System.out.print("Número do Quarto: ");
                    int numeroQuartoReserva = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Tipo de Quarto Reservado: ");
                    String tipoQuarto = scanner.nextLine();

                    Reserva reserva = new Reserva(nome, checkIn, checkOut, numeroQuartoReserva, tipoQuarto);
                    hotel.cadastrarReserva(reserva);  
                    break;

                case 3:
                    System.out.print("Digite o número do quarto para realizar o check-in: ");
                    int numeroCheckIn = scanner.nextInt();
                    scanner.nextLine(); 
                    hotel.registrarCheckIn(numeroCheckIn); 
                    break;

                case 4:
                    System.out.print("Digite o número do quarto para realizar o check-out: ");
                    int numeroCheckOut = scanner.nextInt();
                    scanner.nextLine();  
                    hotel.registrarCheckOut(numeroCheckOut); 
                    break;

                case 5:
                    System.out.println("Relatório de Ocupação dos Quartos:");
                    hotel.gerarRelatorioOcupacao();
                    break;

                case 6:
                    System.out.println("Histórico de todas as reservas:");
                    hotel.gerarHistoricoTodasReservas(); 
                    break;

                case 7:
                    System.out.println("Saindo...");
                    running = false;
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
