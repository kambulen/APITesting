package Tests.Dogs;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.*;
import static Common.RequestBuilder.getListsOfAllBreeds;
import static Common.RequestBuilder.*;
import static org.hamcrest.Matchers.containsStringIgnoringCase;


@Test
@Feature("DogsApi")
@Story("Get List of All Breeds")

public class DogsAPITests {
    @Description("As an API user I want to get a list of all Breeds")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllBreedsTest() {
        getListsOfAllBreeds().
                then().
                assertThat().
                statusCode(Retrieve_Data_Status_Code);
    }

    @Description("As an API user I want to get list of Random Breeds")
    @Severity(SeverityLevel.CRITICAL)

    public void getRandomBreedsTest() {
        getRandomBreeds().
                then().
                assertThat().
                statusCode(Retrieve_Data_Status_Code);
    }

    @Description("As an API user I want to get a list of Dogs by breed")
    @Severity(SeverityLevel.BLOCKER)

    public void getDogsByBreedTest() {
        getDogsbyBreeds().
                then().
                assertThat().
                statusCode(Retrieve_Data_Status_Code);
    }

    @Description("As an API user I want to get a list of All Sub-Breeds")
    @Severity(SeverityLevel.BLOCKER)

    public void getDogsBySubBreed() {
        getListOfSubBreeds().
                then().
                assertThat().
                statusCode(Retrieve_Data_Status_Code);
    }

    @Description("As an API user I want to get the list of all list using an incorrect URL")
    @Severity(SeverityLevel.CRITICAL)

    public void getDogsListInvalidURl() {
        getListsOfAllBreedsNegative().
                then().
                assertThat().
                statusCode(Invalid_URL).
                body("status", containsStringIgnoringCase("error"));
    }

}
