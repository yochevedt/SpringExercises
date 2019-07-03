package example3.dao;

import java.util.List;

import example3.model.Seat;

public interface SeatDAO {

	void saveSeat(Seat seat);

	Seat getSeatById(long seatId);

	List<Seat> getAll();
	
	List<Seat> getSeatByBusId(Long busId) ;

}