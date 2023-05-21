package hu.nye.progkor.gamecatalog.data.repository.impl;


import hu.nye.progkor.gamecatalog.data.model.Game;
import hu.nye.progkor.gamecatalog.data.repository.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Memoriaban tarolas.
 */
@org.springframework.stereotype.Repository
public class InMemoryGameRepository implements Repository<Game, Long> {
    private static final Map<Long, Game> STORAGE = new HashMap<>();

    /**
     * Game save.
     */
    @Override
    public Game save(Game game) {
        Long id = STORAGE.size() + 1L;
        game.setId(id);
        STORAGE.put(id, game);

        return STORAGE.get(id);
    }

    /**
     * ID alapjan lekeres.
     */
    @Override
    public Game getById(Long id) {
        return STORAGE.get(id);
    }

    /**
     * Mind listazasa.
     */
    @Override
    public List<Game> getAll() {
        return STORAGE.values().stream().toList();
    }

    /**
     * Edit.
     */
    @Override
    public Game update(Game game) {
        Long id = game.getId();
        STORAGE.put(id, game);
        return STORAGE.get(id);
    }

    /**
     * Id alapjan torles.
     */
    @Override
    public void deleteById(Long id) {
        STORAGE.remove(id);
    }
}
