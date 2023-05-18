public class Arista implements iArista {

    private String ciudadDestino;
    private int tiempoNormal;
    private int tiempoNieve;
    private int tiempoLluvia;
    private int tiempoTormenta;
    public void Arista(String ciudadDestino, int tiempoNormal, int tiempoLluvia, int tiempoNieve, int tiempoTormenta) {
        this.ciudadDestino = ciudadDestino;
        this.tiempoNormal = tiempoNormal;
        this.tiempoNieve = tiempoNieve;
        this.tiempoLluvia = tiempoLluvia; 
        this.tiempoTormenta = tiempoTormenta; 
    }

    @Override
    public String getCiudadDestino() {
        return ciudadDestino;
    }

    @Override
    public int getTiempoNormal() {
        return tiempoNormal;
    }

    @Override
    public int getTiempoLluvia() {
        return tiempoLluvia;
       
    }

    @Override
    public int getTiempoNieve() {
        return tiempoNieve;
    }

   
    public int getTiempoTormenta() {
        return tiempoTormenta;
    }
    
}
