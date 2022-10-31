
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class Task3Tests {
  String URL = "https://bookstore.toolsqa.com/BookStore/v1/Books";

  @Test
  public void getStatusCode() {
    get(URL).then().assertThat().statusCode(200);
  }

  @Test
  public void checkLastBook() {
    get(URL).then().body("books[-1].isbn", equalTo("9781593277574"));
  }

  @Test
  public void checkPageCount() {
    get(URL).then().body("books[0].pages", equalTo(234), "books[1].pages", equalTo(254));
  }

}
