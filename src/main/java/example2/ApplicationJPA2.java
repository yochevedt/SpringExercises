package example2;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import example2.dao.BusDao;
import example2.model.Bus;

@SpringBootApplication
@ComponentScan({ "example2" })
public class ApplicationJPA2 {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ApplicationJPA2.class, args);
		BusDao busDao = applicationContext.getBean(BusDao.class);
		Bus bus = new Bus();
		bus.setName("My bus");
		busDao.saveBus(bus);
		
		Bus busById = busDao.getBusById(bus.getId());
		System.out.println(busById);
		
		List<Bus> all = busDao.getAll();
		System.out.println("Records: \n" + all);
		applicationContext.close();
		
	}
}
