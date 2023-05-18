package hu.nye.progkor.gamecatalog.web;

import hu.nye.progkor.gamecatalog.data.model.Game;
import hu.nye.progkor.gamecatalog.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/game")
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

     @PostMapping
    public Game createGame(@RequestBody Game game){
        return gameService.createGame(game);
     }
}
