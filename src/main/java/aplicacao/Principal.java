package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entidades.Reserva;
import model.excecoes.DominioException;

public class Principal {

    public static void main(String[] args) {

        Scanner escaner = new Scanner(System.in);
        SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Entradas do usuário.
            System.out.print("Número do quarto: ");
            int numeroQuarto = escaner.nextInt();
            System.out.print("Data de entrada (dd/mm/aaaa): ");
            Date entrada = formatarData.parse(escaner.next());
            System.out.print("Data de saída (dd/mm/aaaa): ");
            Date saida = formatarData.parse(escaner.next());

            Reserva reserva = new Reserva(numeroQuarto, entrada, saida);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Informe os dados de atualização da reserva:");
            System.out.print("Data de entrada (dd/mm/aaaa): ");
            entrada = formatarData.parse(escaner.next());
            System.out.print("Data de saída (dd/mm/aaaa): ");
            saida = formatarData.parse(escaner.next());

            reserva.atualizarDatas(entrada, saida);
            System.out.println("Reserva: " + reserva);
        }
        catch (ParseException e) {
            System.err.println("Formato de data inválido.");
        }
        catch (DominioException e) {
            System.err.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.err.println("Erro inesperado.");
        }
        
        escaner.close();
    }
}
