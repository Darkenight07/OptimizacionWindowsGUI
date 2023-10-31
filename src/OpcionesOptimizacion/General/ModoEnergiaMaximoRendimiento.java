package OpcionesOptimizacion.General;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModoEnergiaMaximoRendimiento {

    public static void ModoEnergiaMaximoRendimiento(JFrame frame) {

            // Creamos un boton para activar el modo de energia maximo rendimiento
            JButton botonActivarModoEnergiaMaximoRendimiento = new JButton("Activar modo de energia (maximo rendimiento)");
            botonActivarModoEnergiaMaximoRendimiento.setBounds(250, 120, 300, 30);
            frame.add(botonActivarModoEnergiaMaximoRendimiento);

            botonActivarModoEnergiaMaximoRendimiento.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ProcessBuilder procesoMaximoRendimiento = new ProcessBuilder("cmd.exe", "/c", "powercfg -duplicatescheme e9a42b02-d5df-448d-aa00-03f14749eb61");
                        Process procesoMaximoRendimientoProcess = procesoMaximoRendimiento.start();
                        procesoMaximoRendimiento.redirectErrorStream(true);

                        int exitCode = procesoMaximoRendimientoProcess.waitFor();

                        if (exitCode == 0) {
                            System.out.println("Modo de energia maximo rendimiento activado");
                            JOptionPane.showMessageDialog(null, "Modo de energia maximo rendimiento activado", "Informacion", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            System.out.println("Error al activar el modo de energia maximo rendimiento");
                            JOptionPane.showMessageDialog(null, "Error al activar el modo de energia maximo rendimiento", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            });
    }
}
