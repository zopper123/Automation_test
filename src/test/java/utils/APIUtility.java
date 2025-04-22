package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.Map;

public class APIUtility {

    public static Response get(String url) {
        return given().when().get(url);
    }

    public static Response post(String url, Object body) {
        return given().header("Content-Type", "application/json").body(body).when().post(url);
    }

    public static Response put(String url, Object body) {
        return given().header("Content-Type", "application/json").body(body).when().put(url);
    }

    public static Response delete(String url) {
        return given().when().delete(url);
    }

    public static Response getWithParams(String url, Map<String, ?> params) {
        return given().params(params).when().get(url);
    }
}
