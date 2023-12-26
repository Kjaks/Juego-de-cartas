public class Carta{
    protected int valor;
    protected String palo;

    public Carta(int valor,String palo){
        this.valor = valor;
        this.palo = palo;
    }

    public int getValor(){
        return this.valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public String getPalo(){
        return this.palo;
    }

    public void setPalo(String palo){
        this.palo = palo;
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
}