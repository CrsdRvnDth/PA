package model;

public class Parada {

    private int numeroParada;
    private String ubicacion;
    private String hora;
    private int idRuta;

    public Parada() {
    }

    public Parada(int numeroParada, String ubicacion, String hora, int idRuta) {
        this.numeroParada = numeroParada;
        this.ubicacion = ubicacion;
        this.hora = hora;
        this.idRuta = idRuta;
    }

    public int getNumeroParada() {
        return numeroParada;
    }

    public void setNumeroParada(int numeroParada) {
        this.numeroParada = numeroParada;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parada{");
        sb.append("numeroParada=").append(numeroParada);
        sb.append(", ubicacion=").append(ubicacion);
        sb.append(", hora=").append(hora);
        sb.append(", idRuta=").append(idRuta);
        sb.append('}');
        return sb.toString();
    }

}
