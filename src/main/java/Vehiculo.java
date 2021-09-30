public class Vehiculo {
    private String nombre, color, marca;
    private int año, precio;
    private double kmRecorridos, cantidadCombustible;

    public Vehiculo(String nombre, String color, String marca, int año, int precio, double kmRecorridos){
        this.nombre=nombre;
        this.color=color;
        this.marca=marca;
        this.año=año;
        this.precio=precio;
        this.kmRecorridos=kmRecorridos;
        this.cantidadCombustible=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public double getKmRecorridos() {
        return kmRecorridos;
    }

    public double getCantidadCombustible() {
        return cantidadCombustible;
    }

    public void setCantidadCombustible(double cantidadCombustible) {
        this.cantidadCombustible = cantidadCombustible;
    }

    public void setKmRecorridos(double kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }
    public void arrancarVehiculo(){
    //método para arrancar vehiculo
    }
    public void detenerVehiculo(){
    //método para detener vehiculo
    }
    public void rellenarCombustible(double cantCombustible){
        this.cantidadCombustible+= cantCombustible;
    }
}
