package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PokemonCotroller {

    @GetMapping("prueba1")
    fun prueba1(){
        println("Me han llamado")

    }
    @GetMapping("prueba2")
    fun prueba2(): String {
        println("han llamado a prueba 2")
    return "Hello!"
    }
    @GetMapping("getPokemon")
    fun enviarpokemon(): Pokemon {

        return Pokemon("Pikachu",13)
    }
    @GetMapping("getPokemonIniciales")
    fun getPokemonIniciales(): List<Pokemon> {
        return PokemonRepository.listaPokemon
    }
    @GetMapping("seleccionarPokemonFavorito/{id}")
    fun getPokemonFavorito(@PathVariable id : Int): String {
        if(id < PokemonRepository.listaPokemon.size)
            return PokemonRepository.listaPokemon[id].toString()
        else
            return "Ese pokemon no se encuentra dentro de la lista"
    }
}