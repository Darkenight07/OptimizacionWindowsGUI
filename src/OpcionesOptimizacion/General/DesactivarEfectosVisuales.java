package OpcionesOptimizacion.General;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DesactivarEfectosVisuales {

    public static void DesactivarEfectosVisuales(JFrame frame) {
        JButton botonDesactivarEfectosVisuales = new JButton("Desactivar Efectos Visuales");
        botonDesactivarEfectosVisuales.setBounds(250, 160, 300, 30);
        frame.add(botonDesactivarEfectosVisuales);

        botonDesactivarEfectosVisuales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int valorActivarRegistro = 3;
                int valorDesactivarRegistro = 2;


                try {
                	JOptionPane.showMessageDialog(null, "Se va a ejecutar un archivo .bat, tienes que hacer lo que te pida", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    String[] command = { "cmd", "/k","start", "start",".\\src\\OpcionesOptimizacion\\General\\bat\\DesactivarEfectosVisuales\\desactivarEfectosVisuales.bat" };
                    Process process = Runtime.getRuntime().exec(command);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

    }
}
