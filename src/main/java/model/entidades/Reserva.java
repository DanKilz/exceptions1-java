package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.excecoes.DominioException;

public class Reserva {
    
    // ATRIBUTOS
    
    private Integer numeroQuarto;
    private Date entrada;
    private Date saida;
    
    // Objeto responsável pela formatação adequada das datas.
    private static SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
    
    // CONSTRUTORES
    
    public Reserva(Integer quartoNumero, Date entrada, Date saida) throws DominioException{
        if (!saida.after(entrada)) {
            throw new DominioException("A data de saída deve ser posterior a data de entrada.");
        }
        
        this.numeroQuarto = quartoNumero;
        this.entrada = entrada;
        this.saida = saida;
    }
    
    // GETTERS E SETTERS

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getEntrada() {
        return entrada;
    }

    public Date getSaida() {
        return saida;
    }
    
    // Os métodos setEntrada e setSaida não foram colocados,
    // pois a atualização dessas datas será feita em um método específico:
    // atualizarDatas.
    
    // MÉTODOS
    
    // Realiza a diferença entre as datas de entrada e saída
    // e retorna o número de dias.
    public long duracao() {
        long diferenca = saida.getTime() - entrada.getTime();
        
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }
    
    // Modifica as datas de entrada e saída.
    public void atualizarDatas(Date entrada, Date saida) throws DominioException {        
        Date agora = new Date();
        
        if (entrada.before(agora) || saida.before(agora)){
            throw new DominioException("As datas de reserva devem ser futuras.");
        }
        
        if (!saida.after(entrada)) {
            throw new DominioException("A data de saída deve ser posterior a data de entrada.");
        }
            
        this.entrada = entrada;
        this.saida = saida;
    }

    @Override
    public String toString() {
        return "Quarto " + numeroQuarto
                + ", entrada: " + formatarData.format(entrada)
                + ", saída: " + formatarData.format(saida)
                + ", " + duracao() + " noites";
    }        
}
