import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    moduloNavegacion();
                    break;
                case 2:
                    moduloEditor();
                    break;
                case 0:
                    salir = true;
                    System.out.println("\n¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("          PILAS                  ");
        System.out.println("1. Módulo de Historial de Navegación ");
        System.out.println("2. Gestor de Deshacer/Rehacer ");
        System.out.println("0. Salir");
        System.out.print("\nSeleccione una opción: ");
    }

    private static void moduloNavegacion() {
        HistorialNavegacion navegador = new HistorialNavegacion();
        boolean volver = false;


        System.out.println("      MÓDULO DE HISTORIAL DE NAVEGACIÓN              ");


        while (!volver) {
            System.out.println("\nNavegador Web");
            if (navegador.getPaginaActual() != null) {
                System.out.println("Página actual: " + navegador.getPaginaActual());
            } else {
                System.out.println("Página actual: [Ninguna]");
            }

            System.out.println("\n1. Visitar URL");
            System.out.println("2. Ir Atrás");
            System.out.println("3. Ir Adelante");
            System.out.println("4. Ver estado del historial");
            System.out.println("0. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la URL: ");
                    scanner.nextLine();
                    String url = scanner.nextLine();
                    navegador.visitarURL(url);
                    break;
                case 2:
                    navegador.irAtras();
                    break;
                case 3:
                    navegador.irAdelante();
                    break;
                case 4:
                    navegador.mostrarEstado();
                    break;
                case 0:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void moduloEditor() {
        GestorDeshacerRe editor = new GestorDeshacerRe();
        boolean volver = false;

        System.out.println("      GESTOR DE DESHACER/REHACER            ");

        while (!volver) {
            System.out.println("\nEditor de Texto ---");
            System.out.println("Contenido actual: \"" + editor.getContenido() + "\"");

            System.out.println("\n1. Insertar texto");
            System.out.println("2. Borrar texto");
            System.out.println("3. Deshacer (Ctrl+Z)");
            System.out.println("4. Rehacer (Ctrl+Y)");
            System.out.println("5. Ver estado del editor");
            System.out.println("0. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    insertarTexto(editor);
                    break;
                case 2:
                    borrarTexto(editor);
                    break;
                case 3:
                    editor.deshacer();
                    break;
                case 4:
                    editor.rehacer();
                    break;
                case 5:
                    editor.mostrarEstado();
                    break;
                case 0:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void insertarTexto(GestorDeshacerRe editor) {
        scanner.nextLine();
        System.out.print("Ingrese el texto a insertar: ");
        String texto = scanner.nextLine();

        System.out.print("Ingrese la posición (0 para el inicio, -1 para el final): ");
        int pos = leerOpcion();

        if (pos == -1) {
            pos = editor.getContenido().length();
        }

        editor.ejecutarComando(new Insertar(texto, pos));
    }

    private static void borrarTexto(GestorDeshacerRe editor) {
        if (editor.getContenido().isEmpty()) {
            System.out.println("No hay texto para borrar.");
            return;
        }

        System.out.print("Ingrese posición inicial: ");
        int inicio = leerOpcion();
        System.out.print("Ingrese posición final: ");
        int fin = leerOpcion();

        editor.ejecutarComando(new BorrarComando(inicio, fin));
    }

    private static int leerOpcion() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }
}