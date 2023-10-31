package OpcionesOptimizacion.General;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;
public class DesfragmentarUnidades {
    public static void DesfragmentarUnidades(JFrame frame) {
        JButton botonDesfragmentarUnidades = new JButton("Desfragmentar unidades");
        botonDesfragmentarUnidades.setBounds(10, 200, 200, 30);
        frame.add(botonDesfragmentarUnidades);

        botonDesfragmentarUnidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionElegidaDesfragmentacionUnidades = JOptionPane.showInputDialog(null, "Introduzca la unidad a desfragmentar (C, D, E, etc...) en mayusculas", "Desfragmentar unidades", JOptionPane.QUESTION_MESSAGE);

                if (opcionElegidaDesfragmentacionUnidades != null) {
                    // Creamos el proceso para desfragmentar unidades
                    ProcessBuilder desfragmentarUnidades = new ProcessBuilder("cmd.exe", "/c", "defrag " + opcionElegidaDesfragmentacionUnidades + " /U /V");
                    try {
                        // Ejecutamos el proceso, FALTA: CREAR UNA BARRA DE PROGRESO PROGRESIVA PARA QUE EL USUARIO SEPA QUE ESTA OCURRIENDO
                        Process desfragmentarUnidadesProcess = desfragmentarUnidades.start();
                        desfragmentarUnidadesProcess.waitFor();
                        JOptionPane.showMessageDialog(null, "Unidad " + opcionElegidaDesfragmentacionUnidades + " desfragmentada con exito");
                    } catch (IOException | InterruptedException ioException) {
                        ioException.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al desfragmentar la unidad " + opcionElegidaDesfragmentacionUnidades);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha introducido ninguna unidad", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }
}
