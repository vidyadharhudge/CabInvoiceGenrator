import com.cabinvoicegenrator.InvoiceGenrator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGenratorTest
{

    InvoiceGenrator invoiceGenrator=null;

    @Before
    public void setup() {
        invoiceGenrator = new InvoiceGenrator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare()
    {
        double distance=4.0;
        int time=5;
        double fare=invoiceGenrator.calculateFare(distance,time);
        Assert.assertEquals(45,fare,0.0);
    }
}
