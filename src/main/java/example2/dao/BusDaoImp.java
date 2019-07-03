package example2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import example2.model.Bus;

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
	//@Transactional
	public Bus getBusById(long busId) {
		Bus bus = (Bus) entityManager.find(Bus.class, busId);
		//System.out.println(bus);
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
