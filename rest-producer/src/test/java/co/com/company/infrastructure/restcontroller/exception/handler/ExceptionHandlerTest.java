package co.com.company.infrastructure.restcontroller.exception.handler;

import co.com.company.domain.exception.DomainException;
import co.com.company.infrastructure.restcontroller.exception.TechnicalException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionHandlerTest {

    @Test
    public void domainExceptionHandlerTest() {
        //Given (Arrange)
        final ExceptionHandler exceptionHandler = new ExceptionHandler();
        final String exceptionNameExpected = DomainException.class.getSimpleName();
        final String messageExpected = "Domain exception";
        final HttpStatus statusExpected = HttpStatus.BAD_REQUEST;
        final ServiceResponse responseExpected = new ServiceResponse(statusExpected.value(), exceptionNameExpected, messageExpected);
        final ResponseEntity<ServiceResponse> responseEntityExpected =  new ResponseEntity<>(responseExpected, statusExpected);
        //When (Act)
        final DomainException domainException = new DomainException(messageExpected);
        final ResponseEntity<ServiceResponse> responseEntity = exceptionHandler.handleAllExceptions(domainException);
        //Then (Asser)
        Assert.assertEquals(responseEntity.getStatusCode(), responseEntityExpected.getStatusCode());
        Assert.assertEquals(responseEntity.getStatusCodeValue(), responseEntityExpected.getStatusCodeValue());
        Assert.assertEquals(responseEntity.getBody().getMessage(), responseEntityExpected.getBody().getMessage());
    }

    @Test
    public void technicalExceptionHandlerTest() {
        //Given (Arrange)
        final ExceptionHandler exceptionHandler = new ExceptionHandler();
        final String exceptionNameExpected = TechnicalException.class.getSimpleName();
        final String messageExpected = "Ha ocurrido un error en el servidor, por favor contacte al administrador";
        final HttpStatus statusExpected = HttpStatus.INTERNAL_SERVER_ERROR;
        final ServiceResponse responseExpected = new ServiceResponse(statusExpected.value(), exceptionNameExpected, messageExpected);
        final ResponseEntity<ServiceResponse> responseEntityExpected =  new ResponseEntity<>(responseExpected, statusExpected);
        //When (Act)
        final TechnicalException technicalException = new TechnicalException(messageExpected);
        final ResponseEntity<ServiceResponse> responseEntity = exceptionHandler.handleAllExceptions(technicalException);
        //Then (Asser)
        Assert.assertEquals(responseEntity.getStatusCode(), responseEntityExpected.getStatusCode());
        Assert.assertEquals(responseEntity.getStatusCodeValue(), responseEntityExpected.getStatusCodeValue());
        Assert.assertEquals(responseEntity.getBody().getMessage(), responseEntityExpected.getBody().getMessage());
    }
}
