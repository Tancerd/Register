package org.pwr.register.mapper;

import java.util.LinkedList;
import java.util.List;

import org.pwr.register.dto.UserGameDTO;
import org.pwr.register.model.UserGame;
import org.springframework.stereotype.Service;

@Service
public class GameUserMapper {

	public UserGameDTO map(UserGame userGame) {
		UserGameDTO userGameDTO = new UserGameDTO();
		userGameDTO.setUser(userGame.getUser().getLogin());
		userGameDTO.setPoints(userGame.getPoints());
		userGameDTO.setEndTime(userGame.getEndTime());

		return userGameDTO;
	}

	public List<UserGameDTO> mapList(List<UserGame> userGameList) {
		List<UserGameDTO> listUGDTO = new LinkedList<UserGameDTO>();
		for (UserGame userGame : userGameList) {
			listUGDTO.add(map(userGame));
		}
		return listUGDTO;
	}
}
