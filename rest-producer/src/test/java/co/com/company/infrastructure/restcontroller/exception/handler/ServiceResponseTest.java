package co.com.company.infrastructure.restcontroller.exception.handler;

import org.junit.Assert;
import org.junit.Test;

public class ServiceResponseTest {

    @Test
    public void serviceResponseTest() {
        //Given (Arrange)
        final int code = 400;
        final String event = "Exception";
        final String message = "Bad Request";
        //When (Act)
        final ServiceResponse serviceResponse = new ServiceResponse(code, event, message);
        //Then (Asser)
        Assert.assertEquals(serviceResponse.getCode(), code);
        Assert.assertEquals(serviceResponse.getEvent(), event);
        Assert.assertEquals(serviceResponse.getMessage(), message);
    }
}
