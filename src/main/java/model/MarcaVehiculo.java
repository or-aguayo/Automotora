package model;
public enum MarcaVehiculo {
    CHEVROLET("Chevrolet"),
    NISSAN("Nissan"),
    FERRARI("Ferrari"),
    SUSUKI("Suzuki"),
    TOYOTA("Toyota");

    private String marcaVehiculo;

    private MarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }
}
