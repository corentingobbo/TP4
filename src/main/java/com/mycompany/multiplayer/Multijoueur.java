/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.multiplayer;

import bowling.MultiPlayerGame;
import bowling.SinglePlayerGame;
import java.util.ArrayList;

/**
 *
 * @author pedago
 */
public class Multijoueur implements MultiPlayerGame {

    ArrayList<SinglePlayerGame> gameList = new ArrayList<>();
    String[] players;
    int cptJoueur;
    int cpt;
    
    
    public String reponse(String nom, int a, int b){
        
        return "Prochain tir : joueur "+ nom +", tour n° "+a+", boule n° "+ b;
    }
    
    @Override
    public String startNewGame(String[] playerName) {
        this.players = playerName;
        this.cpt = 0;
        for (int i = 0; i < playerName.length; i++) {
            gameList.add(new SinglePlayerGame());
        }
        
        cptJoueur = 0;
        return reponse(playerName[0], gameList.get(cptJoueur).getFrameNumber(),gameList.get(cptJoueur).getNextBallNumber());
    }

    @Override
    public String lancer(int nombreDeQuillesAbattues) {
        gameList.get(cptJoueur).lancer(nombreDeQuillesAbattues);

  
        
        //STRIKE
        if (nombreDeQuillesAbattues == 10) {
            cpt = 0;
            if (cptJoueur == players.length - 1) {
                cptJoueur = 0;
            }else{
                cptJoueur++;
            }
        }else{
            cpt++;
            if (cpt%2 == 0) {
               if (cptJoueur == players.length - 1) {
                    cptJoueur = 0;
                }else{
                cptJoueur++;
                }
            }
        }


        return reponse(players[cptJoueur],gameList.get(cptJoueur).getFrameNumber(),gameList.get(cptJoueur).getNextBallNumber());
    }

    @Override
    public int scoreFor(String playerName)  {
        int joueur = 0;
        for (int i = 0; i < players.length; i++) {
            if ( players[i] == playerName) {
                joueur = i;
            }
        }
        return gameList.get(joueur).score();
    }
    
    public static void main(String[] args) {
        Multijoueur m = new Multijoueur();
        String[] players = {"Bob","Bill","Bruce","Fredo","Lestin"};
        System.out.println(m.startNewGame(players));
        
        System.out.println(m.lancer(10));
        System.out.println(m.lancer(2));
        System.out.println(m.lancer(3));
        System.out.println(m.lancer(5));
        System.out.println(m.lancer(3));
        System.out.println(m.lancer(4));
        System.out.println(m.lancer(3));
        System.out.println(m.lancer(2));
        System.out.println(m.lancer(3));
        System.out.println(m.lancer(10));
        System.out.println(m.lancer(2));
        System.out.println(m.lancer(2));
        
        for (String playerName : players)
	System.out.printf("Player: %s, score: %d %n",
		playerName,
		m.scoreFor(playerName));

        
    }
    
}
