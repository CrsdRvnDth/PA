package model;

public class Ruta {

    private int idRuta;
    private String nombreRuta;

    public Ruta() {
    }

    public Ruta(int idRuta, String nombreRuta) {
        this.idRuta = idRuta;
        this.nombreRuta = nombreRuta;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ruta{");
        sb.append("idRuta=").append(idRuta);
        sb.append(", nombreRuta=").append(nombreRuta);
        sb.append('}');
        return sb.toString();
    }

}
