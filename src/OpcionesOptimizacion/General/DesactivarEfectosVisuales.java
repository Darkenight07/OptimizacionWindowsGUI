package OpcionesOptimizacion.General;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;

public class DesactivarEfectosVisuales {

    public static void DesactivarEfectosVisuales(JFrame frame) {
        JButton botonDesactivarEfectosVisuales = new JButton("Desactivar Efectos Visuales");
        botonDesactivarEfectosVisuales.setBounds(250, 160, 300, 30);
        frame.add(botonDesactivarEfectosVisuales);

        botonDesactivarEfectosVisuales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                final int VALOR_ACTIVADO = 3;
                final int VALOR_DESACTIVADO = 2;
                boolean existeRegistro =  Advapi32Util.registryValueExists(WinReg.HKEY_CURRENT_USER, "Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\VisualEffects", "VisualFXSetting");

                if (existeRegistro) {
                    int valorVisualFXSetting = Advapi32Util.registryGetIntValue(WinReg.HKEY_CURRENT_USER, "Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\VisualEffects", "VisualFXSetting");

                    if (valorVisualFXSetting == 3 ) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Los efectos visuales ya estan activados, ¿Desea desactivarlos?", "Confirmar", JOptionPane.YES_NO_OPTION);

                        if (confirm == JOptionPane.YES_OPTION) {
                            Advapi32Util.registrySetIntValue(WinReg.HKEY_CURRENT_USER, "Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\VisualEffects", "VisualFXSetting", VALOR_DESACTIVADO);
                            JOptionPane.showMessageDialog(null, "Efectos visuales desactivados correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        } else if (confirm == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(null, "No se han desactivado los efectos visuales", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else if (valorVisualFXSetting == 2) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Los efectos visuales ya estan desactivados, ¿Desea activarlos", "Confirmar", JOptionPane.YES_NO_OPTION);

                        if (confirm == JOptionPane.YES_OPTION) {
                            Advapi32Util.registrySetIntValue(WinReg.HKEY_CURRENT_USER, "Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\VisualEffects", "VisualFXSetting", VALOR_ACTIVADO);
                            JOptionPane.showMessageDialog(null, "Efectos visuales activados correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        } else if (confirm == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(null, "No se han activado los efectos visuales", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha podido comprobar el estado de los efectos visuales", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else {
                    Advapi32Util.registrySetIntValue(WinReg.HKEY_CURRENT_USER, "Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\VisualEffects", "VisualFXSetting", VALOR_DESACTIVADO);
                    int valorVisualFXSetting = Advapi32Util.registryGetIntValue(WinReg.HKEY_CURRENT_USER, "Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\VisualEffects", "VisualFXSetting");

                    if (valorVisualFXSetting == 2) {
                        JOptionPane.showMessageDialog(null, "Efectos visuales desactivados correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se han podido desactivar los efectos visuales", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }
}
