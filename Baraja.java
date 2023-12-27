public class Baraja {
    // El array mazo es con el que vamos a jugar;
    public Carta[] mazo;
    // El array barajado es el array original con el que empezamos;
    private Carta[] barajado;
    // Con esto llevamos la cuenta de la carta que hemos usado;
    private int contador = 0;

    // En el constructor dependiendo del tipo rellenaremos las posiciones del array con las cartas que hayamos elegido
    public Baraja(int tipo){
        switch (tipo){
            case 1:
            mazo = new CartaPoker[52];
            barajado = new CartaPoker[mazo.length];

                for(int i = 0, j = 0; i < 13;i++,j++){
                    mazo[i] = new CartaPoker(j, "CORAZONES");
                }

                for(int i = 13,j = 0;i < 26;i++,j++){
                    mazo[i] = new CartaPoker(j, "DIAMANTES");
                }

                for(int i = 26,j = 0;i < 39;i++,j++){
                    mazo[i] = new CartaPoker(j, "PICAS");
                }

                for(int i = 39,j = 0 ;i < 52; i++,j++){
                    mazo[i] = new CartaPoker(j, "TREBOLES");
                }
            // Al construirla usaremos el metodo barajar para desordenar el array
            Barajar();
            break;

            case 2:
            mazo = new CartaEspanola[40];
            barajado = new CartaEspanola[mazo.length];

                for(int i = 0, j = 0; i < 10;i++,j++){
                    mazo[i] = new CartaEspanola(j, "OROS");
                }

                for(int i = 10,j = 0;i < 20;i++,j++){
                    mazo[i] = new CartaEspanola(j, "COPAS");
                }

                for(int i = 20,j = 0;i < 30;i++,j++){
                    mazo[i] = new CartaEspanola(j, "ESPADAS");
                }

                for(int i = 30,j = 0 ;i < 40; i++,j++){
                    mazo[i] = new CartaEspanola(j, "BASTOS");
                }
            Barajar();
                break;

            case 3:
            mazo = new CartaAlemana[36];
            barajado = new CartaAlemana[mazo.length];

                for(int i = 0, j = 0; i < 9;i++,j++){
                    mazo[i] = new CartaAlemana(j, "CAMPANAS");
                }

                for(int i = 9,j = 0;i < 18;i++,j++){
                    mazo[i] = new CartaAlemana(j, "PASTOS");
                }

                for(int i = 18,j = 0;i < 27;i++,j++){
                    mazo[i] = new CartaAlemana(j, "CORAZONES");
                }

                for(int i = 27,j = 0 ;i < 36; i++,j++){
                    mazo[i] = new CartaAlemana(j, "BELLOTAS");
                }
                Barajar();
            break;
        }
    }

    private void Barajar(){
        int i = 0;

        // Desordenamos el array
        do{
            int random = (int) (Math.random() * mazo.length);

            // Lo que hace este metodo es coger una posicion random del array constructor y meterla a cada posicion del array barajado
            // una vez hecho borraremos del array constructor la carta, asegurandonos asi de que jamas se vuelva a repetir
            if(mazo[random] != null) {
                barajado[i] = mazo[random];
                mazo[random] = null;
                i++;
            }

        } while(i < mazo.length);

        // Como dije antes, jugaremos con el array mazo asi que lo volvemos a llenar
        for(int k = 0; k < mazo.length; k++){
            mazo[k] = barajado[k];
        }
    }

    public String siguiente(){
        String carta = "";
        int i = 1;

        // Ocurre que como esta hecho este programa el ordenador ha podido coger la posicion siguiente del jugador por lo que si detectamos
        // que despues de la posicion jugada es NULL, pasaremos a la siguiente y pondremos el contador donde este el jugador en ese momento
        // y claro dejaremos a null esta carta ya que no la usaremos mas
        for(i = contador; i < mazo.length;i++){
            if(mazo[i] != null){
                contador = i;
                carta += "PALO: " + mazo[i].getPalo() + "     VALOR: " + mazo[i].getValor();
                mazo[i] = null;
                i = mazo.length + 1;
            }
        }
        return carta;
    }

    // Reiniciaremos el juego, tanto el contador como el array mazo;
    public void reiniciar(){
        contador = 0;
        for(int i = 0; i < mazo.length; i++){
            mazo[i] = barajado[i];
        }
    }

    // Nos devuelve la cantidad de cartas que tenemos
    public int numCartas(){
        int numero = 0;

        for(int i = 0; i < mazo.length;i++){
            if (mazo[i] != null) numero++;
        }

        return numero;
    }

    // Podremos ver las cartas que quedan en la baraja
    public Carta[] getBaraja(){
        Carta[] barajaRestante = new Carta[numCartas()];

        for (int i = 0 ,j = contador; i < numCartas(); i++, j++){
            barajaRestante[i] = mazo[j];
        }

        return barajaRestante;
    }

    // Por como esta hecho el juego, hay posibildad de que cuando le pidamos el contador sea nulo, asi que lo meto una direccion para delante
    public int getContador(){
        if (contador > mazo.length || mazo[contador] == null) {
            for(int i = contador; i < mazo.length;i++){
                if(mazo[i] != null){
                    contador = i;
                    i = mazo.length + 10;
                }
            }
        }
        return contador;
    }

    // Pasa a String todo el array de cartas
    public String toString(){
        String lista = " ";
        Carta[] listaCartas = getBaraja();

            for(int i = 0; i < numCartas(); i++){    
                if(mazo[i] != null) lista += "PALO: " + listaCartas[i].getPalo() + "     VALOR: " + listaCartas[i].getValor() + "\n";
            }

        return lista;
    }

}