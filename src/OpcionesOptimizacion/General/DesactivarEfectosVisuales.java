package OpcionesOptimizacion.General;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import java.util.prefs.Preferences;

public class DesactivarEfectosVisuales {
	
	public static void DesactivarEfectosVisuales(JFrame frame) {
		JButton botonDesactivarEfectosVisuales = new JButton("Desactivar Efectos Visuales");
		botonDesactivarEfectosVisuales.setBounds(250, 160, 300, 30);
		frame.add(botonDesactivarEfectosVisuales);
		
		botonDesactivarEfectosVisuales.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String rutaRegistro = "HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\VisualEffects";
		        String valorRegistro = "VisualFXSetting";
		        int valorNuevo = 2;
		        
		        Preferences prefs = Preferences.userRoot().node(rutaRegistro);
		        
		        if (prefs.get(valorRegistro, null) != null) {
		            System.out.println("La entrada de registro existe.");
		            
		            int opcion = JOptionPane.showOptionDialog(null, "Ya estaba desactivado los efectos visuales ¿Quieres activarlos de nuevo?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Aceptar", "Cancelar" }, "Aceptar");
		            if (opcion == JOptionPane.YES_OPTION) {
		            	
			            String comando = "reg delete " + rutaRegistro + " /v " + "/f";
			            String[] command = {"cmd", "/c", "start", comando};
			            ProcessBuilder activarEfectosVisuales = new ProcessBuilder(command);
			            
			            try {
			            	Process desactivarEfectosVisualesProcess = activarEfectosVisuales.start();
			            	activarEfectosVisuales.redirectErrorStream(true);
			            	
			            	int exitCode = desactivarEfectosVisualesProcess.waitFor();
			            	
			            	if (exitCode == 0) {
								JOptionPane.showMessageDialog(null, "Se ha activado los efectos visuales", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			            	} else {
								JOptionPane.showMessageDialog(null, "Ha habido un problema al activar los efectos visuales", "Error", JOptionPane.ERROR_MESSAGE);
			            	}
			         
			            } catch (IOException ex){
			            	ex.printStackTrace();
			            } catch (InterruptedException ex) {
							ex.printStackTrace();
						}
		            } 
		            
		        } else {
		            System.out.println("La entrada de registro no existe.");

		            String comando = "reg add " + rutaRegistro + " /v " + valorRegistro + " /t " + "REG_DWORD /d " + valorNuevo;
		            String[] command = {"cmd", "/c", "start", comando};
		            ProcessBuilder desactivarEfectosVisuales = new ProcessBuilder(command);
		            
		            try {
						Process desactivarEfectosVisualesProcess = desactivarEfectosVisuales.start();
						desactivarEfectosVisuales.redirectErrorStream(true);
						
						int exitCode = desactivarEfectosVisualesProcess.waitFor();
						
						if (exitCode == 0) {
							JOptionPane.showMessageDialog(null, "Se ha desactivado los efectos visuales", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Ha habido un problema al desactivar los efectos visuales", "Error", JOptionPane.ERROR_MESSAGE);

						}
						
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
		            
		        }
			}
		});
	}
}
