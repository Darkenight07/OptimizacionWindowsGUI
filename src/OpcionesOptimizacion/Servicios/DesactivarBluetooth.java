package OpcionesOptimizacion.Servicios;
import OpcionesOptimizacion.*;
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

                String estado = VerificarEstadoServicio.VerificarEstadoServicio("bthserv");
                if (estado != null) {
                    System.out.println("Estado del servicio Bluetooth: " + estado);
                    if (estado.equals("4")) {
                        String[] comandos = {
                                "cmd.exe",
                                "/C",
                                "sc stop bthserv && sc config bthserv start=disabled"
                        };

                        try {
                            ProcessBuilder desactivarBluetooth = new ProcessBuilder(comandos);
                            desactivarBluetooth.redirectErrorStream(true);
                            Process desactivarBluetoothProcess = desactivarBluetooth.start();
                            int exitCode = desactivarBluetoothProcess.waitFor();

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

                    }  else if (estado.equals("1")) {
                        JOptionPane.showMessageDialog(null, "El servicio Bluetooth ya esta desactivado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        int opcion = JOptionPane.showOptionDialog(null, "¿Desea activar el servicio Bluetooth?", "Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Aceptar", "Cancelar" }, "Aceptar");

                        if (opcion == JOptionPane.YES_OPTION) {
                            String[] comandos = {
                                    "cmd.exe",
                                    "/C",
                                    "sc config bthserv start=auto && sc start bthserv"
                            };

                            try {
                                ProcessBuilder desactivarBluetooth = new ProcessBuilder(comandos);
                                desactivarBluetooth.redirectErrorStream(true);
                                Process desactivarBluetoothProcess = desactivarBluetooth.start();
                                int exitCode = desactivarBluetoothProcess.waitFor();

                                if (exitCode == 0) {
                                    System.out.println("Bluetooth activado exitosamente.");
                                    JOptionPane.showMessageDialog(null, "Bluetooth activado exitosamente.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    System.out.println("Error al activar Bluetooth. Código de salida: " + exitCode);
                                    JOptionPane.showMessageDialog(null, "Error al activar Bluetooth", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                            } catch (Exception ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);

                            }
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ha habido un problema al verificar el estado del servicio Bluetooth", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("No se pudo obtener información del servicio Bluetooth");
                }
            }
        });
    }
}
