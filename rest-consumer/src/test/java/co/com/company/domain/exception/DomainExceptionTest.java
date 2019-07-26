package co.com.company.domain.exception;

import org.junit.Assert;
import org.junit.Test;

public class DomainExceptionTest {

    @Test
    public void domainExceptionTest() {
        //Given (Arrange)
        final String exceptionMessage = "Domain exception";
        //When (Act)
        DomainException domainException = new DomainException(exceptionMessage);
        //Then (Asser)
        Assert.assertEquals(domainException.getMessage(), exceptionMessage);
    }

}