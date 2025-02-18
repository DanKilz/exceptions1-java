package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entidades.Reserva;

public class Principal {

    public static void main(String[] args) throws ParseException {
        
        Scanner escaner = new Scanner(System.in);
        SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
        
        // Entradas do usuário.
        System.out.print("Número do quarto: ");
        int numeroQuarto = escaner.nextInt();
        System.out.print("Data de entrada (dd/mm/aaaa): ");
        Date entrada = formatarData.parse(escaner.next());
        System.out.print("Data de saída (dd/mm/aaaa): ");
        Date saida = formatarData.parse(escaner.next());
        
        if (!saida.after(entrada))
            System.err.println("Erro na reserva: a data de saída deve ser posterior a data de entrada.");
        else {
            Reserva reserva = new Reserva(numeroQuarto, entrada, saida);
            System.out.println("Reserva: " + reserva);
            
            System.out.println();
            System.out.println("Informe os dados de atualização da reserva:");
            System.out.print("Data de entrada (dd/mm/aaaa): ");
            entrada = formatarData.parse(escaner.next());
            System.out.print("Data de saída (dd/mm/aaaa): ");
            saida = formatarData.parse(escaner.next());
            
            Date agora = new Date();
            if (entrada.before(agora) || saida.before(agora))
                System.err.println("Erro na reserva: a data de saída deve ser posterior a data de entrada.");
            else if (!saida.after(entrada))
                System.err.println("Erro na reserva: a data de saída deve ser posterior a data de entrada.");
            else {
                reserva.atualizarDatas(entrada, saida);
                System.out.println("Reserva: " + reserva);
            }
        }
        
        escaner.close();
    }
}
