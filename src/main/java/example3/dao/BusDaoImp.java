package example3.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import example3.model.Bus;
import example3.model.BussDriver;

@Repository
public class BusDaoImp implements BusDao {
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see example2.dao.BusDao#saveHall(example2.model.Bus)
	 */
	@Override
	@Transactional
	public void saveBus(Bus bus) {
		if (bus.getId() == null) {
			entityManager.persist(bus);
		} else {
			entityManager.merge(bus);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see example2.dao.BusDao#getHallById(int)
	 */
	@Override
	@Transactional
	public Bus getBusById(long busId) {
		Bus bus = (Bus) entityManager.find(Bus.class, busId);
		Map<Long, BussDriver> bussDrivers = bus.getBussDrivers();
		System.out.println(bussDrivers);
		return bus;
	}

	@Override
	//@Transactional
	public List<Bus> getAll() {
		String HSQL = "SELECT bus FROM Bus bus";
		Query query = entityManager.createQuery(HSQL);
		List<Bus> bussess = (List<Bus>) query.getResultList();
		//System.out.println(bussess);
		return bussess;

	}

}
