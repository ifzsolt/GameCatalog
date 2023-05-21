package hu.nye.progkor.gamecatalog.service;

import hu.nye.progkor.gamecatalog.data.model.Game;

import java.util.List;

/**
 * Game service repository.
 */
public interface GameService {
    Game createGame(Game game);

    Game retrieveGameById(Long id);

    List<Game> retrieveAllGames();

    Game updateGame(Game game);

    void deleteGameById(Long id);
}