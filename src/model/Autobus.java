package model;

public class Autobus {

    private int idAutobus;
    private String placa;
    private int idRuta;

    public Autobus() {
    }

    public Autobus(int idAutobus, String placa, int idRuta) {
        this.idAutobus = idAutobus;
        this.placa = placa;
        this.idRuta = idRuta;
    }

    public int getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(int idAutobus) {
        this.idAutobus = idAutobus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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
        sb.append("Autobus{");
        sb.append("idAutobus=").append(idAutobus);
        sb.append(", placa=").append(placa);
        sb.append(", idRuta=").append(idRuta);
        sb.append('}');
        return sb.toString();
    }

}
