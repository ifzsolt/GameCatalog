package hu.nye.progkor.gamecatalog.service.impl;

import hu.nye.progkor.gamecatalog.data.model.Game;
import hu.nye.progkor.gamecatalog.data.repository.Repository;
import hu.nye.progkor.gamecatalog.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default game servicem.
 */
@Service
public class DefaultGameService implements GameService {
    private final Repository<Game, Long> gameRepository;

    @Autowired
    public DefaultGameService(Repository<Game, Long> gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game retrieveGameById(Long id) {
        return gameRepository.getById(id);
    }

    @Override
    public List<Game> retrieveAllGames() {
        return gameRepository.getAll();
    }

    @Override
    public Game updateGame(Game game) {
        return gameRepository.update(game);
    }

    @Override
    public void deleteGameById(Long id) {
        gameRepository.deleteById(id);
    }
}
