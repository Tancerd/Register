package org.pwr.register.service;

import java.util.List;

import org.pwr.register.dao.QuestDAO;
import org.pwr.register.model.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestServiceImpl implements QuestService {

	@Autowired
	private QuestDAO questDAO;
	
	@Override
	public List getAllQuests() {
		return questDAO.findAll();
	}

	@Override
	public Quest getQuest(int id) {
		return questDAO.findQuestById(id);
	}

	@Override
	public boolean deleteQuest(int id) {
		Quest q = getQuest(id);
		if (q != null)
			return questDAO.deleteQuest(q);
		else return true;
	}

	@Override
	public boolean deleteAllQuests() {
		// TODO Auto-generated method stub
		return false;
	}

}
