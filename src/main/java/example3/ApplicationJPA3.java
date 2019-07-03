package example3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import example2.model.BussDriver;
import example3.dao.BusDao;
import example3.dao.SeatDAO;
import example3.model.Bus;
import example3.model.Seat;



@SpringBootApplication
@ComponentScan({ "example3" })
public class ApplicationJPA3 {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ApplicationJPA3.class, args);
		BusDao busDao = applicationContext.getBean(BusDao.class);
		SeatDAO seatDao = applicationContext.getBean(SeatDAO.class);
		
		System.out.println("**************** Saving Bus");
		Bus bus = new Bus();
		bus.setName("My bus");
		busDao.saveBus(bus);
		System.out.println("**************** adding seats");
		
		List<String> rowLetters = Arrays.asList("A","B","C");
		int numberOfSeatForEachRow = 4;
		for (String rawLetter : rowLetters) {
			for (int seatNumber = 1; seatNumber <= numberOfSeatForEachRow; seatNumber++) {
				Seat seat = new Seat();
				seat.setBus(bus);
				seat.setNumber(seatNumber);
				seat.setRawLetter(rawLetter);
				seatDao.saveSeat(seat);
			}
		}
		System.out.println("**************** get all busses");

		
		List<Bus> all = busDao.getAll();
		System.out.println("Records: \n" + all);
		System.out.println("**************** get Bus by id");

		bus = busDao.getBusById(bus.getId());
		
		System.out.println("**************** updateing the seats");

		

		List<Seat> seatByBusId = seatDao.getSeatByBusId(bus.getId());
		seatByBusId.get(0).setRawLetter("Z");
	//	seatDao.saveSeat(seatByBusId.get(0));
		
		System.out.println("**************** updating  Bus");

		bus.setName(bus.getName() + " change it");
		bus.setSeats(seatByBusId);
		
		
		busDao.saveBus(bus);
		
		seatDao.saveSeat(bus.getSeats().get(0));
		
		applicationContext.close();
		
	}
}
