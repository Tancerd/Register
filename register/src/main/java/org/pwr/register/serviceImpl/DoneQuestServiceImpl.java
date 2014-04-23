package org.pwr.register.serviceImpl;

import java.util.List;

import org.pwr.register.dao.DoneQuestsDAO;
import org.pwr.register.dao.UserDAO;
import org.pwr.register.model.DoneQuest;
import org.pwr.register.model.User;
import org.pwr.register.service.DoneQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoneQuestServiceImpl implements DoneQuestService{

	@Autowired
	DoneQuestsDAO doneQuestsDAO;

	@Autowired
	UserDAO userDAO;
	
	public List<DoneQuest> getAllDoneQuests() {
		return doneQuestsDAO.findAll();
	}

	public DoneQuest getQuestById(int id) {
		return doneQuestsDAO.findQuestById(id);
	}

	public boolean removeQuests(String userName) {
		User user = userDAO.findByLogin(userName);
		if (user != null) {
			return doneQuestsDAO.deleteDoneQuests(user);
		}
		return false;
	}

	public boolean createDoneQuest(DoneQuest doneQuest)
	{
		List<DoneQuest> doneQuestList = doneQuestsDAO.findAll();
		for (DoneQuest dQ : doneQuestList)
		{
			if (dQ.getQuest().getId() == doneQuest.getQuest().getId() && dQ.getUserGame().getId() == doneQuest.getUserGame().getId())
				return true;
		}
		return doneQuestsDAO.create(doneQuest);
	}
}
