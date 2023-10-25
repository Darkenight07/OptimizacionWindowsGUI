package OpcionesOptimizacion.Servicios;
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
				// Falta
				
			}
        	
        });
        
	}

}
