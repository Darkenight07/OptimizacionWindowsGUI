package OpcionesOptimizacion.Servicios;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;
public class DesactivarSysMain {
    public static void DesactivarSysMain(JFrame frame) {
        JButton botonDesactivarSysMain = new JButton("Desactivar Superfetch");
        botonDesactivarSysMain.setBounds(10, 280, 178, 30);
        frame.add(botonDesactivarSysMain);
        botonDesactivarSysMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int opcion = JOptionPane.showOptionDialog(null, "Advertencia: Puede que el sistema vaya mas lento o mejor", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[] { "Aceptar", "Cancelar" }, "Aceptar");

                if (opcion == JOptionPane.YES_OPTION) {

                    String usuario = System.getenv("USERNAME"); // Obtenemos el nombre de usuario

                    // Creamos los procesos para desactivar Superfetch/SysMain
                    String comando = "cmd.exe /c runas /user:" + usuario + " \"sc stop sysmain && sc config sysmain start=disabled\""; // Auto para que se inicie automaticamente
                    ProcessBuilder desactivarSysMainPaso1 = new ProcessBuilder("cmd.exe", "/c", comando);

                    try {
                        Process desactivarSysMainPaso1Process = desactivarSysMainPaso1.start();
                        desactivarSysMainPaso1.redirectErrorStream(true);
                        int exitCode = desactivarSysMainPaso1Process.waitFor();

                        if (exitCode == 0) {
                            JOptionPane.showMessageDialog(null, "Superfetch/SysMain desactivado correctamente");
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
            }
        });


    }

}
