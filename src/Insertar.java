public class Insertar implements Comando {
    private String texto;
    private int posicion;

    public Insertar(String texto, int posicion) {
        this.texto = texto;
        this.posicion = posicion;
    }

    @Override
    public void ejecutar(StringBuilder contenido) {
        if (posicion < 0 || posicion > contenido.length()) {
            posicion = contenido.length();
        }
        contenido.insert(posicion, texto);
    }

    @Override
    public void deshacer(StringBuilder contenido) {

        int inicio = posicion;
        int fin = posicion + texto.length();
        if (fin <= contenido.length()) {
            contenido.delete(inicio, fin);
        }
    }

    @Override
    public String toString() {
        return "Insertar['" + texto + "' en posición " + posicion + "]";
    }
}