package co.com.company.infrastructure.restcontroller.exception;

import org.junit.Assert;
import org.junit.Test;

public class TechnicalExceptionTest {

    @Test
    public void technicalExceptionTest() {
        //Given (Arrange)
        final String exceptionMessage = "Technical exception";
        //When (Act)
        final TechnicalException technicalException = new TechnicalException(exceptionMessage);
        //Then (Asser)
        Assert.assertNotNull(technicalException);
        Assert.assertEquals(technicalException.getMessage(),exceptionMessage);
    }

    @Test
    public void technicalExceptionThrowableTest() {
        //Given (Arrange)
        final String exceptionMessage = "Technical exception";
        final Throwable exception = new Exception();
        //When (Act)
        final TechnicalException technicalException = new TechnicalException(exceptionMessage, exception);
        //Then (Asser)
        Assert.assertEquals(technicalException.getMessage(),exceptionMessage);
        Assert.assertEquals(technicalException.getCause(),exception);
    }
}