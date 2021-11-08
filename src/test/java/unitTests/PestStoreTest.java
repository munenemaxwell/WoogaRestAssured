package unitTests;
import static org.assertj.core.api.Assertions.*;

import Entities.Pet;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import petStore.PetStoreApi;

import java.util.List;

public class PestStoreTest {

    final String endpoint = "https://petstore3.swagger.io/api/v3/pet/findByStatus";

    PetStoreApi petStoreApi=new PetStoreApi();


    @Test
    //unit test to ensure MakeRequest is able to make a get call to passed endpoint and return json content type response
    public void testmakeRequest(){
        Response response=petStoreApi.makeRequest("available",endpoint);
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.contentType()).isEqualTo("application/json");

    }

    @Test
    //unit test to ensure
    public void testgetLions(){
        Response response=petStoreApi.makeRequest("available",endpoint);
        List<Pet> Lions=petStoreApi.getLions(response);
        assertThat(Lions.get(0)).isInstanceOf(Pet.class);

    }
}
