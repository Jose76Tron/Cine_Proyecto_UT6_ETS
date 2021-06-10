package Cine;

/**
 * Objeto {@link #CinemaBooking}, este almacena la cantidad de asientos libres y
 * el número de asientos del cine.
 * 
 * @author José Ramón Navarro González
 * @author 1ºA - DAM
 * @version 1.1
 * @since 10/06/2021
 */
public class CinemaBooking {

    // VARIABLES PRIVADAS
    private int numAsientosFree;
    private final int numAsientosCinema;

    // METODOS PÚBLICOS
    /**
     * Constructor
     * 
     * @param asientos Número de asientos del cine.
     */
    public CinemaBooking(int asientos) {
        this.numAsientosCinema = asientos;
        this.numAsientosFree = this.numAsientosCinema;
    }

    // METODOS SETTER
    /**
     * Método para reservar asientos en nuestro cine, restando a numAsientosFree los
     * asientos
     * 
     * @param asientos Asientos a reservar.
     */
    public void reservar(int asientos) {
        this.numAsientosFree -= asientos;
    }

    /**
     * Método para cancelar reserva en nuestro cine, sumando a numAsientosFree los
     * asientos
     * 
     * @param asientos Asientos a cancelar reserva.
     */
    public void cancelar(int asientos) {
        this.numAsientosFree += asientos;
    }

    // METODOS GETTER

    /**
     * Método para consultar el numero de asientos disponibles
     * 
     * @return Cantidad de asientos disponibles.
     */
    public int consultar() {
        return this.numAsientosFree;
    }

}
