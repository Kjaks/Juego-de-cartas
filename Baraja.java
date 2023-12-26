public class Baraja {
    private int tipo;
    Carta[] mazo;

    public Baraja(int tipo){
        this.tipo = tipo;

            if(this.tipo == 1){
            mazo = new Carta[52];

            for(int i = 0, j = 0; i < 13;i++,j++){
                mazo[i] = new Carta(j, "corazones");
            }

            for(int i = 13,j = 0;i < 26;i++,j++){
                mazo[i] = new Carta(j, "diamantes");
            }

            for(int i = 26,j = 0;i < 39;i++,j++){
                mazo[i] = new Carta(j, "picas");
            }

            for(int i = 39,j = 0 ;i < 52; i++,j++){
                mazo[i] = new Carta(j, "treboles");
            }
        }
    }

    public String getMazo(){

        String mazolista = "";
        for(int i = 0;i < mazo.length;i++){
            mazolista += "Palo: " + mazo[i].getPalo() + "  Valor: " + mazo[i].getValor() + "\n";
        }

        return mazolista;
    }
}
