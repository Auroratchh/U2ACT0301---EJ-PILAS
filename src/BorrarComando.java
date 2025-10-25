public class BorrarComando implements Comando {
    private int inicio;
    private int fin;
    private String textoBorrado;


/**
 Constructor del comando de borrado.
 Inicializa las posiciones del rango a borrar.
 */
    public BorrarComando(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
        this.textoBorrado = "";
    }


/**
 Ejecuta el borrado del texto en el rango especificado.
 Valida los límites y guarda el texto borrado para poder deshacerlo.
 Si los índices son inválidos, no realiza ninguna operación.
 */
    @Override
    public void ejecutar(StringBuilder contenido) {
        if (inicio < 0 || inicio >= contenido.length()) {
            return;
        }
        if (fin > contenido.length()) {
            fin = contenido.length();
        }
        if (fin <= inicio) {
            return;
        }

        textoBorrado = contenido.substring(inicio, fin);
        contenido.delete(inicio, fin);
    }

/**
 Deshace el borrado insertando nuevamente el texto en su posición original.
 Restaura el texto previamente eliminado.
 */
    @Override
    public void deshacer(StringBuilder contenido) {

        if (inicio <= contenido.length()) {
            contenido.insert(inicio, textoBorrado);
        }
    }

    @Override
    public String toString() {
        return "Borrar[pos " + inicio + "-" + fin + ", texto: '" + textoBorrado + "']";
    }
}