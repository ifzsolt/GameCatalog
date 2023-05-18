package hu.nye.progkor.gamecatalog.web;

import hu.nye.progkor.gamecatalog.data.model.Game;
import hu.nye.progkor.gamecatalog.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/game")
public class GameCatalogRestController {
    private final GameService gameService;

    @Autowired
    public GameCatalogRestController(GameService gameService) {
        this.gameService = gameService;
    }
    @GetMapping("/{id}")
    public Game getGameById(@PathVariable Long id){
        return gameService.retrieveGameById(id);
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.retrieveAllGame();
    }

     @PostMapping
    public Game createGame(@RequestBody Game game){
        return gameService.createGame(game);
     }

    @PutMapping
    public Game updateGame(@RequestBody Game game){
        return gameService.updateGame(game);
    }
    @DeleteMapping("/{id}")
    public void deleteGameById(@PathVariable Long id){
        gameService.deleteGameByID(id);
    }
}
