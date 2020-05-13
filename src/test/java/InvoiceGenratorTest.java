import com.cabinvoicegenrator.InvoiceGenrator;
import com.cabinvoicegenrator.Ride;
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

    /* T.c 1.1;-Given Distance And Time Should Return Total Fare*/
    @Test
    public void givenDistanceAndTime_WhenInvoiceGenrator_ShouldReturnTotalFare()
    {
        double distance=4.0;
        int time=5;
        double fare=invoiceGenrator.calculateFare(distance,time);
        Assert.assertEquals(45,fare,0.0);
    }

    /* T.c 1.2;-Given Distance And Time Should Return Minimum Fare*/
    @Test
    public void givenMinDistanceAndTime_WhenInvoiceGenrator_ShouldReturnMinFare()
    {
        double distance=0.1;
        int time=1;
        double fare=invoiceGenrator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }

    /* T.c 2:-Calculate Total Fare For Multiple Rides */
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary()
    {
        Ride[]rides={new Ride(4.0,5),new Ride(0.1,1)};
        double fare=invoiceGenrator.calculateFare(rides);
        Assert.assertEquals(50,fare,0.0);
    }
}
