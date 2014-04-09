package org.pwr.register.serviceImpl;

import java.util.List;

import org.pwr.register.dao.DoneQuestsDAO;
import org.pwr.register.model.DoneQuest;
import org.pwr.register.service.DoneQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoneQuestServiceImpl implements DoneQuestService{

	@Autowired
	DoneQuestsDAO doneQuestsDAO;
	
	@Override
	public List<DoneQuest> getAllQuests() {
		return doneQuestsDAO.findAll();
	}

	@Override
	public DoneQuest getQuestById(int id) {
		return doneQuestsDAO.findQuestById(id);
	}

	@Override
	public boolean removeQuest(String doneQuest) {
		return doneQuestsDAO.deleteDoneQuest(doneQuest);
	}

	@Override
	public boolean createDoneQuest(DoneQuest doneQuest)
	{
		return doneQuestsDAO.create(doneQuest);
	}
}
