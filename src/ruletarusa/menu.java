package ruletarusa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//Ruleta Rusa 2.0
//Bárbara Barreca
//Rodrigo Martinez
//Sebastián Pérez


//Ruleta rusa en la que los participantes apuntan al siguiente jugador, es decir, no se apuntan a ellos mismos.


public class menu {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(sr);
        Lista lista = new Lista();
        int opcion = 0;

        do {
            System.out.println("Ruleta Rusa");
            System.out.println("1. Iniciar juego.");
            System.out.println("2. Salir");
            System.out.print("---> ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    lista = Util.leer_archivo("Participantes.in");
                    Resultados result = new Resultados();
                    result = Ruleta.inciar(lista);

                    Util.crear_nuevo_archivo("Perdedores.out", result.perderdores); // Aquí se agregan los datos al archivo de perdedores.out

                    Util.crear_nuevo_archivo("Ganadores.out", result.ganadores);

                    System.out.println("\nEl sádico juego ha ocurrido exitosamente...");
                    System.out.println("Ingrese a los respectivos archivos para conocer al ganador y a los perdedores.");
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("Hasta pronto...");
                    break;

                default:
                    System.out.println("");
                    break;
            }

        } while (opcion != 2);

    }

}
