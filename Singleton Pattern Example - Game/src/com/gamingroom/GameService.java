package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator; 
/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1; // holds next game identifier
	private static long nextPlayerId = 1; // holds next player identifier
	private static long nextTeamId = 1; // holds next team identifier
	private static GameService instance = null; // Singleton instance variable
	// FIXME: Add missing pieces to turn this class a singleton 
    private GameService() {
    }
    // Method to obtain the singleton instance of GameService
    public static GameService getInstance() {
        if (instance == null)
            instance = new GameService();
        return instance;
    }

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = getGame(name); // Check if the game with the given name already exists

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	// Method to get a game by its unique ID
	public Game getGame(long id) {
		// Implementation for getting the count of active games
		Iterator<Game> gamesIterator = games.iterator();
        while (gamesIterator.hasNext()) {
            Game game = gamesIterator.next();
            if (game.getId() == id)
                return game;
        }
        return null;
    }

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	// Method to get a game by its unique name
	public Game getGame(String name) {
		// Implementation for retrieving a game by its name
		 Iterator<Game> gamesIterator = games.iterator();
	        while (gamesIterator.hasNext()) {
	            Game game = gamesIterator.next();
	            if (game.getName().equals(name))
	                return game;
	        }
	        return null;
	    }

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	 public long getNextPlayerId() {
	        return nextPlayerId++;
	    }

	    public long getNextTeamId() {
	        return nextTeamId++;
	    }
	}
