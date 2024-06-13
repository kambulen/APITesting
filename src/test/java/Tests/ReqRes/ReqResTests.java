package Tests.ReqRes;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.*;
import static Common.RequestBuilder.*;
import static org.hamcrest.Matchers.*;


@Test
@Feature("ReqRes")
@Story("Create new employee")
public class ReqResTests {

    @Description("As an api user i want to create a new employee")
    @Severity(SeverityLevel.CRITICAL)
    public void createEmployeeTests() {
        createEmployeeResponse().
                then().
                assertThat().
                statusCode(Create_Success_Status_Code).
                body("name", containsStringIgnoringCase("Nkosi")).
                body("job", containsStringIgnoringCase("Test")).
                body("id", notNullValue()).
                body("createdAt", notNullValue());

    }

    @Test
    @Feature("ReqRes")
    @Story("Get Employee List")
    public static class ReqResGetTests {

        @Description("As an API user I want to retrieve data of the all employee details ")
        @Severity(SeverityLevel.TRIVIAL)
        public void getEmployeeDetailsTests() {
            getEmployeedetailsReponse().
                    then().
                    assertThat().
                    statusCode(Retrieve_Employee_Status_Code).
                    body("page", notNullValue()).
                    body("per_page", notNullValue());
        }

        @Test
        @Feature("ReqRes")
        @Story("Update the details of the recently created employee")
        public static class ReqResPutTests {

            @Description("As an API user I want to update details for the recently created employee")
            @Severity(SeverityLevel.BLOCKER)
            public void updateEmployeeDetailsTest() {
                updateEmployeeResponse().
                        then().
                        assertThat().
                        statusCode(Retrieve_Employee_Status_Code).
                        body("job", notNullValue()).
                        body("name", notNullValue()).
                        body("surname", notNullValue());
            }

            @Test
            @Feature("ReqRes")
            @Story("Patch the details of an employee")
            public static class ReqResPatchTests {
                @Description("As an API user I want to Patch the recently created employee details")
                @Severity(SeverityLevel.CRITICAL)
                public void patchEmployeeDetailsTest() {
                    patchEmployeeResponse().
                            then().
                            assertThat().
                            statusCode(Retrieve_Employee_Status_Code).
                            body("name", containsStringIgnoringCase("morpheuspatch")).
                            body("job", containsStringIgnoringCase("zion residentpatch")).
                            body("updatedAt", notNullValue());

                }

                @Test
                @Feature("ReqRes")
                @Story("Delete Employee")
                public static class ReqResDeleteTest {
                    @Description("As an API user I want to delete the recently created employee")
                    @Severity(SeverityLevel.NORMAL)
                    public void deleteEmployeeTest() {
                        deleteEmployeedetailsReponse().
                                then().
                                assertThat().
                                statusCode(Delete_Employee_Status_code);
                    }
                }

            }
        }

    }
}
