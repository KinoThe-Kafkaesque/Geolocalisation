package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.GPSTracker;
import entities.VehiculeGPSTracker;
import java.util.Date;

public class GPSTrackerService implements IDao<GPSTracker> {

    @Override
    public boolean create(GPSTracker o) {
        try {
            String req = "insert into GPSTracker values (null, ?)";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, o.getSimNulmber());
            if (pr.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Create : Erreur");
        }
        return false;
    }

    @Override
    public boolean delete(GPSTracker o) {
        try {
            String req = "delete from  GPSTracker where id  = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, o.getId());
            // String req1 = "update VehiculeGPSTracker set dateFin = ? id_vehicule = ? and
            // dateFin is NULL";
            String req1 = "update VehiculeGPSTracker set dateFin = ? where  id_vehicule = ?  and dateFin is NULL ";
            PreparedStatement pr1 = Connexion.getConnection().prepareStatement(req1);
            // pr1.setDate(1, new Date(new java.util.Date().getTime()));
            pr1.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pr1.setInt(2, o.getId());
            pr1.executeUpdate();
            if (pr.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean update(GPSTracker o) {
        try {
            String req = "update GPSTracker set simNumber = ? where id = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, o.getSimNulmber());
            pr.setInt(2, o.getId());
            if (pr.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Create : Erreur");
        }
        return false;

    }

    @Override
    public GPSTracker findById(int id) {
        try {
            String req = "select * from GPSTracker where id  = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new GPSTracker(rs.getInt("id"), rs.getString("simNumber"));
            }

        } catch (SQLException e) {
            System.out.println("Tracker : FindById");
        }

        return null;
    }

    @Override
    public List<GPSTracker> findAll() {
        List<GPSTracker> gpsTrackers = new ArrayList<GPSTracker>();
        try {
            String req = "select * from GPSTracker";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);

            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                gpsTrackers.add(new GPSTracker(rs.getInt("id"), rs.getString("simNumber")));
            }

        } catch (SQLException e) {
            System.out.println("Tracker : findAll");
        }

        return gpsTrackers;
    }

}
