public class Insertar implements Comando {
    private String texto;
    private int posicion;

/**
 Constructor del comando de inserción.
 */

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

    /**
     Deshace la inserción eliminando el texto previamente agregado.
     Borra exactamente la cantidad de caracteres que fueron insertados.
     */
    @Override
    public void deshacer(StringBuilder contenido) {

        int inicio = posicion;
        int fin = posicion + texto.length();
        if (fin <= contenido.length()) {
            contenido.delete(inicio, fin);
        }
    }

    /**
     Retorna una representación en String del comando.
     Muestra el texto insertado y su posición.
     */

    @Override
    public String toString() {
        return "Insertar['" + texto + "' en posición " + posicion + "]";
    }
}