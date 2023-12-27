import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int respuesta;
        int puntuacionJugador = 0;
        int eleccionordenador;

        System.out.println("Hola bienvenido ! Vamos a jugar a las cartas, el juego, es sencillo sois dos jugadores, uno saca una carta y otro otra! La que sea mayor gana!");
        
        System.out.println("\nQue ocurre si sacas un valor igual pero de otro palo? Sencillo! Hay jerarquias! Hay cartas mas poderosas que otras elige un tipo de carta y te explico!");
        
        System.out.println("Elige la baraja con la que quieres jugar! \n     1. Baraja de poker\n     2. Baraja española\n     3. Baraja alemana");

        do{

            respuesta = sc.nextInt();
            if(respuesta < 1 || respuesta > 3) System.out.println("Error! Un numero del 1 al 3!");

        } while(respuesta < 1 || respuesta > 3);
        
        // Llamaremos al constructor para crear una baraja
        Baraja baraja = new Baraja(respuesta);
        
        // Esto sirve para ver las jerarquias, ya que si nuestra carta es del mismo valor para saber si ganamos o no debemos ver que palo es mas fuerte
        switch (respuesta){
            case 1:
                System.out.println("JERAQUIA DE MENOR A MAYOR :\n\n      TREBOLES \n\n      DIAMANTES \n\n      CORAZONES \n\n      PICAS");
            break;
            case 2:
                System.out.println("JERAQUIA DE MENOR A MAYOR :\n\n      OROS \n\n      COPAS \n\n      ESPADAS \n\n      BASTOS");
            break;
            case 3:
                System.out.println("JERAQUIA DE MENOR A MAYOR :\n\n      OROS \n\n      COPAS \n\n      ESPADAS \n\n      BASTOS");
            break;
        }
        
        do {
        Boolean ganador = false;

        // Si hay 0 cartas disponibles significa que no podemos seguir jugando y solo tenemos dos opciones reiniciar o salir
        if(baraja.numCartas() == 0){
            System.out.println("No hay mas cartas en la baraja! Si quieres seguir jugando vas a tener que reiniciar la baraja!");
            System.out.println("¿Quieres jugar otra vez? \n 0. Salir \n 1. Jugar de nuevo");
            respuesta = sc.nextInt();
            puntuacionJugador = 0;
            baraja.reiniciar();
            }
        else {
        
        // La eleccion de la carta del contrincante lo haremos con un random el cual usara la posicion que no sea null y no coja nuestra posicion
        do{
            eleccionordenador = (int)(Math.random() * baraja.mazo.length);
        } while (baraja.mazo[eleccionordenador] == null || eleccionordenador <= baraja.getContador());

        System.out.println("\nQuedan " + baraja.numCartas() + "/" + baraja.mazo.length + " cartas!");

        // Con el metodo mayorQue nos aseguramos de que el jugador gane, si este gana se le sumara uno a la puntuacion
        if (baraja.mazo[baraja.getContador()].mayorQue(baraja.mazo[eleccionordenador])) {
            puntuacionJugador++;
            ganador = true;
        }  

        System.out.println("\n     Tu carta es! \n\n" + baraja.siguiente());

        System.out.println("\n   La carta del contrario es! \n\n" + "PALO: " + baraja.mazo[eleccionordenador].getPalo() + "     VALOR: " + baraja.mazo[eleccionordenador].getValor());
        
        if (ganador) System.out.println("\nEnhorabuena has ganado! Tienes " + puntuacionJugador + " puntos");
        else System.out.println("\nNo ganaste nada!");

        // La carta que ha elegido el ordenador se borrara para que no vuelva a aparecer
        baraja.mazo[eleccionordenador] = null;

        // El programa nos preguntara si queremos seguir jugando
        do{
        System.out.println("¿Quieres seguir jugando o quieres salir del juego? \n 0. Salir \n 1. Seguir");
            respuesta = sc.nextInt();
        } while(respuesta < 0 || respuesta > 1);

        }
        } while(respuesta != 0);
        
    }
}
