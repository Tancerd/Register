package org.pwr.register.mapper;

import java.util.LinkedList;
import java.util.List;

import org.pwr.register.dto.UserGameDTO;
import org.pwr.register.model.UserGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGameMapper {

	@Autowired
	private DoneQuestsMapper doneQuestsMapper;
	
	public UserGameDTO map(UserGame userGame) {

		UserGameDTO userGameDTO = null;

		if (userGame != null) {
			userGameDTO = new UserGameDTO();
			userGameDTO.setUser(userGame.getUser().getLogin());
			userGameDTO.setPoints(userGame.getPoints());
			userGameDTO.setEndTime(userGame.getEndTime());
			userGameDTO.setSetDoneQuestDTO(doneQuestsMapper.map(userGame.getDoneQuests()));
		}

		return userGameDTO;
	}

	public List mapList(List<UserGame> userGameList) {
		List<UserGameDTO> listUGDTO = new LinkedList<UserGameDTO>();
		for (UserGame userGame : userGameList) {
			listUGDTO.add(map(userGame));
		}
		return listUGDTO;
	}
}
