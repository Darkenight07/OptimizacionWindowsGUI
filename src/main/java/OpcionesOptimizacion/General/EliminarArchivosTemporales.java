package OpcionesOptimizacion.General;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;

public class EliminarArchivosTemporales {
    public static void EliminarArchivosTemporales(JFrame frame) {
        JButton botonEliminarArchivosTemporales = new JButton("Eliminar archivos temporales");
        botonEliminarArchivosTemporales.setBounds(10, 120, 200, 30);
        frame.add(botonEliminarArchivosTemporales);

        botonEliminarArchivosTemporales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creamos los procesos para eliminar la cache
                ProcessBuilder eliminarCachePaso1 = new ProcessBuilder("cmd.exe", "/c", "rmdir /s /q %TEMP%");
                ProcessBuilder eliminarCachePaso2 = new ProcessBuilder("cmd.exe", "/c", "rmdir /s /q %HOMEDRIVE%\\Windows\\Temp\\");
                ProcessBuilder eliminarCachePaso3 = new ProcessBuilder("cmd.exe", "/c", "mkdir %TEMP%");
                ProcessBuilder eliminarCachePaso4 = new ProcessBuilder("cmd.exe", "/c", "mkdir %HOMEDRIVE%\\Windows\\Temp\\");
                try {
                    // Ejecutamos los procesos
                    Process eliminarCachePaso1Process = eliminarCachePaso1.start();
                    eliminarCachePaso1Process.waitFor();
                    Process eliminarCachePaso2Process = eliminarCachePaso2.start();
                    eliminarCachePaso2Process.waitFor();
                    Process eliminarCachePaso3Process = eliminarCachePaso3.start();
                    eliminarCachePaso3Process.waitFor();
                    Process eliminarCachePaso4Process = eliminarCachePaso4.start();
                    eliminarCachePaso4Process.waitFor();
                    JOptionPane.showMessageDialog(null, "Archivos/carpetas temporales eliminados correctamente");
                } catch (IOException | InterruptedException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al eliminar archivos/carpetas temporales");
                }
            }
        });
    }
}
