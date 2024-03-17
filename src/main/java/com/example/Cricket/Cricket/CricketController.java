package com.example.Cricket.Cricket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/Cricket")
public class CricketController {
    private final CricketService cricketService;

    @Autowired
    public CricketController(CricketService cricketService) {
        this.cricketService = cricketService;
    }



    
    @GetMapping (path = "{pid}/byId")
    public Player getPlayerDetailsId(@PathVariable Long pid) {
        return cricketService.getPlayerDetailsById(pid);
    }

    @GetMapping(path = "{x}/playerlist")
    public List<Player> getPlayersAboveX(@PathVariable int x) {
        return cricketService.getPlayersAboveXScore(x);
    }

    @GetMapping(path = "{y}/playerlist/custom")
    public List<Player> getPlayersAboveYCustom(@PathVariable int y) {
        return  cricketService.getPlayersAboveYCustomMethod(y);
    }

    @PostMapping(path = "/addplayer")
    public void addPlayer(@RequestBody Player player) {
        cricketService.addPlayerService(player);
    }

    @PutMapping(path = "{pid}/update")
    public void updatePlayer(@PathVariable Long pid,
                             @RequestParam(required = false) Long totalScore,
                             @RequestParam(required = false) Long matchesPlayed) {
        cricketService.updatePlayerId(pid, totalScore, matchesPlayed);
    }

    @DeleteMapping(path = "{pid}/delete")
    public void deletePlayer(@PathVariable Long pid) {
        cricketService.deletePlayerId(pid);
    }

}
