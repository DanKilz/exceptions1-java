package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;
import modelo.excecoes.DomainException;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int quartoNumero = sc.nextInt();
			System.out.print("Data de check-in (DD/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());
			
			
			Reserva reserva = new Reserva(quartoNumero, checkIn, checkOut);
			System.out.println("Reserva : " + reserva);
			
			System.out.println();
			
			System.out.println("Informe os dados de atualização da reserva:");
			System.out.print("Data de check-in (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.atualizarDatas(checkIn, checkOut);
			System.out.println("Reserva : " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Formato de data inválido!");
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva! " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		
		sc.close();
	}

}
