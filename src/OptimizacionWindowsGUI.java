import java.io.IOException; 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class OptimizacionWindowsGUI {
    public static void main(String[] args) throws IOException, InterruptedException {

        JFrame frame = new JFrame("OptimizacionWindowsGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setResizable(false);
        frame.setLayout(null);

        JLabel textoPrincipal = new JLabel("Optimizacion Windows GUI");
        textoPrincipal.setBounds(139, 10, 239, 30);
        textoPrincipal.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(textoPrincipal);

        JLabel textoSecundario = new JLabel("Seleccione una opcion:");
        textoSecundario.setBounds(10, 80, 239, 30);
        frame.add(textoSecundario);

        // Boton para eliminar carpetas temporales/archivos temporales
        JButton botonEliminarArchivosTemporales = new JButton("Eliminar cache");
        botonEliminarArchivosTemporales.setBounds(10, 120, 178, 30);
        frame.add(botonEliminarArchivosTemporales);


        // Boton para desinstalar OneDrive
        OpcionesOptimizacion.General.DesinstalarOneDrive botonDesinstalarOneDrive = new OpcionesOptimizacion.General.DesinstalarOneDrive();
        botonDesinstalarOneDrive.DesactivarOneDrive(frame);

        // Boton para desfragmentar unidades
        JButton botonDesfragmentarUnidades = new JButton("Desfragmentar unidades");
        botonDesfragmentarUnidades.setBounds(10, 200, 178, 30);
        frame.add(botonDesfragmentarUnidades);

        // Desactivar Bluetooth --
        OpcionesOptimizacion.Servicios.DesactivarBluetooth botonDesactivarBluetooth = new OpcionesOptimizacion.Servicios.DesactivarBluetooth();
        botonDesactivarBluetooth.desactivarBluetooth(frame);

        // Desactivar SysMain o Superfetch --
        JButton botonDesactivarSysMain = new JButton("Desactivar Superfetch");
        botonDesactivarSysMain.setBounds(10, 280, 178, 30);
        frame.add(botonDesactivarSysMain);

        // Desactivar Windows Search --
        JButton botonDesactivarWindowsSearch = new JButton("Desactivar Windows Search");
        botonDesactivarWindowsSearch.setBounds(10, 320, 178, 30);
        frame.add(botonDesactivarWindowsSearch);

        // Desactivar Windows Update --
        JButton botonDesactivarWindowsUpdate = new JButton("Desactivar Windows Update");
        botonDesactivarWindowsUpdate.setBounds(10, 360, 178, 30);
        frame.add(botonDesactivarWindowsUpdate);


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
                    JOptionPane.showMessageDialog(null, "Cache eliminada con exito");
                } catch (IOException | InterruptedException ioException) {
                    ioException.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al eliminar la cache");
                }
            }
        });

        botonDesfragmentarUnidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionElegidaDesfragmentacionUnidades = JOptionPane.showInputDialog(null, "Introduzca la unidad a desfragmentar (C, D, E, etc...) en mayusculas", "Desfragmentar unidades", JOptionPane.QUESTION_MESSAGE);

                if (opcionElegidaDesfragmentacionUnidades != null) {
                    // Creamos el proceso para desfragmentar unidades
                    ProcessBuilder desfragmentarUnidades = new ProcessBuilder("cmd.exe", "/c", "defrag " + opcionElegidaDesfragmentacionUnidades + " /U /V");
                    try {
                        // Ejecutamos el proceso, FALTA: CREAR UNA BARRA DE PROGRESO PROGRESIVA PARA QUE EL USUARIO SEPA QUE ESTA OCURRIENDO
                        Process desfragmentarUnidadesProcess = desfragmentarUnidades.start();
                        desfragmentarUnidadesProcess.waitFor();
                        JOptionPane.showMessageDialog(null, "Unidad " + opcionElegidaDesfragmentacionUnidades + " desfragmentada con exito");
                    } catch (IOException | InterruptedException ioException) {
                        ioException.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al desfragmentar la unidad " + opcionElegidaDesfragmentacionUnidades);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha introducido ninguna unidad", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Hacemos visible la ventana siempre
        frame.setVisible(true);
    }

}

