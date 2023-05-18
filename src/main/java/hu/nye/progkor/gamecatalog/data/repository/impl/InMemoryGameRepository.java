package hu.nye.progkor.gamecatalog.data.repository.impl;


import hu.nye.progkor.gamecatalog.data.model.Game;
import hu.nye.progkor.gamecatalog.data.repository.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
.TODO
 */
@org.springframework.stereotype.Repository
public class InMemoryGameRepository implements Repository<Game, Long> {
    private static final Map<Long, Game> STORAGE = new HashMap<>();

    @Override
    public Game save(Game game) {
        Long id = STORAGE.size() + 1L;
        game.setId(id);
        STORAGE.put(id, game);

        return STORAGE.get(id);
    }

    @Override
    public Game getById(Long id) {
        return STORAGE.get(id);
    }

    @Override
    public List<Game> getAll() {
        return STORAGE.values().stream().toList();
    }

    @Override
    public Game update(Game game) {
        Long id = game.getId();
        STORAGE.put(id, game);
        return STORAGE.get(id);
    }

    @Override
    public void deleteByID(Long id) {
        STORAGE.remove(id);
    }
}
