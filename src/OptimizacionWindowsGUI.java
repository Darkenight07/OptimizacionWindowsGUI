import java.io.IOException; 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import OpcionesOptimizacion.General.*;
import OpcionesOptimizacion.Servicios.*;
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
        EliminarArchivosTemporales.EliminarArchivosTemporales(frame);

        // Boton para desinstalar OneDrive
        DesinstalarOneDrive.DesactivarOneDrive(frame);

        // Boton para desfragmentar unidades
        DesfragmentarUnidades.DesfragmentarUnidades(frame);

        // Desactivar Bluetooth
        DesactivarBluetooth.DesactivarBluetooth(frame);

        // Desactivar SysMain o Superfetch
        DesactivarSysMain.DesactivarSysMain(frame);

        // Desactivar Windows Search --
        JButton botonDesactivarWindowsSearch = new JButton("Desactivar Windows Search");
        botonDesactivarWindowsSearch.setBounds(10, 320, 178, 30);
        frame.add(botonDesactivarWindowsSearch);

        // Desactivar Windows Update --
        JButton botonDesactivarWindowsUpdate = new JButton("Desactivar Windows Update");
        botonDesactivarWindowsUpdate.setBounds(10, 360, 178, 30);
        frame.add(botonDesactivarWindowsUpdate);

        // Hacemos visible la ventana siempre
        frame.setVisible(true);
    }

}

