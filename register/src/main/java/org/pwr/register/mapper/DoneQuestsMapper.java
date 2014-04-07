package org.pwr.register.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.pwr.register.dto.DoneQuestDTO;
import org.pwr.register.dto.UserGameDTO;
import org.pwr.register.model.DoneQuest;
import org.pwr.register.model.UserGame;
import org.springframework.stereotype.Service;

@Service
public class DoneQuestsMapper {

	public DoneQuestDTO doneDTOMap(DoneQuest doneQuest) {
		DoneQuestDTO doneQuestDTO = new DoneQuestDTO();
		doneQuestDTO.setDoneTime(doneQuest.getDoneTime());
		doneQuestDTO.setExtraPoints(doneQuest.getExtraPoints());
		doneQuestDTO.setGameId(doneQuest.getGameId());
		doneQuestDTO.setQuestName(doneQuest.getQuestName());

		return doneQuestDTO;
	}

	public List listDoneDTOMap(List<DoneQuest> listDoneQuests) {
		List<DoneQuestDTO> listDoneQuestDTOs = new ArrayList<>();

		for (DoneQuest doneQuest : listDoneQuests) {
			listDoneQuestDTOs.add(doneDTOMap(doneQuest));
		}
		
		return listDoneQuestDTOs;

	}
}
