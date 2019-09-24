package com.coxautodev.graphql.tools.example.resolvers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.example.CharacterRepository;
import com.coxautodev.graphql.tools.example.types.Character;
import com.coxautodev.graphql.tools.example.types.Droid;
import com.coxautodev.graphql.tools.example.types.Episode;
import com.coxautodev.graphql.tools.example.types.Hit;
import com.coxautodev.graphql.tools.example.types.Human;
import com.coxautodev.graphql.tools.example.types.Page;

import graphql.schema.DataFetchingEnvironment;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private CharacterRepository characterRepository;

    public Character hero(Episode episode) {
        return episode != null ? characterRepository.getHeroes().get(episode) : characterRepository.getCharacters().get("1000");
    }

    public Human human(String id, DataFetchingEnvironment env) {
        return (Human) characterRepository.getCharacters().values().stream()
            .filter(character -> character instanceof Human && character.getId().equals(id))
            .findFirst()
            .orElseGet(null);
    }

    public Droid droid(String id) {
        return (Droid) characterRepository.getCharacters().values().stream()
            .filter(character -> character instanceof Droid && character.getId().equals(id))
            .findFirst()
            .orElseGet(null);
    }

    public Character character(String id) {
        return characterRepository.getCharacters().get(id);
    }

    /*
    public Hit<Character> characterHit(String id) {
        Character character = characterRepository.getCharacters().get(id);
        return new Hit<>(character);
    }
    */

    public Page<Hit<Character>> characterHitPage(int limit, int offset) {
        List<Hit<Character>> content = characterRepository.getCharacters().values().stream().map(Hit::new).collect(Collectors.toList());
        return new Page<>(content.subList(offset, offset + limit), content.size());
    }

}
