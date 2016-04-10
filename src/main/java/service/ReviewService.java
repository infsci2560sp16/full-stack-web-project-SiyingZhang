package service;

import bean.User;
import bean.Word;

import com.google.gson.Gson;

import dao.WordDao;
import utils.ServiceUtils;
import utils.WordXmlUtils;
import spark.Session;

import java.util.ArrayList;
import java.util.UUID;

import static spark.Spark.get;


/**
 * @author siying
 */

class ReviewService {
    private Gson gson = new Gson();
    private ServiceUtils su = new ServiceUtils();
    private WordDao wd = new WordDao();
    private WordXmlUtils xu = new WordXmlUtils();


    /**
     * Group Service response to requests handling Group issues.
     */
    public ReviewService() {
        super();
        this.startServe();
    }

    private void startServe() {

        get("/review", (request, response) -> {
            ArrayList<Word> wordsList = null;
            Session session = request.session(true);
            response.type("application/xml");
            if (su.hasUserLoggedIn(request, response)) {
                User u = ((User) session.attribute("user"));
                ArrayList<UUID> words = u.getWordsList();
                UUID userId = u.getUserId();
                try {
                    wordsList = wd.buildWordsList(words);
                } catch (Exception e) {
                    System.out.println(this.getClass() + "/WordsList: Database failure.");
                    e.printStackTrace();
                }
                return xu.buildWordListXML(userId, wordsList);
            } else {
                try {
                    wordsList = wd.buildRecommendation();
                } catch (Exception e) {
                    System.out.println(this.getClass() + "/WordsList: Database failure.");
                    e.printStackTrace();
                }
                return xu.buildWordListXML(null, wordsList);
            }
        });

    }
}
