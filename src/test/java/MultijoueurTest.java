

import com.mycompany.multiplayer.Multijoueur;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pedago
 */
public class MultijoueurTest {
    
    Multijoueur game;
    String[] players = { "John", "Paul", "Georges", "Ringo" };
    
    @Before
    public void setUp() {
	game = new Multijoueur();
    }
    
    @Test
    public void testStartNewGame() {
        assertEquals(game.startNewGame(players), "Prochain tir : joueur John, tour n° 1, boule n° 1");
        
    }
    
    @Test 
    public void scenarioCompleted(){
        game.startNewGame(players);
        assertEquals(game.lancer(10), "Prochain tir : joueur Paul, tour n° 1, boule n° 1");
        assertEquals(game.lancer(3), "Prochain tir : joueur Paul, tour n° 1, boule n° 2");
        assertEquals(game.lancer(7), "Prochain tir : joueur Georges, tour n° 1, boule n° 1");
        assertEquals(game.lancer(0), "Prochain tir : joueur Georges, tour n° 1, boule n° 2");
        assertEquals(game.lancer(0), "Prochain tir : joueur Ringo, tour n° 1, boule n° 1");
        assertEquals(game.lancer(0), "Prochain tir : joueur Ringo, tour n° 1, boule n° 2");
        assertEquals(game.lancer(0), "Prochain tir : joueur John, tour n° 2, boule n° 1");
        assertEquals(game.lancer(6), "Prochain tir : joueur John, tour n° 2, boule n° 2");
        assertEquals(game.lancer(3), "Prochain tir : joueur Paul, tour n° 2, boule n° 1");
        assertEquals(game.lancer(5), "Prochain tir : joueur Paul, tour n° 2, boule n° 2");
        assertEquals(game.lancer(0), "Prochain tir : joueur Georges, tour n° 2, boule n° 1");
        
        assertEquals(game.scoreFor("John"), 28);
        assertEquals(game.scoreFor("Paul"), 20);
        assertEquals(game.scoreFor("Georges"), 0);
        assertEquals(game.scoreFor("Ringo"), 0);

    } 
    
    @Test (expected = Exception.class)
    public void gameNotStarted(){
        game.lancer(10);
    }
        
    @Test (expected = Exception.class)
    public void tooMuchThrown(){
        game.lancer(2);
        game.lancer(10);
    }
            
    @Test (expected = Exception.class)
    public void noPlayers(){
        String [] playersVide = {}; 
        game.startNewGame(playersVide);
        game.lancer(2);
        game.lancer(4);
    }
    
    
    
    
}
