package test;
import java.time.LocalDate;
import model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("1-1");
        try {
            Gastronomia gastronomia = new Gastronomia("4892", 4, 180.0, "'Hamburguesa criolla", 15.0, true, LocalDate.of(2020,7,10));
            System.out.println(gastronomia.toString());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        ///////////////////////////////////////////////////////////////////
        
        System.out.println("\n1-2");
         try {
            Gastronomia gastronomia = new Gastronomia("489235", 4, 180.0, "'Hamburguesa criolla", 15.0, true, LocalDate.of(2020, 2, 3));
            System.out.println(gastronomia.toString());            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
         
         ///////////////////////////////////////////////////////////////////
         
         System.out.println("\n1-3");
         try {
            Hospedaje hospedaje = new Hospedaje("2872","Cabaña 3 personas", 1500.0, 10.0, true, LocalDate.of(2020, 7, 8));
             System.out.println(hospedaje.toString());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
         
         ///////////////////////////////////////////////////////////////////
         
        System.out.println("\n1-4");
         try {
            Hospedaje hospedaje = new Hospedaje("287282","Cabaña 3 personas", 1500.0, 10.0, true, LocalDate.of(2020, 11, 9));
             System.out.println(hospedaje.toString());            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
         
         ///////////////////////////////////////////////////////////////////
         
        System.out.println("\n2-1");
            try {
                Gastronomia gastronomia = new Gastronomia("489235", 4, 15.0, "'Hamburguesa criolla", 180.0, true, LocalDate.of(2020, 10, 27));
                double precio = gastronomia.calcularPrecioFinal(LocalDate.of(2020,10,28));
                System.out.println(precio);
            } catch (Exception e) {
                System.out.println(e.getMessage());
          }        
         
         ///////////////////////////////////////////////////////////////////
         
         System.out.println("\n2-2");
         try {
            Hospedaje hospedaje = new Hospedaje("287282","Cabaña 3 personas", 10.0, 1500.0, true, LocalDate.of(2020, 10, 27));
            double precio = hospedaje.calcularPrecioFinal(LocalDate.of(2020,10,28));
             System.out.println(precio);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
         
         ///////////////////////////////////////////////////////////////////
         
         System.out.println("\n3");
         Sistema sistema = new Sistema();
         try {
            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3,LocalDate.of(2020, 10, 21));
            sistema.agregarHospedaje("489259",10.0, true, "Habitacion triple", 2200.0,LocalDate.of(2020, 10, 28));
            sistema.agregarGastronomia("182835", 20.0, true, "Gaseosa", 120.0, 3,LocalDate.of(2020, 10, 21));
            sistema.agregarHospedaje("758972", 15.0, true, "Habitacion simple", 1000.0,LocalDate.of(2020, 10, 21));
            System.out.println(sistema.toString());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
         
         ///////////////////////////////////////////////////////////////////
         
         System.out.println("\n4-1");
         try {
            sistema.traerServicio(true);
             System.out.println(sistema.toString());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
         
          ///////////////////////////////////////////////////////////////////
         
         System.out.println("\n4-2");
         try {
            sistema.traerServicio(true, LocalDate.of(2020, 10, 28));
             System.out.println(sistema.toString());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }         
    }
}
