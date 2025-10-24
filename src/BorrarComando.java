public class BorrarComando implements Comando {
    private int inicio;
    private int fin;
    private String textoBorrado;

    public BorrarComando(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
        this.textoBorrado = "";
    }

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