import java.awt.*;
import javax.swing.*;
import OpcionesOptimizacion.General.*;
import OpcionesOptimizacion.Servicios.*;

public class OptimizacionWindowsGUI {
    public static void main(String[] args) {

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

        // Optimizacion General

        // Archivo java/clase para eliminar archivos/carpetas temporales
        EliminarArchivosTemporales.EliminarArchivosTemporales(frame);

        // Archivo java/clase para desinstalar OneDrive
        DesinstalarOneDrive.DesactivarOneDrive(frame);

        // Archivo java/clase para desfragmentar unidades
        DesfragmentarUnidades.DesfragmentarUnidades(frame);

        // Activar modo de energia maximo rendimiento
        ModoEnergiaMaximoRendimiento.ModoEnergiaMaximoRendimiento(frame);

        // Archivo java para desactivar los efectos visuales
        DesactivarEfectosVisuales.DesactivarEfectosVisuales(frame);
        
        
        // SERVICIOS
        

        // Archivo java/clase para desactivar Bluetooth
        DesactivarBluetooth.DesactivarBluetooth(frame);

        // Archivo java/clase para desactivar SysMain o Superfetch
        DesactivarSysMain.DesactivarSysMain(frame);

        // Archivo java/clase para desactivar Windows Search --
        DesactivarWindowsSearch.DesactivarWindowsSearch(frame);

        // Archivo java/clase pra desactivar Windows Update --
        DesactivarWindowsUpdate.DesactivarWindowsUpdate(frame);

        // Hacemos visible la ventana siempre
        frame.setVisible(true);
    }

}
