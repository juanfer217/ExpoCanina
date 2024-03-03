package umariana.exposicion;

public class NombreDuplicadoException extends Exception{
    
    public NombreDuplicadoException(){
        super("Ya existe un perro con este nombre, intentelo nuevamente");
        
    }
    
}
