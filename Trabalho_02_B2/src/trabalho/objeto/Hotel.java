package trabalho.objeto;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void cadastrarQuarto(Quarto quarto) {
        if (quartoExiste(quarto.getNumero())) {
            System.out.println("Erro: O quarto com o número " + quarto.getNumero() + " já está cadastrado.");
            return; 
        }
        quartos.add(quarto);
        System.out.println("Quarto cadastrado com sucesso!");
    }

    public void cadastrarReserva(Reserva reserva) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAtual = LocalDate.now();

        try {
            LocalDate dataEntrada = LocalDate.parse(reserva.getDataEntrada(), formatter);
            LocalDate dataSaida = LocalDate.parse(reserva.getDataSaida(), formatter);

            if (dataEntrada.isBefore(dataAtual)) {
                System.out.println("Erro: A data de check-in não pode ser anterior à data atual.");
                return;
            }

            if (dataSaida.isBefore(dataEntrada.plusDays(1))) {
                System.out.println("Erro: A data de check-out deve ser pelo menos um dia após a data de check-in.");
                return;
            }

            boolean quartoEncontrado = false;
            for (Quarto quarto : quartos) {
                if (quarto.getTipo().equalsIgnoreCase(reserva.getTipoQuartoRes()) && quarto.isDisponivel()) {
                    boolean podeReservar = true;
                    for (Reserva r : reservas) {
                        if (r.getTipoQuartoRes().equalsIgnoreCase(reserva.getTipoQuartoRes())) {
                            LocalDate dataReservaEntrada = LocalDate.parse(r.getDataEntrada(), formatter);
                            LocalDate dataReservaSaida = LocalDate.parse(r.getDataSaida(), formatter);
                            if (!dataEntrada.isAfter(dataReservaSaida)) {
                                podeReservar = false;
                                break;
                            }
                        }
                    }

                    if (podeReservar) {
                        quartoEncontrado = true;
                        reservas.add(reserva); 
                        quarto.setReservado(true); 
                        System.out.println("Reserva cadastrada com sucesso para o quarto tipo: " + reserva.getTipoQuartoRes());
                        break;
                    }
                }
            }

            if (!quartoEncontrado) {
                System.out.println("Não há quartos disponíveis do tipo " + reserva.getTipoQuartoRes() + ".");
            }

        } catch (DateTimeParseException e) {
            System.out.println("Erro: A data de check-in e check-out devem estar no formato dd/MM/yyyy.");
        }
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public boolean isReservaFeita(int numeroQuarto) {
        for (Reserva reserva : reservas) {
            if (reserva.getNumQuartosRes() == numeroQuarto) {
                return true;
            }
        }
        return false;
    }

    public boolean quartoExiste(int numeroQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto) {
                return true;
            }
        }
        return false;
    }

    public void registrarCheckIn(int numeroQuarto) {
        if (!quartoExiste(numeroQuarto)) {
            System.out.println("Quarto não está cadastrado no sistema.");
            return;
        }

        if (isReservaFeita(numeroQuarto)) {
            for (Quarto quarto : quartos) {
                if (quarto.getNumero() == numeroQuarto && quarto.isReservado()) {
                    quarto.setReservado(false); 
                    quarto.setDisponivel(false); 
                    System.out.println("Check-in realizado para o quarto " + numeroQuarto);
                    return;
                }
            }
            System.out.println("O quarto não está reservado.");
        } else {
            System.out.println("Não existe uma reserva para este quarto. Faça a reserva primeiro.");
        }
    }

    private LocalDate getDataCheckInPorQuarto(int numeroQuarto) {
        for (Reserva reserva : reservas) {
            if (reserva.getNumQuartosRes() == numeroQuarto) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return LocalDate.parse(reserva.getDataEntrada(), formatter);
            }
        }
        return null;
    }

    public void registrarCheckOut(int numeroQuarto) {
        if (!quartoExiste(numeroQuarto)) {
            System.out.println("Quarto não está cadastrado no sistema.");
            return;
        }

        Reserva reservaDoQuarto = null;

        for (Reserva reserva : reservas) {
            if (reserva.getNumQuartosRes() == numeroQuarto) {
                reservaDoQuarto = reserva;
                break;
            }
        }

        if (reservaDoQuarto == null) {
            System.out.println("Não há reservas para o quarto " + numeroQuarto + ".");
            return;
        }

        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto) {
                quarto.setDisponivel(true);
                System.out.println("Check-out realizado para o quarto " + numeroQuarto);
                reservas.remove(reservaDoQuarto); 
                return;
            }
        }
        System.out.println("O quarto já está disponível.");
    }

    public void gerarRelatorioOcupacao() {

        boolean temQuartosOcupados = false;

        for (Quarto quarto : quartos) {
            if (!quarto.isDisponivel()) { 
                if (!temQuartosOcupados) {
                    temQuartosOcupados = true; 
                }
                System.out.println("Número do Quarto: " + quarto.getNumero());
                System.out.println("Tipo do Quarto: " + quarto.getTipo());
                System.out.println("Status: Ocupado");
                System.out.println("-----------------------------");
            }
        }

        if (!temQuartosOcupados) {
            System.out.println("Nenhum quarto está ocupado.");
        }
    }

    public void gerarHistoricoTodasReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Não há reservas registradas.");
        } else {
            int totalReservas = 0;
            for (Reserva reserva : reservas) {
                System.out.println("Hóspede: " + reserva.getNome());
                System.out.println("Número do Quarto: " + reserva.getNumQuartosRes());
                System.out.println("Data de Check-in: " + reserva.getDataEntrada());
                System.out.println("Data de Check-out: " + reserva.getDataSaida());
                System.out.println("Tipo de Quarto Reservado: " + reserva.getTipoQuartoRes());
                System.out.println("-----------------------------");
                totalReservas++;
            }
            System.out.println("Total de reservas feitas: " + totalReservas);
        }
    }
}
