package org.ta_selenium.utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class ApiController {
    private static final String baseUrl = "https://demoqa.com";
    private static final String userId = "a9f756d2-b762-49ef-add3-892bb496a974";

    public ApiController() {
        //for this use case this constructor can be empty
    }

    private String createBooksPayload() {
        return "{\n" +
                "  \"userId\": \"" + userId + "\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\"isbn\": \"9781449325862\"},\n" +
                "    {\"isbn\": \"9781491950296\"},\n" +
                "    {\"isbn\": \"9781491904244\"}\n" +
                "  ]\n" +
                "}";
    }

    public void addBooks() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Basic VGVzdEF1dG9tYXRpb246KlRhX0phdmEw")
                .body(createBooksPayload())
                .post(baseUrl + "/BookStore/v1/Books");
    }

    public void deleteBooks() {
        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .header("Authorization", "Basic VGVzdEF1dG9tYXRpb246KlRhX0phdmEw")
                .delete(baseUrl + "/BookStore/v1/Books?UserId=" + userId);
        if (response.getStatusCode() != 204 && response.getStatusCode() != 404) {
            throw new RuntimeException("Failed to delete books: " + response.getStatusLine());
        }
    }

}