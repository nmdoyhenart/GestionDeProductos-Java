package model;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Gastronomia extends Servicio{
    private String gastronomia;
    private double precio;
    private int diaSemDesc;
     
     // Constructor
    public Gastronomia(String codServicio, int diaSemDesc, double porcentajeDescuento, String gastronomia, double precio, boolean enPromocion, LocalDate fecha) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion, fecha);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
        this.fecha = fecha;
    }
    
    // Método
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = this.precio;
        DayOfWeek diaDeLaSemana = dia.getDayOfWeek();
        if (isEnPromocion() && diaDeLaSemana.getValue() == this.diaSemDesc) { // Convierto DayOfWeek a valor numerico con el getValue(), anteriormente era un String
            precioFinal = precioFinal - ((precio * porcentajeDescuento) / 100);
        }

        return precioFinal;
    }
    
    @Override
    public double precioBase(LocalDate dia) {
        return precio;
    }
    
     // Getters
    public String getGastronomia() {
        return gastronomia;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }
   
    // toString
    @Override
    public String toString() {
        return "codServicio=" + codServicio + "gastronomia=" + gastronomia + ", precio=" + precio + ", diaSemDesc=" + diaSemDesc;
    }
}