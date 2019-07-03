package example3.dao;

import java.util.List;

import example3.model.Bus;

public interface BusDao {

	void saveBus(Bus bus);

	Bus getBusById(long busId);

	List<Bus> getAll();

}