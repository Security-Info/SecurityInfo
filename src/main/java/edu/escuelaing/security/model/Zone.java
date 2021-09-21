package edu.escuelaing.security.model;

import edu.escuelaing.security.dto.ZoneDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Zone {
    @Id
    private String id;
    private double latitud;
    private double longitud;
    private double latArribaIzquierda;
    private double longArribaIzquierda;

    private double latitudArribaDerecha;
    private double longitudArribaDerecha;

    private double latAbajoIzquierda;
    private double longAbajoIzquierda;

    private double latAbajoDerecha;
    private double longAbajoDerecha;


    public Zone(ZoneDto zoneDto) {

        latitud = zoneDto.getLatitud();
        longitud = zoneDto.getLongitud();

        calculate(latitud,longitud);

    }

    private void calculate(double latitud, double longitud){
        latArribaIzquierda = latitud + 0.00359253867;
        longArribaIzquierda = longitud - 0.00399112675;

        latitudArribaDerecha = latitud + 0.00342146583;
        longitudArribaDerecha = longitud + 0.00351905799;


        latAbajoIzquierda = latitud - 0.00402024401;
        longAbajoIzquierda = longitud - 0.00403404209;

        latAbajoDerecha = latitud - 0.00380640065;
        longAbajoDerecha = longitud + 0.00360488868;




    }

    public boolean verifyStoleZone(double checkLat, double checkLong){
        boolean resultadoLatitud = false;
        boolean resultadoLongitud = true;
        if(checkLat < latArribaIzquierda && checkLat < latitudArribaDerecha
                && checkLat > latAbajoIzquierda && checkLat > latAbajoDerecha){
            resultadoLatitud = true;

        }else{
            resultadoLatitud = false;
        }

        if(checkLong > longArribaIzquierda && checkLong > longAbajoIzquierda
                && checkLong < longitudArribaDerecha && checkLong < longAbajoDerecha){
            resultadoLongitud = true;

        }else{
            resultadoLongitud = false;

        }
        if(resultadoLatitud == true && resultadoLongitud==true){
            return true;
        }else{
            return false;
        }
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getLatArribaIzquierda() {
        return latArribaIzquierda;
    }

    public double getLongArribaIzquierda() {
        return longArribaIzquierda;
    }

    public double getLatitudArribaDerecha() {
        return latitudArribaDerecha;
    }

    public double getLongitudArribaDerecha() {
        return longitudArribaDerecha;
    }

    public double getLatAbajoIzquierda() {
        return latAbajoIzquierda;
    }

    public double getLongAbajoIzquierda() {
        return longAbajoIzquierda;
    }

    public double getLatAbajoDerecha() {
        return latAbajoDerecha;
    }

    public double getLongAbajoDerecha() {
        return longAbajoDerecha;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setLatArribaIzquierda(double latArribaIzquierda) {
        this.latArribaIzquierda = latArribaIzquierda;
    }

    public void setLongArribaIzquierda(double longArribaIzquierda) {
        this.longArribaIzquierda = longArribaIzquierda;
    }

    public void setLatitudArribaDerecha(double latitudArribaDerecha) {
        this.latitudArribaDerecha = latitudArribaDerecha;
    }

    public void setLongitudArribaDerecha(double longitudArribaDerecha) {
        this.longitudArribaDerecha = longitudArribaDerecha;
    }

    public void setLatAbajoIzquierda(double latAbajoIzquierda) {
        this.latAbajoIzquierda = latAbajoIzquierda;
    }

    public void setLongAbajoIzquierda(double longAbajoIzquierda) {
        this.longAbajoIzquierda = longAbajoIzquierda;
    }

    public void setLatAbajoDerecha(double latAbajoDerecha) {
        this.latAbajoDerecha = latAbajoDerecha;
    }

    public void setLongAbajoDerecha(double longAbajoDerecha) {
        this.longAbajoDerecha = longAbajoDerecha;
    }
}
