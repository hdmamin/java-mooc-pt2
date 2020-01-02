/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hmamin
 */
import java.util.Comparator;

public class SortAgainstSuitAndValue implements Comparator<Card> {
    
    @Override
    public int compare(Card card1, Card card2) {
        int suitDiff = card1.getSuit() - card2.getSuit();
        if (suitDiff != 0) {
            return suitDiff;
        } else {
            return card1.getValue() - card2.getValue();
        }
    }
    
}
