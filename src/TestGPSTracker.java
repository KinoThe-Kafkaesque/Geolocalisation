
import com.google.common.hash.Hashing;
import java.util.Date;

import entities.GPSTracker;
import entities.Position;
import entities.Vehicule;
import entities.VehiculeGPSTracker;
import java.nio.charset.StandardCharsets;
import service.GPSTrackerService;
import service.PositionService;
import service.VehiculeGPSTrackerService;
import service.VehiculeService;

public class TestGPSTracker {

	public static void main(String[] args) {
//		GPSTrackerService gs = new GPSTrackerService();
//		gs.create(new GPSTracker("145"));
//		gs.create(new GPSTracker("185"));
//		gs.create(new GPSTracker("189"));
//		gs.create(new GPSTracker("123"));
//		
////		gs.delete(gs.findById(2));
//		
//		PositionService ps = new PositionService();
//		VehiculeService vs = new VehiculeService();
//		VehiculeGPSTrackerService vgs = new VehiculeGPSTrackerService();
//		ps.create(new Position(159,189,new Date(),gs.findById(2)));
//		vs.create(new Vehicule("ZTE512", "Fusion", "voiyutre"));
//		vgs.create(new VehiculeGPSTracker( new Date(), vs.findById(1), gs.findById(2)));
////		vs.delete(vs.findById(1));
	           System.out.println(Hashing.sha256().hashString("1234", StandardCharsets.UTF_8).toString());
        
	}
	
	
}
