import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestApi {

    @Test
    public void testeApi() {
        int status = RestAssured
                .get("https://jsonplaceholder.typicode.com/users")
                .getStatusCode();

        assertEquals(200, status);
    }
}