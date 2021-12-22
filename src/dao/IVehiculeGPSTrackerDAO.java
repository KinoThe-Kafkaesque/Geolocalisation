package dao;

import java.util.List;

import entities.VehiculeGPSTracker;

public interface IVehiculeGPSTrackerDAO<VehiculeGPSTracker> {
	boolean create(VehiculeGPSTracker o);

	boolean fin(VehiculeGPSTracker o);

	VehiculeGPSTracker findById(int id);

	List<VehiculeGPSTracker> findByVehicule(int id);

	List<VehiculeGPSTracker> findByTracker(int id);

	List<VehiculeGPSTracker> findAll();

	void refresh();
}
