package org.pwr.register.mapper;

import java.util.ArrayList;
import java.util.List;

import org.pwr.register.dto.DoneQuestDTO;
import org.pwr.register.model.DoneQuest;
import org.pwr.register.model.Quest;
import org.pwr.register.service.QuestService;
import org.pwr.register.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoneQuestsMapper {

	@Autowired
	private QuestMapper questMapper;
	
	@Autowired
	private UserGameService userGameService;
	
	@Autowired
	private QuestService questService;
	
	public DoneQuestDTO map(DoneQuest doneQuest) {
		DoneQuestDTO doneQuestDTO = new DoneQuestDTO();
		doneQuestDTO.setDoneTime(doneQuest.getDoneTime());
		doneQuestDTO.setExtraPoints(doneQuest.getExtraPoints());
		doneQuestDTO.setQuestDTO(questMapper.map(doneQuest.getQuest()));  

		return doneQuestDTO;
	}

	public List map(List<DoneQuest> listDoneQuests) {
		List<DoneQuestDTO> listDoneQuestDTOs = new ArrayList<DoneQuestDTO>();

		for (DoneQuest doneQuest : listDoneQuests) {
			listDoneQuestDTOs.add(map(doneQuest));
		}
		
		return listDoneQuestDTOs;

	}
	//zle ze logika biznesowa jest w mapperze
	public DoneQuest map(DoneQuestDTO doneQuestDTO, String user) {
		DoneQuest doneQuest = new DoneQuest();
		doneQuest.setDoneTime(doneQuestDTO.getDoneTime());
		doneQuest.setExtraPoints(doneQuestDTO.getExtraPoints());
		
		Quest quest = questService.getQuestByTitle(doneQuestDTO.getQuestDTO().getName());
		if (quest == null)
		{
			quest = questMapper.map(doneQuestDTO.getQuestDTO());
			questService.saveQuest(quest);
			quest = questService.getQuestByTitle(doneQuestDTO.getQuestDTO().getName());
		}
		doneQuest.setQuest(quest);
		doneQuest.setUserGame(userGameService.getUserGameByLogin(user));
		
		return doneQuest;
	}
}
