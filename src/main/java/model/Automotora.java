package model;

import data.GestorDatos;
import utils.GestorPDF;
import utils.ValidadorRut;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Automotora {

    private List<Vehiculo> vehiculosAVenta;
    private List<Vehiculo> vehiculosVendidos;
    private List<Vendedor> vendedores;
    private List<Venta> ventas;
    private List<Cliente> clientes;

    public Automotora() {
        this.vehiculosAVenta = new ArrayList<Vehiculo>();
        this.vehiculosVendidos = new ArrayList<Vehiculo>();
        this.vendedores = new ArrayList<Vendedor>();
        this.ventas = new ArrayList<Venta>();
        this.clientes = new ArrayList<Cliente>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public Venta generarVenta(String rutVendedor, String rutCliente, Vehiculo vehiculo) throws IOException {
        Vendedor vendedor = this.buscarVendedor(rutVendedor);
        Persona comprador = this.buscarCliente(rutCliente);
        Venta venta = new Venta(vehiculo, comprador, vendedor);
        this.ventas.add(venta);
        GestorPDF gestorPDF= new GestorPDF();
        gestorPDF.generarBoleta(venta);
        return venta;
    }

    public Vendedor buscarVendedor(String rut) {
        Vendedor vendedor = null;
        for (Vendedor vendedorAux : this.vendedores) {
            if (vendedorAux.getRun().equals(rut)) {
                vendedor = vendedorAux;
                break;
            }
        }
        return vendedor;
    }

    public Persona buscarCliente(String rut) {
        Persona cliente = null;
        for (Cliente clienteAux : this.clientes) {
            if (clienteAux.getRun().equals(rut)) {
                cliente = clienteAux;
                break;
            }
        }
        if(cliente==null){
            for (Vendedor vendedorAux : this.vendedores) {
                if (vendedorAux.getRun().equals(rut)) {
                    cliente = vendedorAux;
                    break;
                }
            }
        }
        return cliente;
    }

    public boolean añadirVendedor(String nombre, int edad, String rut) {
        if (ValidadorRut.validarDigito(rut) && this.buscarVendedor(rut)==null) {
            Vendedor vendedor = new Vendedor(nombre, rut, edad);
            this.vendedores.add(vendedor);
            //GestorDatos.registrarDato(vendedor,"vendedores.txt");
            return true;
        } else {
            return false;
        }
    }
    public boolean añadirCliente(String nombre, String direccion, String numeroTelefonico, String correo, String rut) {
        if (ValidadorRut.validarDigito(rut) && this.buscarCliente(rut)==null) {
            Cliente cliente= new Cliente(nombre,direccion,numeroTelefonico,correo,rut);
            this.clientes.add(cliente);
            return true;
        } else {
            return false;
        }
    }

    public List<Vehiculo> getVehiculosAVenta() {
        return vehiculosAVenta;
    }

    public List<Vehiculo> getVehiculosVendidos() {
        return vehiculosVendidos;
    }


    public void modificarPrecioVehiculo(String nombre, int año, int precio) {
        for (Vehiculo auto : this.vehiculosAVenta) {
            if (auto.getNombre().equals(nombre) && auto.getAño() == año) {
                auto.setPrecio(precio);
                break;
            }
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculosAVenta.remove(vehiculo);
    }

    public boolean removerVehiculo(String nombre, int año) {
        for (Vehiculo auto : this.vehiculosAVenta) {
            if (auto.getNombre().equals(nombre) && auto.getAño() == año) {
                this.vehiculosAVenta.remove(auto);
                return true;
            }

        }
        return false;
    }

    public Vehiculo añadirVehiculo(String nombre, ColorVehiculo color, MarcaVehiculo marca,
                                   int año, int precio, double kmRecorridos){
        Vehiculo vehiculo= new Vehiculo(nombre,color,marca,año,precio,kmRecorridos);
        this.vehiculosAVenta.add(vehiculo);
       // GestorDatos.registrarDato(vehiculo,"vehiculos.txt");
        return vehiculo;
    }
    public void añadirVehiculosPorVender() {
        this.vehiculosAVenta.add(new Vehiculo("Celerio", ColorVehiculo.GRIS, MarcaVehiculo.SUSUKI,
                2018, 5000000, 40000.4));
        this.vehiculosAVenta.add(new Vehiculo("Hilux", ColorVehiculo.BLANCO, MarcaVehiculo.TOYOTA,
                2020, 12000000, 1000));
    }

    public void venderAuto(String nombre, int año) {
        for (Vehiculo auto : this.vehiculosAVenta) {
            if (auto.getNombre().equals(nombre) && auto.getAño() == año) {
                this.vehiculosVendidos.add(auto);
                this.vehiculosAVenta.remove(auto);
                break;
            }
        }
    }

    public List<Vehiculo> buscarAutoNombreForBasico(String nombre) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        for (int i = 0; i < this.vehiculosAVenta.size(); i++) {
            if (this.vehiculosAVenta.get(i).getNombre().equals(nombre)) {
                vehiculos.add(this.vehiculosAVenta.get(i));
            }
        }
        return vehiculos;
    }

    public List<Vehiculo> buscarAutoNombre(String nombre) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        for (Vehiculo auto : this.vehiculosAVenta) {
            if (auto.getNombre().equals(nombre)) {
                vehiculos.add(auto);
            }
        }
        return vehiculos;
    }

    public List<Vehiculo> buscarAutoMarca(MarcaVehiculo marca) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        for (Vehiculo auto : this.vehiculosAVenta) {
            if (auto.getMarca().equals(marca)) {
                vehiculos.add(auto);
            }
        }
        return vehiculos;
    }

    public void mostrarAutosLista(List<Vehiculo> vehiculos) {
        for (Vehiculo auto : vehiculos) {
            String datos = "nombre: " + auto.getNombre() + ", marca: " + auto.getMarca() + ", año: " + auto.getAño()
                    + ", color= " + auto.getColor() + ", precio: " + auto.getPrecio() + ", kmRecorridos: " + auto.getKmRecorridos();
            System.out.println(datos);
        }
    }


}


