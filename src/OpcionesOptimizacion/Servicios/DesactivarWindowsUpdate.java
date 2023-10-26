package OpcionesOptimizacion.Servicios;
import OpcionesOptimizacion.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;

public class DesactivarWindowsUpdate {

	public static void DesactivarWindowsUpdate(JFrame frame) {
		JButton botonDesactivarWindowsUpdate = new JButton("Desactivar Windows Update");
		botonDesactivarWindowsUpdate.setBounds(10, 360, 178, 30);
		frame.add(botonDesactivarWindowsUpdate);

		botonDesactivarWindowsUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String estado = VerificarEstadoServicio.VerificarEstadoServicio("wuauserv");

				if (estado != null) {
					System.out.println("Estado del servicio Windows Search: " + estado);
					if (estado.equals("4")) {
						// Creamos el proceso para detener Windows Update;

						String[] comandos = {
								"cmd.exe",
								"/C",
								"sc stop wuauserv && sc config wuauserv start=disabled"
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
					} else if (estado.equals("1")) {
						JOptionPane.showMessageDialog(null, "El servicio Windows Update ya esta desactivado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						int opcion = JOptionPane.showOptionDialog(null, "¿Desea activar el servicio Windows Update?", "Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Aceptar", "Cancelar" }, "Aceptar");

						if (opcion == JOptionPane.YES_OPTION) {
							String[] comandos = {
									"cmd.exe",
									"/C",
									"sc config wuauserv start=auto && sc start wuauserv"
							};

							try {
								ProcessBuilder desactivarWindowsUpdate = new ProcessBuilder(comandos);
								Process desactivarWindowsUpdateProcess = desactivarWindowsUpdate.start();
								desactivarWindowsUpdate.redirectErrorStream(true);

								int exitCode = desactivarWindowsUpdateProcess.waitFor();
								if (exitCode == 0) {
									JOptionPane.showMessageDialog(null, "Windows Update activado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);

								} else {
									System.out.println(exitCode);
									JOptionPane.showMessageDialog(null, "Error al activar Windows Update", "Error", JOptionPane.ERROR_MESSAGE);
								}
							} catch (IOException ex) {
								JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
								throw new RuntimeException(ex);
							} catch (InterruptedException ex) {
								JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
								throw new RuntimeException(ex);
							}
						} else if (opcion == JOptionPane.NO_OPTION) {

						}
					}
				} else {
					System.out.println("Error al verificar el estado del servicio Windows Update");
					JOptionPane.showMessageDialog(null, "Error al verificar el estado del servicio Windows Update", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}