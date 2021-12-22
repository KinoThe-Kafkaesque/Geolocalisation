
import java.sql.SQLException;
import java.sql.Statement;

import connexion.Connexion;

public class Application {

    public static void main(String[] args) {

        String createTableUser = "create table User (" + "id int primary key auto_increment,"
                + "username varchar(128) unique , password varchar(4000) ,secret varchar(128)) ;";
        String createTableTracker = "create table GPSTracker (" + "id int primary key auto_increment,"
                + "simNumber varchar(20));";

        String createTablePosition = "create table Position (" + "id int primary key auto_increment,"
                + "latitude double," + "longitude double," + "date Date," + "idgpsTracker int);";

        String fk = "alter table Position add constraint fk " + "foreign key(idgpsTracker) references GPSTracker(id);";

        String createTableVehicule = "create table Vehicule (" + "id int primary ke,y auto_increment,"
                + "matricule varchar(20) ," + "marque varchar(20)  ," + "type varchar(20) )";

        String createTableVehiculeGpstracker = "create table VehiculeGPSTracker ("
                + "id int primary key auto_increment," + "id_vehicule int ," + " id_gpsTracker int ,"
                + "dateDebut Date," + "dateFin date);";

        String fk1 = "alter table VehiculeGPSTracker add constraint fk1 "
                + "foreign key(id_vehicule) references Vehicule(id) on delete cascade;";

        String fk2 = "alter table VehiculeGPSTracker add constraint fk2 "
                + "foreign key(id_gpsTracker) references GPSTracker(id) on delete cascade ;";

        // String pkv = "alter table VehiculeGPSTracker add constraint pkv " + " primary
        // key (id_vehicule , id_gpsTracker)";
        try {
            Statement st = Connexion.getConnection().createStatement();
//            st.executeUpdate("drop table if exists Position;");
//            st.executeUpdate("drop table if exists VehiculeGPSTracker;");
//            st.executeUpdate("drop table if exists GPSTracker;");
//            st.executeUpdate("drop table if exists Vehicule;");
//            st.executeUpdate(createTableTracker);
//            st.executeUpdate(createTablePosition);
//            st.executeUpdate(createTableVehicule);
//            st.executeUpdate(createTableVehiculeGpstracker);
//            st.executeUpdate(fk);
//            st.executeUpdate(fk1);
//            st.executeUpdate(fk2);
            st.executeUpdate("drop table if exists User;");
            st.executeUpdate(createTableUser);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL erreur");
        }

    }
}
