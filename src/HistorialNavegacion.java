import java.util.Stack;

public class HistorialNavegacion {
    private Stack<String> pilaAtras;
    private Stack<String> pilaAdelante;
    private String paginaActual;

    public HistorialNavegacion() {
        pilaAtras = new Stack<>();
        pilaAdelante = new Stack<>();
        paginaActual = null;
    }

    public void visitarURL(String url) {
        if (paginaActual != null) {
            pilaAtras.push(paginaActual);
        }
        paginaActual = url;

        pilaAdelante.clear();
        System.out.println("Navegando a: " + url);
    }


    public void irAtras() {
        if (pilaAtras.isEmpty()) {
            System.out.println("No hay páginas anteriores");
            return;
        }


        pilaAdelante.push(paginaActual);

        paginaActual = pilaAtras.pop();
        System.out.println("Atrás > " + paginaActual);
    }

    public void irAdelante() {
        if (pilaAdelante.isEmpty()) {
            System.out.println("No hay páginas siguientes");
            return;
        }


        pilaAtras.push(paginaActual);

        paginaActual = pilaAdelante.pop();
        System.out.println("Adelante > " + paginaActual);
    }

    public String getPaginaActual() {
        return paginaActual;
    }


    public void mostrarEstado() {
        System.out.println("\nEstado del Historial");
        System.out.println("Pila Atrás: " + pilaAtras);
        System.out.println("Página Actual: " + paginaActual);
        System.out.println("Pila Adelante: " + pilaAdelante);
    }
}
