public class App {
    /** 
     * Esta aplicación 
     * @param args
     */
    public static void main(String[] args) {
        // Especificar la ruta al archivo JAR
        //final String rutaJar = "C:\\Users\\desarotti\\Documents\\Programación de procesos e servicios\\Tarea 1\\Tarea 1\\Tarea1.jar";
        final String rutaJar = ".\\bin";
        try {
            // Crea un objeto ProcessBuilder
            //ProcessBuilder builder = new ProcessBuilder("java", "-jar", rutaJar);
            ProcessBuilder builder = new ProcessBuilder("java","-cp", rutaJar,"Tarea1");

            //Redireccionar las entradas y salidas del proceso hijo a las mismas del proceso actual.
            builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            builder.redirectInput(ProcessBuilder.Redirect.INHERIT);
            builder.redirectErrorStream(true);

            // Inicia el proceso
            Process proceso = builder.start();

            // Espera a que el proceso termine
            int retornoProceso = proceso.waitFor();

            // Puedes verificar el valor de retorno si lo deseas
            System.out.println("\nEl proceso ha terminado con código de retorno: " + retornoProceso);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nSaliendo del programa.");
    }
}
