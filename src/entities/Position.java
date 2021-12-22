package entities;

import java.util.Date;
import java.util.Objects;

public class Position {
	private int id;
	private double latitude;
	private double longitude;
	private Date date;
	private GPSTracker gpsTracker;
	public Position(int id, double latitude, double longitude, Date date, GPSTracker gpsTracker) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
		this.gpsTracker = gpsTracker;
	}
	public Position(double latitude, double longitude, Date date, GPSTracker gpsTracker) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
		this.gpsTracker = gpsTracker;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public GPSTracker getGpsTracker() {
		return gpsTracker;
	}
	public void setGpsTracker(GPSTracker gpsTracker) {
		this.gpsTracker = gpsTracker;
	}
	@Override
	public String toString() {
		return " latitude=" + latitude + ", longitude=" + longitude;
	}

    @Override
    public boolean equals(Object o) {
         // If the object is compared with itself then return true 
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Position)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members
        Position c = (Position) o;
         
        // Compare the data members and return accordingly
        return Integer.compare(this.getId(),c.getId() ) == 0;
               
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.latitude) ^ (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.longitude) ^ (Double.doubleToLongBits(this.longitude) >>> 32));
        return hash;
    }
		
	

}