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

            }
        });

    }
}
