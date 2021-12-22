package entities;

import java.util.Date;

public class VehiculeGPSTracker {

    private int id;

    private Date dateDebut;

    private Date dateFin;

    private Vehicule vehicule;

    private GPSTracker gpsTracker;

    public VehiculeGPSTracker(int id, Vehicule vehicule, GPSTracker gpsTracker, Date dateDebut, Date dateFin) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.vehicule = vehicule;
        this.gpsTracker = gpsTracker;
    }

    public VehiculeGPSTracker(int id, Date dateDebut, Vehicule vehicule, GPSTracker gpsTracker) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.vehicule = vehicule;
        this.gpsTracker = gpsTracker;
    }

    public VehiculeGPSTracker(Vehicule vehicule, GPSTracker gpsTracker, Date dateDebut, Date dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.vehicule = vehicule;
        this.gpsTracker = gpsTracker;
    }

    public VehiculeGPSTracker(Date dateDebut, Vehicule vehicule, GPSTracker gpsTracker) {
        this.dateDebut = dateDebut;
        this.vehicule = vehicule;
        this.gpsTracker = gpsTracker;
    }

    public int getId() {
        return id;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public GPSTracker getGpsTracker() {
        return gpsTracker;
    }

    public void setGpsTracker(GPSTracker gpsTracker) {
        this.gpsTracker = gpsTracker;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "VehiculeGPSTracker [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", vehicule=" + vehicule.getId()
                + ", gpsTracker=" + gpsTracker.getId() + "]";
    }

}
