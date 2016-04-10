package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import bean.Word;

/*
 * @author Siying Zhang
 * Transfer data between database and front-end
 */

public class WordDao {

    private final int RECOMMEND_NUMBER = 10;


    public ArrayList<Word> buildWordsList(ArrayList<UUID> wordList) throws Exception {
        ArrayList<Word> wordsList = new ArrayList<>();
        Connection connection = null;

        for (int i = 0; i < wordList.size(); i++) {
            try {
                // TODO: SELECT word_name and put it into Hashmap.
                // TODO: SELECT the latest post in the Word and put it into Hashmap.
                Word word = new Word();
            } catch (Exception e) {
                throw new Exception(this.getClass() + ".buildWordsList: Database failure.");
            } finally {
                if (connection != null)
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        System.out.println(this.getClass() + ".buildWordsList: Could not close connection to database.");
                    }
            }
        }

        /********** THESE ARE TEST DATA. ***********/
        Word tempWord = new Word("Amazing", "adjective", "causing great suprise or wonder; astonishing");
        wordsList.add(tempWord);
        wordsList.add(tempWord);
        wordsList.add(tempWord);
        wordsList.add(tempWord);
        /********** THESE ARE TEST DATA. **********/

        return wordsList;
    }

    public ArrayList<Word> buildRecommendation() throws Exception {
        ArrayList<Word> wordsList = new ArrayList<>();
        Connection connection = null;

        HashMap<String, Object> word = new HashMap<>();
        for (int i = 0; i < this.RECOMMEND_NUMBER; i++) {
            try {
                // TODO: SELECT [recommended] Word_name and put it into Hashmap.
                // TODO: SELECT the latest post in the Word and put it into Hashmap.
                Word recWord = new Word();
            } catch (Exception e) {
                throw new Exception(this.getClass() + ".buildRecommendation: Database failure.");
            } finally {
                if (connection != null)
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        System.out.println(this.getClass() + ".buildRecommendation: Could not close connection to database.");
                    }
            }
        }

        /********** THESE ARE TEST DATA. ***********/
        Word tempWord = new Word("logout", "noun", "an act of logging out of a computer system.");
        wordsList.add(tempWord);
        wordsList.add(tempWord);
        wordsList.add(tempWord);
        wordsList.add(tempWord);
        wordsList.add(tempWord);
        /********** THESE ARE TEST DATA. **********/

        return wordsList;
    }		
}
