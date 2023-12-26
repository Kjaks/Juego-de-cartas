class CartaEspanola extends Carta {

    public CartaEspanola(int valor, String palo) {
        super(valor, palo);
    }

    public String toString(){
        return "Palo: " + this.palo + "\nValor: " + this.valor; 
    }

    public boolean equals(Carta carta){
        if(this.palo.equals(carta.getPalo()) && this.valor == carta.getValor()){
            return true;
        }
        else return false;        
    }

    public Carta clone(){
        return new Carta(this.valor, this.palo);
    }

    public Boolean compararNumero(Carta carta){
        if(carta.getValor() == this.valor){
            return true;
        } 
        else return false;
    }

    public Boolean compararPalo(Carta carta){
        if(this.palo.equals(carta.getPalo())){
            return true;
        } 
        else return false;
    }

    public Boolean mayorQue(Carta carta){
        if(this.valor > carta.getValor()){
            return true;
        }
        else return false;
    }
}
