package OpcionesOptimizacion.Servicios;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;
public class DesactivarWindowsSearch {
	
	public static void DesactivarWindowsSearch(JFrame frame) {
		JButton botonDesactivarWindowsSearch = new JButton("Desactivar Windows Search");
        botonDesactivarWindowsSearch.setBounds(10, 320, 178, 30);
        frame.add(botonDesactivarWindowsSearch);
        
        botonDesactivarWindowsSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Falta saber si esta desactivado o activado

				String[] comandos = {
						"cmd.exe",
						"/C",
						"sc stop wsearch && sc config wsearch start=disabled" // auto para activar
				};
				try {
					ProcessBuilder desactivarWindowsSearchPaso1 = new ProcessBuilder(comandos);
					Process desactivarWindowsSearchPaso1Process = desactivarWindowsSearchPaso1.start();
					desactivarWindowsSearchPaso1.redirectErrorStream(true);
					
					int exitCode = desactivarWindowsSearchPaso1Process.waitFor();
					
					if (exitCode == 0) {
						
						JOptionPane.showMessageDialog(null, "Se ha desactivado Windows Search correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "Ha habido un problema al parar el servicio Windows Search", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);

				}
				
			}
        	
        });
	}

}
