import java.util.Stack;

public class GestorDeshacerRe {
    private Stack<Comando> pilaDeshacer;
    private Stack<Comando> pilaRehacer;
    private StringBuilder contenido;

    public GestorDeshacerRe() {
        pilaDeshacer = new Stack<>();
        pilaRehacer = new Stack<>();
        contenido = new StringBuilder();
    }


    public void ejecutarComando(Comando comando) {
        comando.ejecutar(contenido);
        pilaDeshacer.push(comando);

        pilaRehacer.clear();

        System.out.println("Ejecutado: " + comando);
    }

    public void deshacer() {
        if (pilaDeshacer.isEmpty()) {
            System.out.println("No hay acciones para deshacer");
            return;
        }

        Comando comando = pilaDeshacer.pop();
        comando.deshacer(contenido);
        pilaRehacer.push(comando);

        System.out.println("Deshecho: " + comando);
    }

    public void rehacer() {
        if (pilaRehacer.isEmpty()) {
            System.out.println("No hay acciones para rehacer");
            return;
        }

        Comando comando = pilaRehacer.pop();
        comando.ejecutar(contenido);
        pilaDeshacer.push(comando);

        System.out.println("Rehecho: " + comando);
    }

    public String getContenido() {
        return contenido.toString();
    }

    public void mostrarEstado() {
        System.out.println("\nEstado del Editor");
        System.out.println("Pila Deshacer: " + pilaDeshacer);
        System.out.println("Contenido: \"" + contenido + "\"");
        System.out.println("Pila Rehacer: " + pilaRehacer);
    }
}