import io.cucumber.java.en.*;

public class MyStepdefs {
    @Given("today is Sunday")
    public void todayIsSunday() {
        System.out.println("todayIsSunday");
    }

    @When("I ask whether it's Friday yet")
    public void iAskWhetherItSFridayYet() {
        System.out.println("iAskWhetherItSFridayYet");
    }

    @Then("I should be told {string}")
    public void iShouldBeTold(String arg0) {
        System.out.println("iShouldBeTold");
    }
}
