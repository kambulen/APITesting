package Tests.Dogs;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.*;
import static Common.RequestBuilder.getListsOfAllBreeds;
import static Common.RequestBuilder.*;


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
                statusCode(Retrieve_Employee_Status_Code);
    }

    @Test
    public static class DogsAPIGetRandomTest {
        @Description("As an API user I want to get list of Random Breeds")
        @Severity(SeverityLevel.CRITICAL)

        public void getRandomBreedsTest() {
            getRandomBreeds().
                    then().
                    assertThat().
                    statusCode(Retrieve_Employee_Status_Code);
        }

        @Test
        public static class DogsAPIGetDogByBreedTest {
            @Description("As an API user I want to get a list of Dogs by breed")
            @Severity(SeverityLevel.BLOCKER)

            public void getDogsByBreedTest(){
                getDogsbyBreeds().
                        then().
                        assertThat().
                        statusCode(Retrieve_Employee_Status_Code);
            }

            @Test
            public static class DogsAPIGetSubBreeds {
                @Description("As an API user I want to get a list of All Sub-Breeds")
                @Severity(SeverityLevel.BLOCKER)

                public void getDogsBySubBreed(){
                    getListOfSubBreeds().
                            then().
                            assertThat().
                            statusCode(Retrieve_Employee_Status_Code);
                }
            }
        }

    }


}
