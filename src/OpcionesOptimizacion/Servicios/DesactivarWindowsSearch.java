package OpcionesOptimizacion.Servicios;
import OpcionesOptimizacion.VerificarEstadoServicio;
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
            String estado = VerificarEstadoServicio.VerificarEstadoServicio("wsearch");
            if (estado != null) {
                System.out.println("Estado del servicio Windows Search: " + estado);
                if (estado.equals("4")) {
                        String[] comandos = {
                            "cmd.exe",
                            "/C",
                            "sc stop wsearch && sc config wsearch start=disabled"
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
                    } else if (estado.equals("1")) {
                        JOptionPane.showMessageDialog(null, "El servicio Windows Search ya esta desactivado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        int opcion = JOptionPane.showOptionDialog(null, "¿Desea activar el servicio Windows Search?", "Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Aceptar", "Cancelar" }, "Aceptar");
                        
                        if (opcion == JOptionPane.YES_OPTION) {
                            String[] comandos = {
                                "cmd.exe",
                                "/C",
                                "sc config wsearch start=auto && sc start wsearch"
                            };
                            
                            try {
                                ProcessBuilder desactivarWindowsSearchPaso1 = new ProcessBuilder(comandos);
                                Process desactivarWindowsSearchPaso1Process = desactivarWindowsSearchPaso1.start();
                                
                                desactivarWindowsSearchPaso1.redirectErrorStream(true);
                                
                                int exitCode = desactivarWindowsSearchPaso1Process.waitFor();
                                if (exitCode == 0) {
                                    JOptionPane.showMessageDialog(null, "Se ha activado Windows Search correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Ha habido un problema al activar el servicio Windows Search", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else if (opcion == JOptionPane.NO_OPTION) {
                            
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ha habido un problema al verificar el estado del servicio Windows Search", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("No se pudo obtener información del servicio SysMain.");
				}
            }
        });
    }
}
