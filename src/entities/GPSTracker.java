package entities;

public class GPSTracker {
	private int id;
	private String simNulmber;
	private VehiculeGPSTracker vehiculeGPSTracker;

	public GPSTracker(String simNulmber) {

		this.simNulmber = simNulmber;
		this.vehiculeGPSTracker = new VehiculeGPSTracker(null, null, null, null);

	}

	public GPSTracker(int id, String simNulmber) {

		this.id = id;
		this.simNulmber = simNulmber;
		this.vehiculeGPSTracker = new VehiculeGPSTracker(null, null, null, null);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSimNulmber() {
		return simNulmber;
	}

	public void setSimNulmber(String simNulmber) {
		this.simNulmber = simNulmber;
	}

	public VehiculeGPSTracker getVehiculeGPSTracker() {
		return vehiculeGPSTracker;
	}

	public void setVehiculeGPSTracker(VehiculeGPSTracker vehiculeGPSTracker) {
		this.vehiculeGPSTracker = vehiculeGPSTracker;
	}

	@Override
	public String toString() {
		return "simNulmber=" + simNulmber ;
	}

}