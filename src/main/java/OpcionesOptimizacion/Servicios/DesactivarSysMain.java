package OpcionesOptimizacion.Servicios;
import OpcionesOptimizacion.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;
public class DesactivarSysMain {
    public static void DesactivarSysMain(JFrame frame) {
        JButton botonDesactivarSysMain = new JButton("Desactivar Superfetch");
        botonDesactivarSysMain.setBounds(10, 280, 200, 30);
        frame.add(botonDesactivarSysMain);
        botonDesactivarSysMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String estado = VerificarEstadoServicio.VerificarEstadoServicio("sysmain");
                if (estado != null) {
                    System.out.println("Estado del servicio SysMain: " + estado);
                    if (estado.equals("4")) {
                        int opcion = JOptionPane.showOptionDialog(null, "Advertencia: Puede que el sistema vaya mas lento o mejor", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[] { "Aceptar", "Cancelar" }, "Aceptar");

                        if (opcion == JOptionPane.YES_OPTION) {

                            String[] comandos = {
                                    "cmd.exe",
                                    "/C",
                                    "sc stop sysmain && sc config sysmain start=disabled"
                            };

                            // Creamos los procesos para desactivar Superfetch/SysMain

                            ProcessBuilder desactivarSysMainPaso1 = new ProcessBuilder(comandos);

                            try {
                                Process desactivarSysMainPaso1Process = desactivarSysMainPaso1.start();
                                desactivarSysMainPaso1.redirectErrorStream(true);
                                int exitCode = desactivarSysMainPaso1Process.waitFor();

                                if (exitCode == 0) {
                                    JOptionPane.showMessageDialog(null, "Superfetch/SysMain desactivado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    System.out.println(exitCode);
                                    JOptionPane.showMessageDialog(null, "Error al desactivar Superfetch/SysMain", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (IOException | InterruptedException ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Error al desactivar Superfetch/SysMain");
                            }
                        } else if (opcion == JOptionPane.NO_OPTION) {

                        }
                    } else if (estado.equals("1")) {
                        JOptionPane.showMessageDialog(null, "El servicio SysMain ya esta desactivado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        int opcion = JOptionPane.showOptionDialog(null, "¿Desea activar el servicio SysMain?", "Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Aceptar", "Cancelar" }, "Aceptar");

                        if (opcion == JOptionPane.YES_OPTION) {
                            String[] comandos = {
                                    "cmd.exe",
                                    "/C",
                                    "sc config sysmain start=auto && sc start sysmain"
                            };

                            // Creamos los procesos para desactivar Superfetch/SysMain

                            ProcessBuilder desactivarSysMainPaso1 = new ProcessBuilder(comandos);

                            try {
                                Process desactivarSysMainPaso1Process = desactivarSysMainPaso1.start();
                                desactivarSysMainPaso1.redirectErrorStream(true);
                                int exitCode = desactivarSysMainPaso1Process.waitFor();

                                if (exitCode == 0) {
                                    JOptionPane.showMessageDialog(null, "Superfetch/SysMain activado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    System.out.println(exitCode);
                                    JOptionPane.showMessageDialog(null, "Error al activar Superfetch/SysMain", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (IOException | InterruptedException ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Error al activar Superfetch/SysMain");
                            }
                        } else if (opcion == JOptionPane.NO_OPTION) {

                        }
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ha habido un problema al verificar el estado del servicio Sysmain/Superfetch", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("No se pudo obtener información del servicio SysMain.");
                }
            }
        });
    }
}
