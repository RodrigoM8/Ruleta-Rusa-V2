package ruletarusa;

public class Ruleta {

    public static Resultados inciar(Lista lista){
        String listaperdedores = "";
        String ganadores = "";

        boolean fin = false;
        int turno = 0; // control de turnos
        int turno_porParticipante = 0;// se emplea para contar cuantos turnos van por participantes

        Nodo actual = lista.ultimo.siguiente; 
        Nodo temporal = lista.ultimo.siguiente; 
        do { 
            turno_porParticipante++; 
            boolean resultado = Revolver.disparar(actual); 
            if (resultado) {
                listaperdedores = listaperdedores + "*Nombre:  " + actual.siguiente.Nombre + "  *Apellido:  " + actual.siguiente.Apellido + "  *Edad:  " + actual.siguiente.Edad + "\n";
                if (temporal != null) { 

                    temporal.siguiente = actual.siguiente.siguiente; 
                    actual.Posicion_bala_actual = 0; 
                    lista.ultimo = temporal; 
                }

            } else {
                if (actual.Posicion_bala_actual != 0) { // validamos que el jugador no haya disparado su única bala
                    if (actual.Posicion_bala_actual == 6) {
                        actual.Posicion_bala_actual = 1;
                    } else {
                        actual.Posicion_bala_actual++; // cuando dispara y no está la bala
                    }

                }
            }
            if (turno_porParticipante == lista.total) {
                turno++;
                turno_porParticipante = 0;
            }
            int contador_balas = 0;
            Nodo auxiliar = lista.ultimo;
            do {
                contador_balas = contador_balas + auxiliar.Posicion_bala_actual;
                auxiliar = auxiliar.siguiente;
            } while (auxiliar != lista.ultimo);
            fin = contador_balas == 0;

            actual = temporal = actual.siguiente; 
        } while (!fin);
        
        Nodo auxiliar = lista.ultimo;
        
        do {

            ganadores = ganadores + "Nombre: " + auxiliar.Nombre + " " + auxiliar.Apellido + " --- Edad: " + auxiliar.Edad + " ---> Ha ganado en el turno: [ " + turno + " ]\n";
            auxiliar = auxiliar.siguiente;
        } while (auxiliar != lista.ultimo);
        Resultados result = new Resultados();
        result.ganadores = ganadores;
        result.perderdores = listaperdedores;
        return result;
    }

}
