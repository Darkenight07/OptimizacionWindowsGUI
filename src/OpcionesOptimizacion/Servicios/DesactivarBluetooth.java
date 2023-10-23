package OpcionesOptimizacion.Servicios;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesactivarBluetooth {
    public void desactivarBluetooth(JFrame frame) {
        JButton botonDesactivarBluetooth = new JButton("Desactivar Bluetooth");
        botonDesactivarBluetooth.setBounds(10, 240, 178, 30);
        frame.add(botonDesactivarBluetooth);
        botonDesactivarBluetooth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String comando = "powershell.exe -Command \"& {Disable-NetAdapter -Name 'Bluetooth'}\"";
                    ProcessBuilder desactivarBluetooth = new ProcessBuilder("cmd.exe", "/c", comando);
                    desactivarBluetooth.redirectErrorStream(true);
                    Process process = desactivarBluetooth.start();
                    int exitCode = process.waitFor();

                    if (exitCode == 0) {
                        System.out.println("Bluetooth desactivado exitosamente.");
                    } else {
                        System.out.println("Error al desactivar Bluetooth. Código de salida: " + exitCode);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
