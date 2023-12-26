public class Baraja {
    Carta[] mazo;

    public Baraja(int tipo){
        switch (tipo){
            case 1:
            mazo = new Carta[52];

                for(int i = 0, j = 0; i < 13;i++,j++){
                    mazo[i] = new Carta(j, "CORAZONES");
                }

                for(int i = 13,j = 0;i < 26;i++,j++){
                    mazo[i] = new Carta(j, "DIAMANTES");
                }

                for(int i = 26,j = 0;i < 39;i++,j++){
                    mazo[i] = new Carta(j, "PICAS");
                }

                for(int i = 39,j = 0 ;i < 52; i++,j++){
                    mazo[i] = new Carta(j, "TREBOLES");
                }

            Barajar();
            break;

            case 2:
            mazo = new Carta[40];

                for(int i = 0, j = 0; i < 10;i++,j++){
                    mazo[i] = new Carta(j, "OROS");
                }

                for(int i = 10,j = 0;i < 20;i++,j++){
                    mazo[i] = new Carta(j, "COPAS");
                }

                for(int i = 20,j = 0;i < 30;i++,j++){
                    mazo[i] = new Carta(j, "ESPADAS");
                }

                for(int i = 30,j = 0 ;i < 40; i++,j++){
                    mazo[i] = new Carta(j, "BASTOS");
                }
            Barajar();
                break;

            case 3:
            mazo = new Carta[36];

                for(int i = 0, j = 0; i < 9;i++,j++){
                    mazo[i] = new Carta(j, "CAMPANAS");
                }

                for(int i = 9,j = 0;i < 18;i++,j++){
                    mazo[i] = new Carta(j, "PASTOS");
                }

                for(int i = 18,j = 0;i < 27;i++,j++){
                    mazo[i] = new Carta(j, "CORAZONES");
                }

                for(int i = 27,j = 0 ;i < 36; i++,j++){
                    mazo[i] = new Carta(j, "BELLOTAS");
                }
                Barajar();
            break;
        }
    }

    private void Barajar(){
        // En este array de cartas guardaremos el array desordenado;
        Carta[] Barajado = new Carta[mazo.length];
        int i = 0;

        // Desordenamos el array
        do{
            int random = (int) (Math.random() * mazo.length);

            // Lo que haremos sera coger una posicion cualquiera del array de cartas y rellenaremos cada posicion de la baraja
            // cuando rellenemos esta posicion dejamos la posicion del otro array en null, asi asegurandonos de que jamas
            // se repita, si el array random no es null rellenamos la baraja y seguimos a la siguiente posicion.
            if(mazo[random] != null) {
                Barajado[i] = mazo[random];
                mazo[random] = null;
                i++;
            }

        } while(i < mazo.length);

        for(int k = 0; k < mazo.length; k++){
            mazo[k] = Barajado[k];
        }
    }

    public String getMazo(){
        String lista = " ";

        for(int i = 0; i < mazo.length; i++){
            lista += "PALO: " + mazo[i].getPalo() + "     VALOR: " + mazo[i].getValor() + "\n";
        }

        return lista;
    }

    
}