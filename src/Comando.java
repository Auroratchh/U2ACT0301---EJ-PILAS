public interface Comando {
    void ejecutar(StringBuilder contenido);

    void deshacer(StringBuilder contenido);
}