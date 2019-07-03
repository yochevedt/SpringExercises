package example2.dao;

import java.util.List;

import javax.transaction.Transactional;

import example2.model.Bus;

public interface BusDao {

	void saveBus(Bus bus);

	Bus getBusById(long busId);

	List<Bus> getAll();

}