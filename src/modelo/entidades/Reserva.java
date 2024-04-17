package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelo.excecoes.DomainException;

public class Reserva {

	// Atributos
	private Integer quartoNumero;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	// Construtores
	public Reserva() {	}

	public Reserva(Integer quartoNumero, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Data de check-out deve ser posterior à data de check-in.");
		}
		
		this.quartoNumero = quartoNumero;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	// Getter e setters
	public Integer getQuartoNumero() {
		return quartoNumero;
	}

	public void setQuartoNumero(Integer quartoNumero) {
		this.quartoNumero = quartoNumero;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	// Métodos
	public long duracao() {
		long diferencaDatas = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferencaDatas, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarDatas(Date checkIn, Date checkOut) {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(checkOut)) {
			throw new DomainException("As datas de reserva devem ser datas futuras.");
		}
		
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Data de check-out deve ser posterior à data de check-in.");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ quartoNumero
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " noites.";
	}
}
