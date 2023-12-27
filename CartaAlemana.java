class CartaAlemana extends Carta {
    // Ponemos una jerarquia de que palo gana a cual en el caso de que tenga el mismo valor.
    private String[] jerarquia = {"BELLOTAS", "HOJAS", "CORAZONES", "CAMPANAS"};

    public CartaAlemana(int valor, String palo) {
        super(valor, palo);
    }

    @Override
    public Boolean mayorQue(Carta carta){
        Boolean respuesta = false;

        // Si el valor de nuestra carta es mayor que la del ordenador sale verdadero;
        if(this.valor > carta.getValor()){
            respuesta = true;
        }

        // Si el palo de la carta no es igual y el valor es igual haremos la comprobacion para ver quien gana
        // ya que dependiendo de la jerarquia ganaremos o no;
        else if(super.compararPalo(carta) == false && this.valor == carta.getValor()){
            int ganador_ordenador = 0;
            int ganador_humano = 0;

                for (int i = 0; i < jerarquia.length; i++){
                    if (jerarquia[i].equals(carta.getPalo())){
                        ganador_ordenador = i;
                    }

                    if (jerarquia[i].equals(this.palo)){
                        ganador_humano = i;
                    }
                }
            
            if (ganador_humano > ganador_ordenador){
                respuesta = true;
            }
            
        }     
        return respuesta;
    }
}