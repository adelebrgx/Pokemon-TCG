# cc3002-tarea1
Homework 1 : CC3002 Metodologias y Diseño de programación

## Project's goal
This project was implemented as part of a homework of the course CC3002.
It implements the Pokemon Trading Card Game (TCG), "a collectible card game, based on Nintendo's Pokémon franchise of video games and anime, first published in October 1996 by Media Factory". The ultimate goal of the project is to obtain a programm which portrays the game, its logic and rules. 

## Entities
Main entities of the game are represented in the project by different classes. 

A Card is represented by an interface ICard which an abstract class ACard extends. 

As a Card may be an Energy Card or a Pokemon Card, both are implemented by a an Interface IEnergy and IPokemon from which derive both abstract classes (AEnergy and APokemon) and one class for each type: plant, water, fire, electric, psychic and fighting (PlantEnergy, PlantPokemon, FireEnergy, FirePokemon...). 

The Pokemon's trainer or player is represented by a class named Player, which sets all the basic functionnalities of a player: like drawing a card to his/her hand, putting a Pokemon to his Pokemon Bank, selecting a Pokemon, playing a card, attack his/her opponent's selected Pokemon...

### Card Entity

The Card interface ICard is implemented by an abstract class ACard. A card can only be played and this action will be described within the entities Pokemon and Energy. 

### Pokemon Entity

#### Attributes:
```String name, int pokedexID, int hp, HashMap<String, Integer> EnergiesAssociated, ArrayList<Attack> attackList; ```

A Pokemon is implemented within the Abstract class APokemon which implements IPokemon. Basically a Pokemon is described with its name, its hp, its Pokedex ID, a list of attacks assigned to it and a list of energies is been given by its player. 

Amongst the functionnalites which describe a pokemon, performing attacks and receiving attacks are implemented within the class. A Pokemon can also be assigned energies or attacks or being played by a player on the battlefield. 

Each class FirePokemon, WaterPokemon, PlantPokemon, ElectricPokemon, PsychicPokemon and Fighting Pokemon implements the functionnalities specific to the type of a Pokemon. For example, the methods receive_Attack shows the effects of an attack of type _ on a Pokemon's HP given he's either resistant, weak or none of both to another type.

### Energy Entity

#### Attributes: 
```String name```

An energy is implemented within the Abstract class AEnergy which implements IEnergy. Basically an energy is described with its name and a type _  returned by each class Energy_ in a method. 

An energy can be played by the player and attributed to its Pokemon on the battlefield.

### Player entity

#### Attributes : 
```String name, List<ICard> hand, List<IPokemon> pokemonBank, IPokemon selectedPokemon, List<IPokemon> pokemonLost```
  
A player in implemented within the class Player. A player is described by his/her name, a list of cards he has in hand, a list of Pokemons he/she has in his/her bank, the Pokemon he/she has selected to fight on the battlefield and a list of all the Pokemons he/she lost on the battlefield.

All the functionnalities a player can perform are implemented in the class and will allow us to implement the game further on. 
Amongst all the actions the player can perform, he/she can draw a card, put a Pokemon in his bank, send a Pokemon to a battlefield, attack the opponent's Pokemon, or play a Card : that's to say put a new Pokemon in his Pokemon bank or assign an energy to the Pokemon he/she sent to the battlefield. 

## Built with 

* **JDK Version 8** project built with Java
* **JUnit4** testing framework used to run the tests


## Getting started 

All the informations needed to run the program properly 

### Prerequisites

To be able to run the program on your computer, you'll need to have JDK Version 8 installed on your computer and in that sense, need to have downloaded Java SE 8uXXX. 

The program needs to be run on an IDE(Integrated Development Environment): Intellij IDEA CE is strongly recommended to use the project. The IDE can be dowloaded on JetBrains' shop website. To use all the functionnalities, the ultimate version needs to be downloaded.

### Running the tests

Open the project with Intellij. To run all the tests, do a right click on the tests folder and click on Run with coverage. 

## Versioning

The first version of the project deployed on April 27th, 2019 implements the entities of the project, their basic functionnalities and the interactions among them. 

More versions will be deployed during the following months. 

## Author 
* **Adèle Bourgeix**
