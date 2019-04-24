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

## Getting started 

All the informations needed to run the program properly 

### Prerequisites

To be able to run the program on your computer, you'll need to have JDK Version 8 installed on your computer and in that sense, need to have downloaded Java SE 8uXXX. 

The program needs to be run on an IDE(Integrated Development Environment): Intellij IDEA CE is strongly recommended to use the project. The IDE can be dowloaded on JetBrains' shop website. To use all the functionnalities, the ultimate version needs to be downloaded.

### Running the tests

Open the project with Intellij. To run all the tests, do a right click on the tests folder and click on Run with coverage. 
