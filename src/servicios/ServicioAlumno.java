/*
 3. Crear una clase llamada Alumno que mantenga información sobre las notas de
distintos alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de
tipo Integer con sus 3 notas.
En el main deberemos tener un bucle que crea un objeto Alumno. Se pide toda la
información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bluce tendremos el siguiente método en la clase Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su
nota final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método.
Dentro del método se usará la lista notas para calcular el promedio final de alumno.
Siendo este promedio final, devuelto por el método y mostrado en el main.
 */
package servicios;

import entidades.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Julieta Sanchez
 */
public class ServicioAlumno {
    Scanner scan = new Scanner(System.in);
    //creo Lista para guardar a los alumnos
    ArrayList<Alumno> chicos = new ArrayList();
    
    /**
     * 
     * @return metodo para crear alumno. Retorno objeto alumno con nombre y notas
     */
    
    public Alumno crearAlumno(){
        //creo Lista auxiliar para ingresar las notas de los alumnos 
    ArrayList<Integer> notasAux = new ArrayList();
        System.out.println("Ingrese el nombre del alumno: ");
        String nombre = scan.next();
        System.out.println("Ingrese la primer nota del alumno: ");
        int nota1 = scan.nextInt();
        System.out.println("Ingrese la segunda nota del alumno: ");
        int nota2 = scan.nextInt();
        System.out.println("Ingrese la tercer nota del alumno: ");
        int nota3 = scan.nextInt();
        notasAux.add(nota1);
        notasAux.add(nota2);
        notasAux.add(nota3);
        Alumno a = new Alumno();
        a.setNombre(nombre);
        a.setNotas(notasAux);
        return a;
    }
    
    public void agregarLista(){
        chicos.add(crearAlumno());
    }
    public int notaFinal(){
        int notaPromedio = 0;
        System.out.println("Ingrese el nombre del alumno a evaluar: ");
        String nombreAlumno = scan.next();
        for (int i = 0; i < chicos.size(); i++) {
            if (nombreAlumno.equalsIgnoreCase(chicos.get(i).getNombre())) {
                for (int j = 0; j < chicos.get(i).getNotas().size() ; j++) {
                 notaPromedio += chicos.get(i).getNotas().get(j);
               
                }
             
            }

        }
        return notaPromedio/3;
    }
    public void menu(){
        
        int op;
        String op1= "a";
        do {
        System.out.println("MENU:\n" + "Opción 1: Ingresar alumno\n" + "Opción 2: Salir \n" );
        System.out.println("Ingrese la opción");
        op = scan.nextInt();
            switch (op){
                case 1:
                    agregarLista();
                    break;
                case 2:
                    System.out.println("¿Usted esta seguro que desea salir? s/n");
                    op1 = scan.next();
                    break;
                default:
                    System.out.println("Ingrese una opción correcta.");;
            }
            
        } while (op!=2 | !"s".equalsIgnoreCase(op1));
    }
        
        
    
    
        
    }
    
    

