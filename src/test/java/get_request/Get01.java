package get_request;

import io.restassured.response.Response;
import org.apache.http.io.SessionOutputBuffer;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    1)Postman, manuel API testleri icin kullandik,
    2)otomasyon testleri icin de Rest Assured Library kullanacagiz.
    3)Otomasyon testlerimizi yaparken asagidaki adimlari izliyoruz:
       a)Gereksinimleri anlamak
       b)Test case yaziyoruz
          i)Test case yaziminda "Gherkin" dilini kullanacagiz.Bizler yazilim diline hakim olsak ta karsimizdaki
          kisiler hakim olmayabilir ama Gherkin ile yazilan testleri anlamakta zorluk cekmeyecekleridir
          Gherkin dilinde kullanacagimiz keywordler:

          -Given : On kosullar
          -When  : Yapilacak aksiyonlar icin(get(), put(), post(),patch(), ve delete())
          -Then : Istek yaptiktan (rquest gonderdikten sonra) dogrulama
          -And : Coklu islemlerde kullanacagiz

        c)Test kodlarimizi yazmaya baslayacagiz
           i) Set the URL
           ii)Set the expected Data (beklenen datanin olusturulmasi,Post ,Put, Patch)
           iii)Type code to send request(Talep gondermek icin yazilan kod yazimi)
           iv)Do Assertion(Dogrulama yapmak)

     */
    /*
     Given
           https://restful-booker.herokuapp.com/booking/101
        When
           User sends a GET Request to the url
        Then
           HTTP Status Code should be 200
        And
          Content Type should be JSON
        And
          Status Line should be HTTP/1.1 200 OK
 */

    @Test
    public void get01(){
        // i) Set the URL
        String url="https://restful-booker.herokuapp.com/booking/101";

        //  ii)Set the expected Data (beklenen datanin olusturulmasi,Post ,Put, Patch)
        //Bizden post, put ya da patch istenmedigi icin bu case de kullanmayacagiz

       // iii)Type code to send request(Talep gondermek icin yazilan kod yazimi)

        Response response=given().when().get(url);
        response.prettyPrint();

        // iv)Do Assertion(Dogrulama yapmak)
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        //Status code konsola yazdiralim
        System.out.println("Status code :"+response.getStatusCode());

        //Content type konsola yazdiralim
        System.out.println("Content type : "+response.getContentType());

        //status line konsola yazdiralim
        System.out.println("Status line :"+response.getStatusLine());

        //header konsola yazdiralim
        System.out.println("Header :"+response.getHeader("Server"));

        //headers konsola yazdiralim
        System.out.println("Headers :"+response.getHeaders());

        //time konsola yazdiralim
        System.out.println("Time : "+response.getTime());



    }
}
