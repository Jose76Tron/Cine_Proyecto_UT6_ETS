package Cine;

import javax.swing.JOptionPane;

/**
 * Programa principal
 * 
 * @author José Ramón Navarro González
 * @author 1ºA - DAM
 * @version 1.1
 * @since 10/06/2021
 */
public class cinemabookingApplication {

    /**
     * Programa principal
     * 
     * @param args Parametros
     */
    public static void main(final String[] args) {
        final CinemaBooking Cine = new CinemaBooking(75);
        boolean salir = false;

        do {
            final String[] botones = { "Reservar", "Cancelar", "Asientos disponibles", "Salir" };

            int selecion = JOptionPane.showOptionDialog(null,
                    "Bienvenido al cine, asientos disponibles hoy = " + Cine.consultar(), "titulo",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);

            switch (selecion) {
                case 0:
                    if (Cine.consultar() > 0) {
                        do {
                            try {
                                final int asientos = Integer.parseInt(JOptionPane
                                        .showInputDialog(null, "Introduzca la cantidad de asientos a reservar").trim());
                                if (asientos > 0) {
                                    if (Cine.consultar() - asientos >= 0) {
                                        Cine.reservar(asientos);
                                        JOptionPane.showMessageDialog(null,
                                                "Reservado " + asientos + " asientos con éxito");
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No puedes reservar tantos asientos...");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "No puedes reservar esos asientos...");
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Error. Solo puedes escribir números.");
                            }
                        } while (true);
                    } else {
                        JOptionPane.showMessageDialog(null, "No quedan asientos disponibles... :C");
                    }
                    break;
                case 1:
                    do {
                        try {
                            final int asientos = Integer.parseInt(JOptionPane
                                    .showInputDialog(null, "Introduzca la cantidad de asientos a cancelar la reserva.")
                                    .trim());
                            if (asientos > 0) {
                                Cine.cancelar(asientos);
                                JOptionPane.showMessageDialog(null,
                                        "Cancelada la reserva de " + asientos + " asientos con éxito");
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "No puedes cancelar esos asientos...");
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error. Solo puedes escribir números.");
                        }
                    } while (true);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Quedan " + Cine.consultar() + " asientos disponibles.");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Hasta luego!");
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Hasta luego!");
                    salir = true;
                    break;
            }
        } while (salir == false);
    }
}
