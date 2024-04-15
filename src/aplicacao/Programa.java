package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int quartoNumero = sc.nextInt();
		System.out.print("Data de check-in (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de check-out (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva! Data de check-out deve ser posterior à data de check-in.");
		} else {
			Reserva reserva = new Reserva(quartoNumero, checkIn, checkOut);
			System.out.println("Reserva : " + reserva);
			
			System.out.println();
			
			System.out.println("Informe os dados de atualização da reserva:");
			System.out.print("Data de check-in (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(checkOut)) {
				System.out.println("Erro na reserva! As datas de reserva devem ser datas futuras.");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva! Data de check-out deve ser posterior à data de check-in.");
			} else {
				reserva.atualizarDatas(checkIn, checkOut);
				System.out.println("Reserva : " + reserva);
			}
		}
		
		sc.close();
	}

}
