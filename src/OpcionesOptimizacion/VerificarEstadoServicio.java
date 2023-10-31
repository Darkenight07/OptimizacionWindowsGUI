package OpcionesOptimizacion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VerificarEstadoServicio {

    public static String VerificarEstadoServicio(String Proceso) {
        try {

            ProcessBuilder processBuilder = new ProcessBuilder("sc", "query", Proceso);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("ESTADO")) {
                    return line.split("\\s+")[3]; // Obtenemos el estado, 1 no se esta ejecutando y 4 se esta ejecutando
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
