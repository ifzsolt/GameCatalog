package hu.nye.progkor.gamecatalog.web.controller;

import hu.nye.progkor.gamecatalog.data.model.Game;
import hu.nye.progkor.gamecatalog.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

/**
 * Webes.
 */
@Controller
@RequestMapping("/game-catalog")
public class GameCatalogController {

    private final GameService gameService;

    /**
     * valami.
     */
    @Autowired
    public GameCatalogController(GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * Id alapján lekérés.
     */
    @GetMapping("/{id}")
    public String getGameById(Model model, @PathVariable Long id) {
        Game game = gameService.retrieveGameById(id);
        model.addAttribute("game", game);
        return "game-catalog/edit";
    }

    /**
     * Kilistázza a tárolt adatokat.
     */
    @GetMapping
    public String getAllGames(Model model) {
        List<Game> allGames = gameService.retrieveAllGames();
        model.addAttribute("games", allGames);
        return "game-catalog/list";
    }

    /**
     * Létrehozás-hoz lekérés.
     */
    @GetMapping("/create")
    public String createGame() {
        return "game-catalog/create";
    }

    /**
     * Létrehozás.
     */
    @PostMapping("/create")
    public String createGame(Model model, Game game) {
        Game newGame = gameService.createGame(game);
        model.addAttribute("game", newGame);
        return "game-catalog/edit";
    }

    /**
     * Editelés.
     */
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateGame(Model model, Game game) {
        Game updatedGame = gameService.updateGame(game);
        model.addAttribute("game", updatedGame);
        return "game-catalog/edit";
    }

    /**
     * Delete.
     */
    @GetMapping("/{id}/delete")
    public String deleteGameById(Model model, @PathVariable Long id) {
        gameService.deleteGameById(id);
        List<Game> allGames = gameService.retrieveAllGames();
        model.addAttribute("games", allGames);
        return "game-catalog/list";
    }
}
