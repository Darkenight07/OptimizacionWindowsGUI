package OpcionesOptimizacion.Servicios;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesactivarBluetooth {
    public static void DesactivarBluetooth(JFrame frame) {
        JButton botonDesactivarBluetooth = new JButton("Desactivar Bluetooth");
        botonDesactivarBluetooth.setBounds(10, 240, 178, 30);
        frame.add(botonDesactivarBluetooth);
        botonDesactivarBluetooth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Falta saber si esta desactivado o activado y probarlo
                    String comando = "powershell.exe -Command \"& {Disable-NetAdapter -Name 'Bluetooth'}\""; // Activate para activar
                    ProcessBuilder desactivarBluetooth = new ProcessBuilder("cmd.exe", "/c", comando);
                    desactivarBluetooth.redirectErrorStream(true);
                    Process process = desactivarBluetooth.start();
                    int exitCode = process.waitFor();

                    if (exitCode == 0) {
                        System.out.println("Bluetooth desactivado exitosamente.");
                        JOptionPane.showMessageDialog(null, "Bluetooth desactivado exitosamente.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        System.out.println("Error al desactivar Bluetooth. Código de salida: " + exitCode);
                        JOptionPane.showMessageDialog(null, "Error al desactivar Bluetooth", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
