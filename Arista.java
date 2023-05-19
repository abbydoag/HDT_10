public class Arista implements iArista {

    private String ciudadDestino;
    private int tiempoNormal;
    private int tiempoNieve;
    private int tiempoLluvia;
    private int tiempoTormenta;

    public Arista(String ciudadDestino, int tiempoNormal, int tiempoLluvia, int tiempoNieve, int tiempoTormenta) {
        this.ciudadDestino = ciudadDestino;
        this.tiempoNormal = tiempoNormal;
        this.tiempoLluvia = tiempoLluvia;
        this.tiempoNieve = tiempoNieve;
        this.tiempoTormenta = tiempoTormenta;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public int getTiempoNormal() {
        return tiempoNormal;
    }

    public void setTiempoNormal(int tiempoNormal) {
        this.tiempoNormal = tiempoNormal;
    }

    public int getTiempoLluvia() {
        return tiempoLluvia;
    }

    public void setTiempoLluvia(int tiempoLluvia) {
        this.tiempoLluvia = tiempoLluvia;
    }

    public int getTiempoNieve() {
        return tiempoNieve;
    }

    public void setTiempoNieve(int tiempoNieve) {
        this.tiempoNieve = tiempoNieve;
    }

    public int getTiempoTormenta() {
        return tiempoTormenta;
    }

    public void setTiempoTormenta(int tiempoTormenta) {
        this.tiempoTormenta = tiempoTormenta;
    }
    
}
