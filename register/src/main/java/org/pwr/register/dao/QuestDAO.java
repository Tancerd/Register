package org.pwr.register.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pwr.register.model.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class QuestDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Quest findQuestById(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Quest quest = (Quest)session.get(Quest.class, id);
		return quest;
	}
	
	@Transactional
	public List findAll() {
		Session session = sessionFactory.getCurrentSession();
		List quests = session.createQuery("from Quest").list();
		return quests;
	}
	
	@Transactional
	public boolean saveQuest(Quest quest)
	{
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(quest);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
	
	@Transactional
	public boolean deleteQuest(Quest quest)
	{
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(quest);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public Quest findQuestByTitle(String name) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Quest where title = :title");
			query.setParameter("title", name);
			Quest quest = (Quest)query.uniqueResult();
			return quest;
		} catch (HibernateException e) {
			return null;
		}
	}
}
