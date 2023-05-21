package hu.nye.progkor.gamecatalog.web.controller;

import hu.nye.progkor.gamecatalog.data.model.Game;
import hu.nye.progkor.gamecatalog.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Postmanhaz.
 */
@RestController
@RequestMapping("/api/v1/game")
public class GameCatalogRestController {
    private final GameService gameService;

    /**
     * valami.
     */
    @Autowired
    public GameCatalogRestController(GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * Lekerdezes id apajan.
     */
    @GetMapping("/{id}")
    public Game getGameById(@PathVariable Long id) {
        return gameService.retrieveGameById(id);
    }

    /**
     * Mind listazasa.
     */
    @GetMapping
    public List<Game> getAllGames() {
        return gameService.retrieveAllGames();
    }

    /**
     * Letrehozas.
     */
    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameService.createGame(game);
    }

    /**
     * Update.
     */
    @PutMapping
    public Game updateGame(@RequestBody Game game) {
        return gameService.updateGame(game);
    }

    /**
     * Torles id alapjan.
     */
    @DeleteMapping("/{id}")
    public void deleteGameById(@PathVariable Long id) {
        gameService.deleteGameById(id);
    }
}