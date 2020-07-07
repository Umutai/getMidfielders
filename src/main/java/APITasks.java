import com.fasterxml.jackson.databind.DeserializationFeature;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nurkulov 12/26/19
 */
public class APITasks {

    /*
     * GET all soccer team names listed in given resource
     * Deserialization type: Pojo
     */
    public static List<String> getAllTeams() throws URISyntaxException, IOException {

        return null;
    }

    /*
     * GET names of all goalkeepers from England team
     * note: England team id is 66
     * Deserialization type: TypeReference
     */
    public static List<String> getAllGoalkeepers() throws URISyntaxException, IOException {
        return null;
    }

    /*
     * GET names of all defenders from England team
     * note: England team id is 66
     * Deserialization type: TypeReference
     */
    public static List<String> getDefenders() throws URISyntaxException, IOException {
        return null;
    }

    /*
     * GET names of all midfielders from England team
     * note: England team id is 66
     * Deserialization type: Pojo
     */
    public static List<String> getMidfielders() throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost("api.football-data.org");
        uriBuilder.setPath("/v2/teams/66");

        HttpGet get = new HttpGet(uriBuilder.build());
        get.setHeader("Accept", "application/json");
        get.setHeader("X-Auth-Token", "a2cbeef5c2474ad097bda983385283d6");
        HttpResponse response = client.execute(get);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<String> midfilders = new ArrayList<>();
        SquadPojo desrializeMidfielders = objectMapper.readValue(response.getEntity().getContent(), SquadPojo.class);
        for (int i = 0; i < desrializeMidfielders.getSquad().size(); i++) {
            String position = "" + desrializeMidfielders.getSquad().get(i).get("position");
            String name = "" + desrializeMidfielders.getSquad().get(i).get("name");
            if (position.equalsIgnoreCase("Midfielder")) {
                midfilders.add(name);
            }
        }
        return midfilders;
    }
        /*
         * GET names of all midfielders from England team whose country is Brazil
         * note: England team id is 66
         * Deserialization type: Pojo
         */
        public static List<String> getMidfielderFromBrazil () throws URISyntaxException, IOException {
            return null;
        }

        /*
         * GET names of all attackers from England team whose origin country is England
         * note: England team id is 66
         * Deserialization type: Pojo
         */
        public static List<String> getAttackerFromEngland () throws URISyntaxException, IOException {
            return null;
        }

        /*
         * GET name of Spain team coach
         * note: Spain team id is 77
         * Deserialization type: Pojo
         */
        public static List<String> getSpainCoach () throws URISyntaxException, IOException {
            return null;
        }

    /*
    GET list of all competitions
    Deserialization type: POJO
     */
        public static List<String> getAllCompetitions () throws URISyntaxException, IOException {
            return null;

        }

        /*
         * GET names of second highest scorrer from competitions of 2000 season
         * note: endpoint for competitions: `competitions/<year>/
         * note: endpoint for scorers: `competitions/<year>/scorers`
         * Deserialization type: Pojo and TypeReference
         */
        public static List<String> getSecondHighestScorer () throws URISyntaxException, IOException {
            return null;
        }
    }
