package umariana.exposicion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Juan Jaramillo - Mayk Caicedo
 */
public class ExposicionCanina {
        ArrayList<Perro> misPerros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
    public static void main(String[] args) {
        
        ExposicionCanina p = new ExposicionCanina();
        p.mostrarMenu();
    }
    
    public void mostrarMenu(){
        boolean activa = true;

        do {
            System.out.println("  ___________________________________");
            System.out.println("()       EXPOSICION CANINA           |");
            System.out.println("()                                   |");
            System.out.println("() 1. Agregar Perro                  |");
            System.out.println("() 2. Lista De Perros Inscritos      |");
            System.out.println("() 3. Localizar Perro Por Nombre     |");
            System.out.println("() 4. Buscar Perro Ganador           |");
            System.out.println("() 5. Buscar Perro Con Menor Puntaje |");
            System.out.println("() 6. Buscar Perro Con Mas Años      |");
            System.out.println("() 7. Salir                          |");
            System.out.println("()___________________________________|");
            
            int opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    try {
                        agregarPerro();
                    }catch(NombreDuplicadoException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Orden de la lista por:");
                    System.out.println("1. Por edad");
                    System.out.println("2. Por puntos");

                    int opcion2 = sc.nextInt();
                    switch(opcion2){
                        case 1:
                            listaPorEdad();
                            break;
                        case 2:
                            listaPorPuntos();
                            break;
                }
                    break;
                case 3:
                    localizarPerro();
                    break;
                case 4:
                    perroGanador();
                    break;
                case 5:
                    perroMenorPuntaje();
                    break;
                case 6:
                    perroMayorEdad();
                    break;
                case 7:
                    activa = false;
                    System.out.println("PROGRAMA FINALIZADO");
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
            }
        }while (activa);
    }
    
    public void agregarPerro() throws NombreDuplicadoException{
        System.out.println("Ingrese el nombre del perro");
        String nombre = sc.next();
        if(!misPerros.isEmpty()){
         for(Perro p : misPerros)   
         {
          if(p.getNombre().equalsIgnoreCase(nombre)) 
          {
              throw new NombreDuplicadoException();
          }
         }
        }
        System.out.println("Ingresa la raza");
        String raza = sc.next();
        System.out.println("Ingresa la edad");
        int edad = sc.nextInt();
        System.out.println("Ingresa los puntos");
        int puntos = sc.nextInt();
        System.out.println("Ingresa la foto");
        String foto = sc.next();
        
        Perro nuevoPerro = new Perro(nombre, edad, puntos, raza, foto);
        misPerros.add(nuevoPerro);
    }
    
    public void listaPorEdad(){
        for (int i = 0; i < misPerros.size() - 1; i++)
            for (int j = i + 1; j < misPerros.size(); j++) {
                Perro p1 = misPerros.get(i);
                Perro p2 = misPerros.get(j);
                
                if(p1.getEdad() > p2.getEdad()){
                    misPerros.set(i, p2);
                    misPerros.set(j, p2);    
                }
            }
        System.out.println("------LISTA ORDENADA POR EDAD------");
        for (Perro o : misPerros) {
            System.out.println("Nombre: " + o.getNombre());
            System.out.println("Edad: " + o.getEdad());
            System.out.println("Raza: " + o.getRaza());
            System.out.println("Puntos: " + o.getPuntos());
            System.out.println("Foto: " + o.getFoto());
            System.out.println("-----------------------------");
        }
    }
    
    public void listaPorPuntos(){
        for (int i = 0; i < misPerros.size() - 1; i++)
            for (int j = i + 1; j < misPerros.size(); j++) {
                Perro p1 = misPerros.get(i);
                Perro p2 = misPerros.get(j);
                
                if(p1.getPuntos() > p2.getPuntos()){
                    misPerros.set(i, p2);
                    misPerros.set(j, p2);    
                }
            }
        System.out.println("------LISTA ORDENADA POR PUNTOS------");
        for (Perro p : misPerros) {
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Edad: " + p.getEdad());
            System.out.println("Raza: " + p.getRaza());
            System.out.println("Puntos: " + p.getPuntos());
            System.out.println("Foto: " + p.getFoto());
            System.out.println("-----------------------------");
        }
    }
    
    public void localizarPerro(){
        boolean perroEncontrado = false;
        System.out.println("Ingrese el nombre del perro");
        String nombreB = sc.next();
        
        for(Perro p : misPerros){
            if(p.getNombre().equals(nombreB)){
                System.out.println("Nombre: " + p.getNombre());
                System.out.println("Edad: " + p.getEdad());
                System.out.println("Raza: " + p.getRaza());
                System.out.println("Puntos: " + p.getPuntos());
                System.out.println("Foto: " + p.getFoto());
                
                perroEncontrado = true;
            }
        }
        
    }
    
    public void perroGanador(){
        System.out.println("EL PERRO GANADOR FUE");
        for(int i = 0; i < misPerros.size()-1; i++){
            for(int j = i + 1; j < misPerros.size(); j++){
                Perro p1 = misPerros.get(i);
                Perro p2 = misPerros.get(j);
                if(p1.getPuntos() < p2.getPuntos()){
                    misPerros.set(i, p2);
                    misPerros.set(j, p1);
                }
            }
        }
        
        Perro mayorp = misPerros.get(0);
        System.out.println("Nombre: " + mayorp.getNombre());
        System.out.println("Con " + mayorp.getPuntos() + " Puntos");
        System.out.println("Foto: " + mayorp.getFoto());
    }
    
    public void perroMenorPuntaje(){
        System.out.println("EL PERRO CON MENOR PUNTAJE FUE");
        for(int i = 0; i < misPerros.size()-1; i++){
            for(int j = i + 1; j < misPerros.size(); j++){
                Perro p1 = misPerros.get(i);
                Perro p2 = misPerros.get(j);
                if(p1.getPuntos() > p2.getPuntos()){
                    misPerros.set(i, p2);
                    misPerros.set(j, p1);
                }
            }
        }
        
        Perro menorp = misPerros.get(0);
        System.out.println("Nombre: " + menorp.getNombre());
        System.out.println("Con " + menorp.getPuntos() + " Puntos");
        System.out.println("Foto: " + menorp.getFoto());
    }
    
    public void perroMayorEdad(){
       System.out.println("EL PERRO CON MAYOR EDAD ES");
        for(int i = 0; i < misPerros.size()-1; i++){
            for(int j = i + 1; j < misPerros.size(); j++){
                Perro p1 = misPerros.get(i);
                Perro p2 = misPerros.get(j);
                if(p1.getEdad() < p2.getEdad()){
                    misPerros.set(i, p2);
                    misPerros.set(j, p1);
                }
            }
        }
        
        Perro mayore = misPerros.get(0);
        System.out.println("Nombre: " + mayore.getNombre());
        System.out.println("Con " + mayore.getEdad() + " Años");
        System.out.println("Foto: " + mayore.getFoto());
    }
}
