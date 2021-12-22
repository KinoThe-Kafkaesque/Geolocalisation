package entities;
public class Vehicule {
	private int id;
	private String matricule;
	private String marque;
	private String type;
	private VehiculeGPSTracker vehiculeGPSTracker;

	public Vehicule(String matricule, String marque, String type) {
		this.matricule = matricule;
		this.marque = marque;
		this.type = type;
		this.vehiculeGPSTracker = new VehiculeGPSTracker(null, null, null);
	}

	public Vehicule(int id, String matricule, String marque, String type) {
		this.id = id;
		this.matricule = matricule;
		this.marque = marque;
		this.type = type;
		this.vehiculeGPSTracker = new VehiculeGPSTracker(null, null, null);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public VehiculeGPSTracker getVehiculeGPSTracker() {
		return vehiculeGPSTracker;
	}

	public void setVehiculeGPSTracker(VehiculeGPSTracker vehiculeGPSTracker) {
		this.vehiculeGPSTracker = vehiculeGPSTracker;
	}

	@Override
	public String toString() {
		return " matricule=" + matricule ;
	}

}
