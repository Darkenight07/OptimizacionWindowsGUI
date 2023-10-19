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

        // Boton para eleminar cache
        JButton botonEliminarCache = new JButton("Eliminar cache");
        botonEliminarCache.setBounds(10, 120, 178, 30);
        frame.add(botonEliminarCache);

        // Boton para desinstalar OneDrive
        JButton botonDesinstalarOneDrive = new JButton("Desinstalar OneDrive");
        botonDesinstalarOneDrive.setBounds(10, 160, 178, 30);
        frame.add(botonDesinstalarOneDrive);

        // Boton para desfragmentar unidades
        JButton botonDesfragmentarUnidades = new JButton("Desfragmentar unidades");
        botonDesfragmentarUnidades.setBounds(10, 200, 178, 30);
        frame.add(botonDesfragmentarUnidades);


        // Ejecuta el comando "dir" en java
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "dir");
        Process process = processBuilder.start();
        process.waitFor();


        frame.setVisible(true);
    }
}