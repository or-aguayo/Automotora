package controller;

import data.GestorDatos;
import model.Automotora;
import model.ColorVehiculo;
import model.MarcaVehiculo;
import model.Vehiculo;

import java.util.List;

public class AutomotoraController {

    public static Automotora cargaMasivaDatos(Automotora automotora){
        GestorDatos.leerArchivoVendedores(automotora, "vendedores.txt");
        GestorDatos.leerArchivoClientes(automotora, "clientes.txt");
        GestorDatos.leerArchivoVehiculos(automotora, "vehiculos.txt");
        return automotora;
    }
    public static List buscarVehiculo(Automotora automotora, String nombre){
        return automotora.buscarAutoNombre(nombre);
    }
    public static Vehiculo agregarVehiculo(Automotora automotora, String nombre, ColorVehiculo color, MarcaVehiculo marca,
                                    int año, int precio, double kmRecorridos){
        return automotora.añadirVehiculo(nombre,color,marca,año,precio,kmRecorridos);
    }
    public static boolean removerVehiculo(Automotora automotora, String nombre, int año){
        return automotora.removerVehiculo(nombre,año);
    }
    public static void almacenarDatos(Automotora automotora){
        GestorDatos.registrarDatos(automotora.getClientes(),"clientes.txt");
        GestorDatos.registrarDatos(automotora.getVendedores(),"vendedores.txt");
        GestorDatos.registrarDatos(automotora.getVehiculosAVenta(),"vehiculos.txt");
    }
}
