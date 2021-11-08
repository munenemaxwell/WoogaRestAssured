package unitTests;
import static org.assertj.core.api.Assertions.*;

import entities.Pet;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilityClasses.UtilityFunctions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class PestStoreTest {

    final String endpoint = "https://petstore3.swagger.io/api/v3/pet/findByStatus";

    //initialize utility functions
    UtilityFunctions utilityFunctions=new UtilityFunctions();


    @Test
    @DisplayName("Unit test for makeRequest utility function")
    //unit test to ensure MakeRequest is able to make a get call to passed endpoint and return json content type response
    public void testmakeRequest(){
        Response response= utilityFunctions.makeRequest("available",endpoint);
        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.contentType()).isEqualTo("application/json");

    }

    @Test
    @DisplayName("Unit test for getLions utility function")
    //unit test to ensure
    public void testgetLions(){
        Response response= utilityFunctions.makeRequest("available",endpoint);
        List<Pet> Lions= utilityFunctions.getLions(response);
        assertThat(Lions.get(0)).isInstanceOf(Pet.class);

    }
}
