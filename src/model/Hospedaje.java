package model;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Hospedaje extends Servicio {
    private String Hospedaje;
    private double precioPorNoche;
    
     // Constructor
    public Hospedaje(String codServicio, String Hospedaje, double porcentajeDescuento, double precioPorNoche, boolean enPromocion, LocalDate fecha) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion, fecha);
        this.Hospedaje = Hospedaje;
        this.precioPorNoche = precioPorNoche;
        this.fecha = fecha;
    }
    
    // Método
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precio = this.precioPorNoche;
        DayOfWeek semana = dia.getDayOfWeek(); // obtengo el dia de la semana
        if (isEnPromocion() && (semana != DayOfWeek.SATURDAY && semana != DayOfWeek.SUNDAY)) { // comparo y extraigo los dias que me interesan
            precio = precio - ((precio * porcentajeDescuento) /  100) ;
        }
        return precio;
    }
    
     @Override
    public double precioBase(LocalDate dia) {
        return this.precioPorNoche;
    }
    
    // Getters
    public String getHospedaje() {
        return Hospedaje;
    }
    
    // toString
    @Override
    public String toString() {
        return "codServicio=" + codServicio + "Hospedaje=" + Hospedaje + ", precioPorNoche=" + precioPorNoche;
    }
}