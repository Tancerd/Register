package org.pwr.register.mapper;

import java.util.LinkedList;
import java.util.List;

import org.pwr.register.dto.QuestDTO;
import org.pwr.register.model.Quest;
import org.pwr.register.model.Quest;
import org.pwr.register.model.UserGame;
import org.springframework.stereotype.Service;

@Service	
public class QuestMapper {
	
	public QuestDTO map(Quest quest) {
		QuestDTO questDTO = null;
		if (quest != null)
		{
			questDTO = new QuestDTO();
			
			questDTO.setDefaultPoints(quest.getDefaultPoints());
			questDTO.setDefaultTime(quest.getDefaultTime());
			questDTO.setName(quest.getName());
		}

		return questDTO;
	}
	
	public List mapList(List<Quest> questList) {
		List<QuestDTO> listQuestDTO = new LinkedList<QuestDTO>();
		for (Quest quest : questList) {
			listQuestDTO.add(map(quest));
		}
		return listQuestDTO;
	}

	public Quest map(QuestDTO questDTO) {
		Quest quest = new Quest();
		quest.setDefaultPoints(questDTO.getDefaultPoints());
		quest.setDefaultTime(questDTO.getDefaultTime());
		quest.setName(questDTO.getName());
		return quest;
	}
	
}
