import java.util.Stack;

public class HistorialNavegacion {
    private Stack<String> pilaAtras;
    private Stack<String> pilaAdelante;
    private String paginaActual;


    /**
     Constructor que inicializa el historial de navegación vacío.
     Crea las pilas necesarias para navegar adelante y atrás.
     */
    public HistorialNavegacion() {
        pilaAtras = new Stack<>();
        pilaAdelante = new Stack<>();
        paginaActual = null;
    }


/**
 Visita una nueva URL en el navegador.
 Guarda la página actual en el historial de "atrás" y limpia
 el historial de "adelante" (como lo hace un navegador real).
 */
 public void visitarURL(String url) {
        if (paginaActual != null) {
            pilaAtras.push(paginaActual);
        }
        paginaActual = url;

        pilaAdelante.clear();
        System.out.println("Navegando a: " + url);
    }
/**
 Navega a la página anterior en el historial (botón "Atrás").
 Mueve la página actual a la pila de "adelante" y restaura
*/
    public void irAtras() {
        if (pilaAtras.isEmpty()) {
            System.out.println("No hay páginas anteriores");
            return;
        }


        pilaAdelante.push(paginaActual);

        paginaActual = pilaAtras.pop();
        System.out.println("Atrás > " + paginaActual);
    }
/**
 Navega a la página siguiente en el historial (botón "Adelante").
 Mueve la página actual a la pila de "atrás" y restaura
 */
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

    /**
     Muestra el estado completo del historial para debugging.
     Imprime las pilas de atrás y adelante, y la página actual.
     */
    public void mostrarEstado() {
        System.out.println("\nEstado del Historial");
        System.out.println("Pila Atrás: " + pilaAtras);
        System.out.println("Página Actual: " + paginaActual);
        System.out.println("Pila Adelante: " + pilaAdelante);
    }
}
