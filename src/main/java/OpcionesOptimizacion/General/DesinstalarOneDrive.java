package OpcionesOptimizacion.General;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;
public class DesinstalarOneDrive {
    public static void DesactivarOneDrive(JFrame frame) {
        JButton botonDesinstalarOneDrive = new JButton("Desinstalar OneDrive");
        botonDesinstalarOneDrive.setBounds(10, 160, 200, 30);
        frame.add(botonDesinstalarOneDrive);

        botonDesinstalarOneDrive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProcessBuilder comprobarOneDrive = new ProcessBuilder("cmd.exe", "/c", "tasklist /fi \"imagename eq OneDrive.exe\" /fo csv > NUL 2>&1");
                try {
                    // Ejecutamos el proceso
                    Process comprobarOneDriveProcess = comprobarOneDrive.start();
                    comprobarOneDriveProcess.waitFor();

                    // Creamos una variable para guardar la salida del proceso
                    String comprobarOneDriveOutput = comprobarOneDriveProcess.getOutputStream().toString();

                    // Creamos un if para comprobar si la variable de salida del proceso contiene "OneDrive.exe", si la contiene, ejecutamos el codigo de abajo, si no, mostramos un mensaje de que OneDrive no esta instalado
                    if (comprobarOneDriveOutput.contains("OneDrive.exe")) {

                        // Creamos variables para la ruta de OneDrive
                        final String x86 = "%SYSTEMROOT%\\System32\\OneDriveSetup.exe";
                        final String x64 = "%SYSTEMROOT%\\SysWOW64\\OneDriveSetup.exe";

                        // Creamos los primeros procesos para cerrar el proceso OneDrive.exe
                        ProcessBuilder desinstalarOneDrivePaso1 = new ProcessBuilder("cmd.exe", "/c", "taskkill /f /im OneDrive.exe > NUL 2>&1");
                        ProcessBuilder desinstalarOneDrivePaso2 = new ProcessBuilder("cmd.exe", "/c", "ping 127.0.0.1 -n 5 > NUL 2>&1");

                        try {
                            // Ejecutamos los procesos
                            Process desinstalarOneDrivePaso1Process = desinstalarOneDrivePaso1.start();
                            desinstalarOneDrivePaso1Process.waitFor();
                            Process desinstalarOneDrivePaso2Process = desinstalarOneDrivePaso2.start();
                            desinstalarOneDrivePaso2Process.waitFor();

                            // Si la variable de entorno "ProgramFiles(x86)" existe, ejecutamos el proceso de desinstalacion de OneDrive para 32 bits, si no, ejecutamos el proceso de desinstalacion de OneDrive para 64 bits
                            if (System.getenv("ProgramFiles(x86)") != null) {
                                ProcessBuilder desinstalarOneDrivePaso3 = new ProcessBuilder("cmd.exe", "/c", x86 + " /uninstall");
                                Process desinstalarOneDrivePaso3Process = desinstalarOneDrivePaso3.start();
                                desinstalarOneDrivePaso3Process.waitFor();
                            } else {
                                ProcessBuilder desinstalarOneDrivePaso3 = new ProcessBuilder("cmd.exe", "/c", x64 + " /uninstall");
                                Process desinstalarOneDrivePaso3Process = desinstalarOneDrivePaso3.start();
                                desinstalarOneDrivePaso3Process.waitFor();
                            }
                            // Volvemos a ejecutar el ping de la variable ya creada anteriormente
                            Process desinstalarOneDrivePaso4Process = desinstalarOneDrivePaso2.start();
                            desinstalarOneDrivePaso4Process.waitFor();

                            // Borrando restos de OneDrive creando procesos
                            ProcessBuilder desinstalarOneDrivePaso5 = new ProcessBuilder("cmd.exe", "/c", "rd \"%USERPROFILE%\\OneDrive\" /Q /S > NUL 2>&1");
                            ProcessBuilder desinstalarOneDrivePaso6 = new ProcessBuilder("cmd.exe", "/c", "rd \"C:\\OneDriveTemp\" /Q /S > NUL 2>&1");
                            ProcessBuilder desinstalarOneDrivePaso7 = new ProcessBuilder("cmd.exe", "/c", "rd \"%LOCALAPPDATA%\\Microsoft\\OneDrive\" /Q /S > NUL 2>&1");
                            ProcessBuilder desinstalarOneDrivePaso8 = new ProcessBuilder("cmd.exe", "/c", "rd \"%PROGRAMDATA%\\Microsoft OneDrive\" /Q /S > NUL 2>&1");


                            // Ejecutamos procesos
                            Process desinstalarOneDrivePaso5Process = desinstalarOneDrivePaso5.start();
                            desinstalarOneDrivePaso5Process.waitFor();
                            Process desinstalarOneDrivePaso6Process = desinstalarOneDrivePaso6.start();
                            desinstalarOneDrivePaso6Process.waitFor();
                            Process desinstalarOneDrivePaso7Process = desinstalarOneDrivePaso7.start();
                            desinstalarOneDrivePaso7Process.waitFor();
                            Process desinstalarOneDrivePaso8Process = desinstalarOneDrivePaso8.start();
                            desinstalarOneDrivePaso8Process.waitFor();

                            // Borramos OneDrive del panel lateral del explorador
                            ProcessBuilder desinstalarOneDrivePaso9 = new ProcessBuilder("cmd.exe", "/c", "REG DELETE \"HKEY_CLASSES_ROOT\\CLSID\\{018D5C66-4533-4307-9B53-224DE2ED1FE6}\" /f > NUL 2>&1");
                            ProcessBuilder desinstalarOneDrivePaso10 = new ProcessBuilder("cmd.exe", "/c", "REG DELETE \"HKEY_CLASSES_ROOT\\Wow6432Node\\CLSID\\{018D5C66-4533-4307-9B53-224DE2ED1FE6}\" /f > NUL 2>&1");

                            // Ejecutamos procesos
                            Process desinstalarOneDrivePaso9Process = desinstalarOneDrivePaso9.start();
                            desinstalarOneDrivePaso9Process.waitFor();
                            Process desinstalarOneDrivePaso10Process = desinstalarOneDrivePaso10.start();
                            desinstalarOneDrivePaso10Process.waitFor();

                            JOptionPane.showMessageDialog(null, "OneDrive desinstalado con exito");
                            int confirm = JOptionPane.showConfirmDialog(null, "Para completar la desinstalacion de OneDrive, reinicie el equipo", "Reiniciar equipo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

                            // Si el usuario pulsa el boton de "Si", reiniciamos el equipo
                            if (confirm == JOptionPane.YES_OPTION) {
                                ProcessBuilder desinstalarOneDrivePaso11 = new ProcessBuilder("cmd.exe", "/c", "shutdown /r /t 0");
                                Process desinstalarOneDrivePaso11Process = desinstalarOneDrivePaso11.start();
                                desinstalarOneDrivePaso11Process.waitFor();
                            }
                        } catch (IOException | InterruptedException ioException) {
                            ioException.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error al desinstalar OneDrive");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "OneDrive no esta instalado", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                } catch (IOException | InterruptedException ioException) {
                    ioException.printStackTrace();
                }


            }
        });
    }


}
