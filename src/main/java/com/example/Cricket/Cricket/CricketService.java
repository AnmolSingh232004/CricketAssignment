package com.example.Cricket.Cricket;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CricketService {
    private final CricketRepository cricketRepository;

    @Autowired
    public CricketService(CricketRepository cricketRepository) {
        this.cricketRepository = cricketRepository;
    }

    public Player getPlayerDetailsById(Long id) {
        if (cricketRepository.findById(id).isPresent())return cricketRepository.findById(id).get();
        else return null;
    }

    public List<Player> getPlayersAboveXScore(int x) {
        return cricketRepository.findAll().stream()
                .filter(player -> calculateAverageScore(player) > x)
                .collect(Collectors.toList());

    }
    private Long calculateAverageScore(Player player) {
        Long score = player.getTotalScore();
        if (score == 0) {
            return 0L;
        } else {
            return player.getTotalScore()/player.getMatchesPlayed();
        }
    }
    public List<Player> getPlayersByCountry(String country) {
        return cricketRepository.findAllByCountry(country);
    }

    public List<Player> getPlayersAboveYCustomMethod(int y) {
        List<Player> players = cricketRepository.findAll();
        List<Player> filteredList = new ArrayList<>();
        for (Player p : players) {
            if (calculateAverageScore(p) > y) {
                filteredList.add(p);
            }
        }
        Collections.sort(filteredList, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                int compareScore = Long.compare(o1.getTotalScore()/o1.getMatchesPlayed(), o2.getTotalScore()/o2.getMatchesPlayed());
                if (compareScore != 0)return compareScore;
                return o1.getDob().compareTo(o2.getDob());
            }
        });
        return filteredList;
    }

    public void addPlayerService(Player player) {
        cricketRepository.save(player);
    }

    @Transactional
    public void updatePlayerId(Long pid, Long totalScore, Long matchesPlayed) {
        Optional<Player> playeroOptional = cricketRepository.findById(pid);
        Player player = new Player();
        if (playeroOptional.isPresent()) {
           player = playeroOptional.get();
        }
        if (player.getMatchesPlayed() < matchesPlayed)player.setMatchesPlayed(matchesPlayed);
        if (player.getTotalScore() < totalScore)player.setTotalScore(totalScore);
        }
    public void deletePlayerId(Long pid) {
        cricketRepository.deleteById(pid);
    }
}
