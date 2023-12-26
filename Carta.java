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
}