package petStore;
import Entities.Category;
import Entities.Pet;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;


public class PetStoreApiTest {
    //findbystatus url
    final String endpoint = "https://petstore3.swagger.io/api/v3/pet/findByStatus";

    //maximum threshold for expected response time in ms
    final Long response_time = Long.valueOf(3000);

    //Gson singleton to deserialize/serialize pet objects to json
    Gson gson = new Gson();

    //default constructor
    public PetStoreApiTest(){

    }

    //This utility method is meant to be reused for getting pets with different statuses.
    public Response makeRequest(String status, String endpoint) {
        Response response =

                given()
                        .queryParam("status", status)
                        .contentType(ContentType.JSON)
                .when()
                        .get(endpoint)

                .then()
                        //extract response and store in response variable
                        .extract().response();
        return response;
    }

    //utility function to return list of pets with a Lion category name
    public List<Pet> getLions(Response response) {

        //obtain json response as string
        String pets = response.asString();

        //deserialize json string using GSON library into an array of Pet entities
        Gson gson = new Gson();
        Pet[] petArray = gson.fromJson(pets, Pet[].class);

        List<Pet> Lions = new ArrayList<Pet>();

        for (Pet pet : petArray) {

            if (pet.category instanceof Category && pet.getCategory() != null && pet.getCategory().trim().equals("Lions")) {
                Lions.add(pet);
            }

        }

        return Lions;

    }

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
        Response responsePets = makeRequest("available", endpoint);
        Log(getLions(responsePets));
    }

    @Test
    //As a user i would like to retrieve all pets in Lions category with a status of pending
    public void testfindPetByStatusPending() {
        Response responsePets = makeRequest("pending", endpoint);
        Log(getLions(responsePets));
    }

    @Test
    //As a user i would like to retrieve all pets in Lions category with a status of sold
    public void testfindPetByStatusSold() {
        Response responsePets = makeRequest("sold", endpoint);
        Log(getLions(responsePets));

    }

    public void Log(List<Pet> Lions){

        for(Pet lion: Lions){
            System.out.println( gson.toJson(lion));
        }

    }

}
