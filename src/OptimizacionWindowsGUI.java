import java.io.IOException;
public class OptimizacionWindowsGUI {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Ejecuta el comando "dir" en java
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "dir");
        Process process = processBuilder.start();
        process.waitFor();

    }
}