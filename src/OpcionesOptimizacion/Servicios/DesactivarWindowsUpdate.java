package OpcionesOptimizacion.Servicios;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DesactivarWindowsUpdate {
	
	public static void DesactivarWindowsUpdate(JFrame frame) {
		JButton botonDesactivarWindowsUpdate = new JButton("Desactivar Windows Update");
        botonDesactivarWindowsUpdate.setBounds(10, 360, 178, 30);
        frame.add(botonDesactivarWindowsUpdate);
        
        botonDesactivarWindowsUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Falta saber si esta desactivado o activado

				// Creamos el proceso para detener Windows Update;

				String[] comandos = {
						"cmd.exe",
						"/C",
						"sc stop wuauserv && sc config wuauserv start=disabled" // auto para activar
				};

				ProcessBuilder desactivarWindowsUpdate = new ProcessBuilder(comandos);

				try {
					Process desactivarWindowsUpdateProcess = desactivarWindowsUpdate.start();
					desactivarWindowsUpdate.redirectErrorStream(true);

					int exitCode = desactivarWindowsUpdateProcess.waitFor();
					if (exitCode == 0) {
						JOptionPane.showMessageDialog(null, "Windows Update desactivado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

					} else {
						System.out.println(exitCode);
						JOptionPane.showMessageDialog(null, "Error al desactivar Windows Update", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
					throw new RuntimeException(ex);
				} catch (InterruptedException ex) {
					JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);

					throw new RuntimeException(ex);
                }
            }
        	
        });
	}
}
