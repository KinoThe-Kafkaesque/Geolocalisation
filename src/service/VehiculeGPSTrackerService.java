package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import connexion.Connexion;
import dao.IVehiculeGPSTrackerDAO;
import entities.GPSTracker;
import entities.Position;
import entities.Vehicule;
import entities.VehiculeGPSTracker;
import java.util.LinkedHashSet;
import java.util.Set;


public class VehiculeGPSTrackerService implements IVehiculeGPSTrackerDAO<VehiculeGPSTracker> {

    private VehiculeService vs = new VehiculeService();
    private GPSTrackerService gs = new GPSTrackerService();
    private PositionService ps = new PositionService();

   

    @Override
    public boolean create(VehiculeGPSTracker o) {
        try {

            String req = "insert into VehiculeGPSTracker values (null,?, ?,?,null)";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, o.getVehicule().getId());
            pr.setInt(2, o.getGpsTracker().getId());
            pr.setDate(3, new Date(new java.util.Date().getTime()));
            fin(o);

            if (pr.executeUpdate() == 1) {
                o.getVehicule().setVehiculeGPSTracker(o);
                o.getGpsTracker().setVehiculeGPSTracker(o);
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Create : Erreur");
        }
        return false;
    }

    @Override
    public boolean fin(VehiculeGPSTracker o) {
        try {
            String req = "update VehiculeGPSTracker set dateFin = ? where id_gpsTracker = ? or id_vehicule = ? and dateFin is  NULL ";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setDate(1, new Date(new java.util.Date().getTime()));
            pr.setInt(2, o.getGpsTracker().getId());
            pr.setInt(3, o.getVehicule().getId());
            if (pr.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("fin : Erreur");
        }
        return false;
    }

    public VehiculeGPSTracker findById(int id) {
        try {
            String req = "select * from VehiculeGPSTracker where id  = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new VehiculeGPSTracker(rs.getInt("id"), vs.findById(rs.getInt("id_vehicule")), gs.findById(rs.getInt("id_gpsTracker")),
                        rs.getDate("dateDebut"), rs.getDate("dateFin"));
            }

        } catch (SQLException e) {
            System.out.println("Position : FindById");
        }

        return null;
    }

    @Override
    public List<VehiculeGPSTracker> findByVehicule(int id) {

        List<VehiculeGPSTracker> vehiculeGPSTrackers = new ArrayList<VehiculeGPSTracker>();
        try {
            String req = "select * from VehiculeGPSTracker where id_vehicule = ? ";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                vehiculeGPSTrackers.add(new VehiculeGPSTracker(rs.getInt("id"), vs.findById(rs.getInt("id_vehicule")),
                        gs.findById(rs.getInt("id_gpsTracker")), rs.getDate("dateDebut"), rs.getDate("dateFin")));
            }

        } catch (SQLException e) {
            System.out.println("Tracker : findAll");
        }
        return vehiculeGPSTrackers;
    }

    @Override
    public List<VehiculeGPSTracker> findByTracker(int id) {

        List<VehiculeGPSTracker> vehiculeGPSTrackers = new ArrayList<VehiculeGPSTracker>();
        try {
            String req = "select * from VehiculeGPSTracker where id_gpsTracker = ? ";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                vehiculeGPSTrackers.add(new VehiculeGPSTracker(rs.getInt("id"), vs.findById(rs.getInt("id_vehicule")),
                        gs.findById(rs.getInt("id_gpsTracker")), rs.getDate("dateDebut"), rs.getDate("dateFin")));
            }

        } catch (SQLException e) {
            System.out.println("Tracker : findAll");
        }
        return vehiculeGPSTrackers;
    }

    @Override
    public List<VehiculeGPSTracker> findAll() {

        List<VehiculeGPSTracker> vehiculeGPSTrackers = new ArrayList<VehiculeGPSTracker>();
        try {
            String req = "select * from VehiculeGPSTracker";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);

            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                vehiculeGPSTrackers.add(new VehiculeGPSTracker(rs.getInt("id"), vs.findById(rs.getInt("id_vehicule")),
                        gs.findById(rs.getInt("id_gpsTracker")), rs.getDate("dateDebut"), rs.getDate("dateFin")));
            }

        } catch (SQLException e) {
            System.out.println("Tracker : findAll");
        }
        return vehiculeGPSTrackers;
    }

    public Set<Position> findVehiculeBetweenDates(Vehicule vehicule, java.util.Date dateDebut, java.util.Date dateFin) {
        if (dateDebut.before(dateFin)) {
           Set<Position> set = new LinkedHashSet<>();
            for (VehiculeGPSTracker vg : findAll()) {
                if (vg.getVehicule().getId() == vehicule.getId()) {
//				if ((vgs.getDateDebut().before(dateDebut) && vgs.getDateFin().after(dateFin))||
//						(vgs.getDateDebut().after(dateDebut) && vgs.getDateFin().before(dateDebut))||
//							(vgs.getDateDebut().before(dateDebut) && vgs.getDateFin().before(dateFin) 
//									&& vgs.getDateFin().after(dateDebut))||
//								(vgs.getDateDebut().after(dateDebut) && vgs.getDateFin().after(dateFin) && 
//										vgs.getDateDebut().before(dateFin))) {

                    if (vg.getDateFin() != null) {
                        
               
if (vg.getDateDebut().before(dateFin)   &&     vg.getDateFin().after(dateDebut)) {
                        for(Position p : ps.findGpsBetweenDates(vg.getGpsTracker(), dateDebut, dateFin))
                            set.add(p);
                       
               }
else if (vg.getDateDebut().before(dateFin)  ) {
     for(Position p : ps.findGpsBetweenDates(vg.getGpsTracker(), dateDebut, dateFin))
                            set.add(p);
                       
               }
                            
                        }
                }
                }
          
       
            return set;
        } else {
            return null;
        }
    }

    @Override
    public void refresh() {

        for (Vehicule v : vs.findAll()) {
            for (VehiculeGPSTracker vg : findByVehicule(v.getId())) {
                if (vg.getDateFin() == null) {
                    v.setVehiculeGPSTracker(vg);
                }
            }
        }
        for (GPSTracker t : gs.findAll()) {
            for (VehiculeGPSTracker vg : findByTracker(t.getId())) {
                if (vg.getDateFin() == null) {
                    t.setVehiculeGPSTracker(vg);
                }
            }
        }

    }

}
