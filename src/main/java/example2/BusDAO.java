package example2;
import java.util.List;
import javax.transaction.Transactional;
import example2.model.Bus;

	public interface BusDAO {

		 static void saveBus(Bus bus) {
			// TODO Auto-generated method stub
			
		}

		Bus getBusById(long busId);

		List<Bus> getAll();

	}


