package example2;

import java.util.List;

import example2.model.Bus;

public interface busDriverDAO {
	
	busDriver getDriverbyID (long driverId);
	
	List<busDriver> getAll();
	
	void saveBusDriver (busDriver busDriver);
	
	List<busDriver> getBusDriversbyId(long id);
}
