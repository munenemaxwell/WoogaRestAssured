package utilityClasses;

import com.google.gson.Gson;


import entities.Category;
import entities.Pet;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UtilityFunctions {

    //Gson singleton to deserialize/serialize pet objects to json
    Gson gson = new Gson();

    public UtilityFunctions(){

    }

    //This utility method is meant to be reused for getting pets with different statuses.
    public Response makeRequest(String status, String endpoint) {
        Response response =

                given()
                        .queryParam("status", status)
                        .contentType("application/json")
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

    public void Log(List<Pet> Lions){

        for(Pet lion: Lions){
            System.out.println( gson.toJson(lion));
        }

    }
}
