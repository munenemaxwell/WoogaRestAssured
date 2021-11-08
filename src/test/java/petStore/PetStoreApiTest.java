package petStore;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utilityClasses.UtilityFunctions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;


public class PetStoreApiTest {
    //findbystatus url
    final String endpoint = "https://petstore3.swagger.io/api/v3/pet/findByStatus";

    //maximum threshold for expected response time in ms
    final Long response_time = Long.valueOf(3000);

    //initialize utility functions
    UtilityFunctions utilityFunctions=new UtilityFunctions();

    @Test
    //As a user i would like to validate the response time of findbystatus endpoint via a get request
    public  void testResponseTime(){

        given()
                .queryParam("status","available")
                .contentType(ContentType.JSON)
        .when()
                .get(endpoint)

        .then()
                //validate response code is 200 and response time <3 secs
                .assertThat()
                .time(lessThan(response_time));
    }

    @Test
    //As a user i would like to validate the response code of findbystatus endpoint via a get request
    public void testResponseCode(){
        given()
                .queryParam("status","available")
                .contentType(ContentType.JSON)
        .when()
                .get(endpoint)

        .then()
                //validate response code is 200 and response time <3 secs
                .assertThat()
                .statusCode(200);
    }


    @Test
    //As a user i would like to retrieve all pets in Lions category with a status of available
    public void testfindPetByStatusAvailable() {
        Response responsePets = utilityFunctions.makeRequest("available", endpoint);
        utilityFunctions.Log(utilityFunctions.getLions(responsePets));
    }

    @Test
    //As a user i would like to retrieve all pets in Lions category with a status of pending
    public void testfindPetByStatusPending() {
        Response responsePets = utilityFunctions.makeRequest("pending", endpoint);
        utilityFunctions.Log(utilityFunctions.getLions(responsePets));
    }

    @Test
    //As a user i would like to retrieve all pets in Lions category with a status of sold
    public void testfindPetByStatusSold() {
        Response responsePets = utilityFunctions.makeRequest("sold", endpoint);
        utilityFunctions.Log(utilityFunctions.getLions(responsePets));

    }

}
