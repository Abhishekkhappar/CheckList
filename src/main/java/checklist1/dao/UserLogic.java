package checklist1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import checklist1.dto.Task;
import checklist1.dto.User;

public class UserLogic {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("project");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void addUser(User user) {
		transaction.begin();
		manager.persist(user);
		transaction.commit();
	}

	public User fetchByEmail(String email) {
		Query q=manager.createQuery("select a from User a");
		List<User> l=q.getResultList();
		for (User r : l) {
			if (r.getEmail().equals(email)) {
				return r;
			}
		}
		return null;
	}

	public void addTask(Task t) {
		transaction.begin();
		manager.persist(t);
		transaction.commit(); 
	}
	public List<Task> fetchById(int id) {
		Query q=manager.createQuery("select a from Task a where user_id=?1").setParameter(1,id);
		return q.getResultList();
	}
}
