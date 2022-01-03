package co.com.sofka.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class PeticionStepDefinition extends ReqresIn {

    private static final Logger log = Logger.getLogger(PeticionStepDefinition.class);

    private RequestSpecification consultar;
    private Response resultadoConsulta;

    private RequestSpecification eliminar;
    private Response resultadoEliminar;

    @Given("el usuario está en la página get")
    public void elUsuarioEstáEnLaPáginaGet () {
        try{
            generalSetup();
            consultar = given();
        }catch (Exception e){
            log.warn(e);
        }
    }

    @When("cuando el usuario hace una petición get")
    public void cuandoElUsuarioHaceUnaPeticiónGet () {
        try {
            resultadoConsulta = consultar.get(RESOURCE_ONE);
        }catch (Exception e){
            log.warn(e);
        }
    }

    @Then("el usuario deberá ver un mensaje con llaves vacias")
    public void elUsuarioDeberáVerUnMensajeConLlavesVacias () {
        try{
            String resultado = resultadoConsulta
                    .then()
                    .extract()
                    .asString();
            log.info(resultado);
            Assertions.assertEquals("{}", resultado);
        }catch (Exception e){
            log.warn(e);
        }
    }

    @Given("el usuario está en la página delete")
    public void elUsuarioEstáEnLaPáginaDelete () {
        try{
            generalSetup();
            eliminar = given();
        }catch (Exception e){
            log.warn(e);
        }
    }

    @When("cuando el usuario hace una petición delete")
    public void cuandoElUsuarioHaceUnaPeticiónDelete () {
        try{
            resultadoEliminar = eliminar.delete(RESOURCE_TWO);
        }catch (Exception e){
            log.warn(e);
        }
    }

    @Then("el usuario deberá ver un codigo de código de respuesta")
    public void elUsuarioDeberáVerUnCodigoDeCódigoDeRespuesta () {
        try{
            resultadoEliminar
                    .then()
                    .statusCode(HttpStatus.SC_NO_CONTENT);
        }catch (Exception e){
            log.warn(e);
        }
    }
}
