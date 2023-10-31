package OpcionesOptimizacion.General;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

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

                // src/OpcionesOptimizacion/General/bat/DesactivarEfectosVisuales/prueba.bat

                try {
                    String[] command = { "cmd", "/k","start", "start",".\\src\\OpcionesOptimizacion\\General\\bat\\DesactivarEfectosVisuales\\desactivarEfectosVisuales.bat" };
                    Process process = Runtime.getRuntime().exec(command);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

    }
}
