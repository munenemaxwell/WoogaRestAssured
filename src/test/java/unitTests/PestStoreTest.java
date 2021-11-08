package unitTests;
import static org.assertj.core.api.Assertions.*;

import Entities.Pet;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import petStore.PetStoreApiTest;

import java.util.List;

public class PestStoreTest {

    final String endpoint = "https://petstore3.swagger.io/api/v3/pet/findByStatus";

    PetStoreApiTest petStoreApiTest =new PetStoreApiTest();


    @Test
    @DisplayName("Unit test for makeRequest utility function")
    //unit test to ensure MakeRequest is able to make a get call to passed endpoint and return json content type response
    public void testmakeRequest(){
        Response response= petStoreApiTest.makeRequest("available",endpoint);
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.contentType()).isEqualTo("application/json");

    }

    @Test
    @DisplayName("Unit test for getLions utility function")
    //unit test to ensure
    public void testgetLions(){
        Response response= petStoreApiTest.makeRequest("available",endpoint);
        List<Pet> Lions= petStoreApiTest.getLions(response);
        assertThat(Lions.get(0)).isInstanceOf(Pet.class);

    }
}
