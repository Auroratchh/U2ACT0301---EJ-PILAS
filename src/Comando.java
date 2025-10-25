public interface Comando {
    /**
     Ejecuta el comando sobre el contenido del editor.
     Modifica el StringBuilder según la operación específica del comando.
     */
    void ejecutar(StringBuilder contenido);
    /**
     Revierte los cambios realizados por el método ejecutar.
     */
    void deshacer(StringBuilder contenido);
}