package ventana;

import model.Automotora;
import model.ColorVehiculo;
import model.MarcaVehiculo;
import model.Vehiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class VentanaBusquedaVehiculo extends Ventana {
    private JButton botonBuscar, botonRegresar;
    private JLabel textoEncabezado, textoNombre, textoMarca;
    private JComboBox listaMarca;
    private JTextField campoNombre;
    private Automotora automotora;

    public VentanaBusquedaVehiculo(Automotora automotora) {
        super("Búsqueda de Vehículo", 500, 520);
        this.automotora= automotora;
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarCampoNombre();
        generarBotonBuscarVehiculo();
        generarBotonCancelar();
        generarListaMarcaVehiculo();
    }
    private void generarCampoNombre(){
        String textoNombre= "Modelo Vehículo:";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }
    private void generarListaMarcaVehiculo(){
        super.generarJLabel(this.textoMarca,"Marca vehículo:",20,100,100,20);
        this.listaMarca=super.generarListaDesplegable(MarcaVehiculo.values(),120,100, 100, 20);
        this.add(this.listaMarca);
    }
    private void generarBotonBuscarVehiculo() {
        String textoBoton= "Buscar Vehículo";
        this.botonBuscar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonBuscar);
        this.botonBuscar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonRegresar = "Regresar";
        this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
        this.add(this.botonRegresar);
        this.botonRegresar.addActionListener(this);
    }
    private String[][] registrarVehiculo(){
        List<Vehiculo> vehiculos= new ArrayList<>();
        String[][] datosVehiculos;
        if(this.campoNombre.getText().length()==0){
            System.out.println(this.listaMarca.getSelectedItem());
          vehiculos=  automotora.buscarAutoMarca((MarcaVehiculo) this.listaMarca.getSelectedItem());
        }
        else{
            vehiculos= automotora.buscarAutoNombre(this.campoNombre.getText());
        }
        System.out.println(vehiculos.size());
        datosVehiculos= new String[vehiculos.size()][6];
        for(int i=0; i<vehiculos.size(); i++){
            datosVehiculos[i][0]=vehiculos.get(i).getNombre();
            datosVehiculos[i][1]=vehiculos.get(i).getMarca().getMarcaVehiculo();
            datosVehiculos[i][2]= Integer.toString(vehiculos.get(i).getAño());
            datosVehiculos[i][3]=vehiculos.get(i).getColor();
            datosVehiculos[i][4]=Integer.toString(vehiculos.get(i).getPrecio());
            datosVehiculos[i][5]=Double.toString(vehiculos.get(i).getKmRecorridos());
        }
        return datosVehiculos;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonBuscar){
            String[] nombreColumnas={"Modelo","Marca","Año","Color","Precio","Kilómetros Recorridos"};
            VentanaTabla ventanaTabla= new VentanaTabla(registrarVehiculo(),nombreColumnas);
        }
        if (e.getSource() == this.botonRegresar){
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(automotora);
            this.dispose();
        }

    }
}
