package example2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import example2.dao.BusDao;
import example2.dao.SeatDAO;
import example2.model.Bus;
import example2.model.Seat;

@SpringBootApplication
@ComponentScan({ "example2" })
public class ApplicationJPAmine {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ApplicationJPAmine.class, args);
		BusDao busDao = applicationContext.getBean(BusDao.class);
		SeatDAO seatDAO = applicationContext.getBean(SeatDAO.class);
		applicationContext.close();
		
		System.out.println("My code start working here...........bus creating");
		Bus bus1 = new Bus();
		bus1.setName("My new bus");
		BusDAO.saveBus(bus1);
		
		Bus bus2 = new Bus();
		bus2.setName("My new bus");
		BusDAO.saveBus(bus2);
		
		Bus bus3 = new Bus();
		bus3.setName("My new bus");
		BusDAO.saveBus(bus3);
		System.out.println("Adding seats to bus");
		List<String> rowLetters = Arrays.asList ("A", "B", "C");
		int numberOfSeats = 4;
		
		for (String rawLetter : rowLetters) {
			for (int seatNumber = 1; seatNumber <= numberOfSeats; seatNumber++) {
				Seat seat = new Seat();
				Bus bus = null;
				seat.setBus(bus);
				seat.setNumber(seatNumber);
				seat.setRawLetter(rawLetter);
				seatDAO.saveSeat(seat);
				
				List<Bus> all = busDao.getAll();
				System.out.println("Records: \n" + all);
				System.out.println("**************** get Bus by id");
			}
		}
		System.out.println("**************** get all busses");

		
		
		
		
	}
}
