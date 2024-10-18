package model;
import java.time.LocalDate;

public abstract class Servicio {
    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;
    protected LocalDate fecha;
    
    // Constructor
    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion, LocalDate fecha) throws Exception{
         if(codServicio.length() != 6){
            throw new Exception("Codigo incorrecto.");
        } // corta la funcion y no asigna los demas atributos si el codServicio es distinto a 6.
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
        this.fecha = fecha;
    }
    
    // Getters
    public String getCodServicio() {
        return codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }
    
    // Setters
    public void setCodServicio(String codServicio) {
        this.codServicio = codServicio;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }
    
    // Método abstracto
    public abstract double calcularPrecioFinal(LocalDate dia);
    
    public abstract double precioBase(LocalDate dia);
    
    // toString
    @Override
    public String toString() {
        return "Servicio{" + "codServicio=" + codServicio + ", porcentajeDescuento=" + porcentajeDescuento + ", enPromocion=" + enPromocion + '}';
    }
}