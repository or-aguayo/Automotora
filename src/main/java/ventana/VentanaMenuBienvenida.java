package ventana;

import controller.AutomotoraController;
import model.Automotora;
import ventana.*;

import javax.swing.*;
import java.awt.event.*;

public class VentanaMenuBienvenida extends Ventana {

    private JLabel textoMenu;
    private JButton botonRegistrarCliente;
    private JButton botonSalida;
    private JButton botonRegistrarVehiculo;
    private JButton botonBuscarVehiculo;
    private JButton botonVenderVehiculo;
    private Automotora automotora;

    public VentanaMenuBienvenida(Automotora automotora) {
        super("Menu ventas", 500, 520);
        this.automotora=automotora;
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonRegistrarCliente();
        generarBotonRegistrarVehiculo();
        generarBotonBuscarVehiculo();
       // generarBotonVenderVehiculo();
        generarBotonSalir();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "Sistema de Venta de Vehiculos";
        super.generarJLabelEncabezado(this.textoMenu, textoBienvenida, 20, 30, 500, 30);
    }

    private void generarBotonRegistrarCliente() {
        String textoBoton = "Registrar Cliente";
        this.botonRegistrarCliente = super.generarBoton(textoBoton, 175, 100, 150, 40);
        this.add(this.botonRegistrarCliente);
        this.botonRegistrarCliente.addActionListener(this);
    }
    private void generarBotonSalir() {
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton, 175, 420, 150, 40);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }
    private void generarBotonRegistrarVehiculo() {
        String textoBoton = "Registrar vehiculo";
        this.botonRegistrarVehiculo = super.generarBoton(textoBoton, 175, 180, 150, 40);
        this.add(this.botonRegistrarVehiculo);
        this.botonRegistrarVehiculo.addActionListener(this);
    }
    private void generarBotonBuscarVehiculo(){
        String textoBoton = "Buscar Vehiculo";
        this.botonBuscarVehiculo=super.generarBoton(textoBoton, 175, 260, 150, 40);
        this.add(this.botonBuscarVehiculo);
        this.botonBuscarVehiculo.addActionListener(this);
    }
    private void generarBotonVenderVehiculo(){
        String textoBoton = "Vender Vehiculo";
        this.botonVenderVehiculo=super.generarBoton(textoBoton, 175, 340, 150, 40);
        this.add(this.botonVenderVehiculo);
        this.botonVenderVehiculo.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrarCliente) {
            VentanaRegistrarCliente ventanaRegistrarCliente= new VentanaRegistrarCliente(automotora);
            //Cierra la ventana actual
            this.dispose();
        }
        if(e.getSource() == this.botonRegistrarVehiculo){
            VentanaRegistroVehiculo ventanaRegistroVehiculo= new VentanaRegistroVehiculo(automotora);
            this.dispose();
        }
        if(e.getSource() == this.botonBuscarVehiculo){
            VentanaBusquedaVehiculo ventanaBusquedaVehiculo= new VentanaBusquedaVehiculo(automotora);
            this.dispose();
        }
        if(e.getSource() == this.botonVenderVehiculo){
            JOptionPane.showMessageDialog(this,"Próximamente","Mensaje Informativo",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        if(e.getSource() == this.botonSalida){
            AutomotoraController.almacenarDatos(this.automotora);
            this.dispose();
            System.exit(0);
        }

    }
}
