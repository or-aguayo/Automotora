package principal;

import controller.AutomotoraController;
import model.Automotora;
import ventana.VentanaMenuBienvenida;

public class main {
    public static void main(String[] args) {
        Automotora automotora= new Automotora();
        automotora= AutomotoraController.cargaMasivaDatos(automotora);
        VentanaMenuBienvenida ventana= new VentanaMenuBienvenida(automotora);
    }
}
