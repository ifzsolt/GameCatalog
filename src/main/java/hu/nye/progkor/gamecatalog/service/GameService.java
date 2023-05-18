package hu.nye.progkor.gamecatalog.service;

import hu.nye.progkor.gamecatalog.data.model.Game;

import java.util.List;

public interface GameService {
    Game createGame(Game game);
    Game retrieveGameById(Long id);
    List<Game> retrieveAllGame();
    Game updateGame(Game game);
    void deleteGameByID(Long id);
}
