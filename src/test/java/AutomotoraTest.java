import controller.AutomotoraController;
import data.GestorDatos;
import model.Automotora;
import model.ColorVehiculo;
import model.MarcaVehiculo;
import model.Vehiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class AutomotoraTest {
    private String[] rut;
    private Automotora automotora;
    @BeforeEach
    public void inicializarValidarRut() {
        rut = new String[]{"12.345.6785", "20.104.038-8", "11111.111-1","18.456.985-K","18.456.985-k","0-0"};
        automotora= new Automotora();
    //   automotora.añadirVendedor("nombreVendedor", 25,"18.456.985-K");
    //   automotora.añadirCliente("nombreCliente", "direccionCliente","+56912345678", "cliente@cliente.cl", "20.104.038-8");
      //  automotora.añadirVehiculosPorVender();

    }
    @Test
    public void validarRutTest() {
        boolean condicion = true;
        for (int i = 0; i < rut.length; i++) {
            if(!automotora.añadirVendedor(null,30,rut[i])){
                condicion=false;
            }
        }
        assertTrue(condicion);
    }
    @Test
    public void validarPDF() throws IOException {
        Vehiculo vehiculo= automotora.buscarAutoNombre("Celerio").get(0);
        automotora.generarVenta("18.456.985-K","20.104.038-8",vehiculo);
    }
    @Test
    public void validarIngresoDatos() throws IOException {
        automotora=GestorDatos.leerArchivoClientes(automotora,"clientes.txt");
        automotora=GestorDatos.leerArchivoVehiculos(automotora,"vehiculos.txt");
        automotora=GestorDatos.leerArchivoVendedores(automotora,"vendedores.txt");
        System.out.println(automotora.buscarCliente("20.104.038-8").toString());
        System.out.println(automotora.getClientes().size());
        System.out.println(automotora.getVehiculosAVenta().size());
        Vehiculo vehiculo= automotora.buscarAutoNombre("Celerio").get(0);
        automotora.añadirVendedor("nombreVendedor", 25,"18.456.985-K");
        automotora.añadirCliente("nombreCliente", "direccionCliente","+56912345678", "cliente@cliente.cl", "20.104.038-8");
        automotora.añadirCliente("nombreCliente", "direccionCliente","+56912345678", "cliente@cliente.cl", "18.456.985-K");
        automotora.añadirVehiculo("Celerio", ColorVehiculo.GRIS, MarcaVehiculo.SUSUKI,
                2031, 5000000, 40000.4);

        automotora.generarVenta("18.456.985-K","20.104.038-8",vehiculo);
        AutomotoraController.almacenarDatos(automotora);

    }


}