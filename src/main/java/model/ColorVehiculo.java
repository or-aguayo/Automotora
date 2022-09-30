package model;
import java.awt.*;

public enum ColorVehiculo {
    BLANCO("Blanco"),
    AZUL("Azul"),
    NEGRO("Negro"),
    PLATEADO("Plateado"),
    GRIS("Gris"),
    DORADO("Dorado"),
    VERDE("Verde");

    private String colorVehiculo;
    private ColorVehiculo(String colorVehiculo){
        this.colorVehiculo= colorVehiculo;
    }

    public String getColorVehiculo() {
        return colorVehiculo;
    }
}
