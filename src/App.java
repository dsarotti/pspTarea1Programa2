import java.io.IOException;

public class App {
    /** 
     * Esta aplicación ejecuta un proceso externo.
     * @param args
     */
    public static void main(String[] args) {
        // Especificar la ruta a la carpeta con las clases
        final String rutaClases = ".\\bin";
        try {
            // Crea un objeto ProcessBuilder
            //ProcessBuilder builder = new ProcessBuilder("java", "-jar", rutaJar);
            ProcessBuilder builder = new ProcessBuilder("java","-cp", rutaClases,"Tarea1");

            // Redireccionar las entradas y salidas del proceso hijo a las del proceso actual.
            builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            builder.redirectInput(ProcessBuilder.Redirect.INHERIT);
            builder.redirectErrorStream(true);

            // Inicia el proceso
            Process proceso = builder.start();

            // Espera a que el proceso termine guardando el código de retorno
            int retornoProceso = proceso.waitFor();

            // Verifica el valor de retorno del proceso e informa al usuario
            if (retornoProceso == 0) {
                System.out.println("\nEl proceso ha terminado exitosamente.");
            } else {
                System.err.println("\nEl proceso ha terminado con código de retorno: " + retornoProceso);
            }

        } catch (IOException e) {
            // Manejar excepciones de E/S (por ejemplo, clase principal no encontrada)
            e.printStackTrace();
        } catch (InterruptedException e) {
            // Manejar interrupciones del proceso de espera
            e.printStackTrace();
        } catch (Exception e) {
            // Manejar otras excepciones
            e.printStackTrace();
        }

        System.out.println("\nSaliendo del programa.");
        }
}
