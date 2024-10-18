package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Servicio> lstServicio;
    
    // Constructor
    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }
    
    // Métodos
    public Servicio traerServicio(String codServicio) {
        for (Servicio s : lstServicio) {
            if(s.getCodServicio().equals(codServicio)) {
                return s;
            }
        }
        return null;
    }
    
    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> lstServiciosPromo = new ArrayList<>();

        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion) {
                lstServiciosPromo.add(s);
                //System.out.println("Se agregó el servicio a la lista."); // depuración
            }
        }
        return lstServiciosPromo;
    }
    
public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
    List<Servicio> lstServiciosPromo = new ArrayList<>();

    for (Servicio s : lstServicio) { // recorro la lista
        if (s.isEnPromocion() == enPromocion) {   
            double precio = s.precioBase(dia);
            if (s.calcularPrecioFinal(dia) != precio) { 
                lstServiciosPromo.add(s);
            }
        }
    }
    return lstServiciosPromo; // retorno el resultado de la comparacion, sea cual sea.
}
    
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc, LocalDate fecha) throws Exception {
        boolean retorno = false;
        if (traerServicio(codServicio) == null) {
            Gastronomia g = new Gastronomia(codServicio, diaSemDesc, porcentajeDescuento, gastronomia, precio, enPromocion, fecha);
            retorno = true;
            lstServicio.add(g); // añado a la lista si la comprobacion fue exitosa, es decir, si no habia nada en la lista igual
            // System.out.println("Gastronomía agregada.");  // depuración
        } else {
            throw new Exception("El servicio gastronomico ya existe");
        }
        return retorno;
    }
    
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche, LocalDate fecha) throws Exception {
    boolean retorno = false;
    if (traerServicio(codServicio) == null) {
        Hospedaje h = new Hospedaje(codServicio, hospedaje, porcentajeDescuento, precioPorNoche, enPromocion, fecha);
        retorno = true;
        lstServicio.add(h);
        // System.out.println("Hospedaje agregado." );  // depuración
    } else {
        throw new Exception("El servicio de hospedaje ya existe");
    }
    return retorno;
    }
    
    // toString
    @Override
    public String toString() {
        return "Sistema{" + "lstServicio=" + lstServicio + '}';
    }
}