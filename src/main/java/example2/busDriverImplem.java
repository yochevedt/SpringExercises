

	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;
	import javax.persistence.Query;
	import javax.persistence.TypedQuery;
	import javax.transaction.Transactional;

	import org.springframework.stereotype.Repository;

	import example2.model.Seat;

	@Repository
	
    public class busDriverImplem implements busDriverDAO{
		@PersistenceContext
		private EntityManager entityManager;

		@Override
		@Transactional
		public void saveSeat(Seat seat) {
			if (seat.getId() == null) {
				entityManager.persist(seat);
			} else {
				entityManager.merge(seat);
			}
		}

		@Override
		public Seat getSeatById(long seatId) {
			Seat seat = entityManager.find(Seat.class, seatId);
			return seat;
		}

		@Override
		public List<Seat> getAll() {
			String HSQL = "SELECT seat FROM Seat seat";
			Query query = entityManager.createQuery(HSQL);
			List<Seat> seats = (List<Seat>) query.getResultList();
			// System.out.println(bussess);
			return seats;
		}

		@Override  ///this is the command to HSQL in hibernet
		public List<Seat> getSeatByBusId(Long busId) {
			String HSQL = "SELECT seat FROM Seat seat where seat.bus.id = :busId";
			TypedQuery<Seat> query = entityManager.createQuery(HSQL,Seat.class);
			query.setParameter("busId", busId);
			List<Seat> seats = query.getResultList();
			// System.out.println(bussess);
			return seats;
		}

		@Override
		public busDriver getDriverbyID(long driverId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void saveBusDriver(busDriver busDriver) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<busDriver> getBusDriversbyId(long id) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	
}
