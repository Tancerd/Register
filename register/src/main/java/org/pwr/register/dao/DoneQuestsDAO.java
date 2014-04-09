package org.pwr.register.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pwr.register.model.DoneQuest;
import org.pwr.register.model.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DoneQuestsDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public DoneQuest findQuestById(int id) {
		Session session = sessionFactory.getCurrentSession();
		DoneQuest doneQuest = (DoneQuest) session.get(DoneQuest.class, id);
		return doneQuest;
	}

	@Transactional
	public List findAll() {
		Session session = sessionFactory.getCurrentSession();
		List doneQuests = session.createQuery("from DoneQuest").list();
		return doneQuests;
	}

	@Transactional
	public boolean deleteDoneQuest(String doneQuest) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(doneQuest);
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}

	@Transactional
	public boolean create(DoneQuest doneQuest) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(doneQuest);
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}

}
