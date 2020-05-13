import com.cabinvoicegenrator.InvoiceService;
import com.cabinvoicegenrator.InvoiceSummary;
import com.cabinvoicegenrator.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGenratorTest
{
    InvoiceService invoiceService=null;

    @Before
    public void setup() {
        invoiceService = new InvoiceService();
    }

    /* T.c 1.1;-Given Distance And Time Should Return Total Fare*/
    @Test
    public void givenDistanceAndTime_WhenInvoiceGenrator_ShouldReturnTotalFare()
    {
        double distance=4.0;
        int time=5;
        double fare=invoiceService.calculateFare(distance,time);
        Assert.assertEquals(45,fare,0.0);
    }

    /* T.c 1.2;-Given Distance And Time Should Return Minimum Fare*/
    @Test
    public void givenMinDistanceAndTime_WhenInvoiceGenrator_ShouldReturnMinFare()
    {
        double distance=0.1;
        int time=1;
        double fare=invoiceService.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }

    /* T.c 2,3:-Calculate Total Fare,Num Of Ride,Avg Fare Per Ride For Multiple Rides */
    @Test
    public void givenMultipleRides_WhenInvoiceGenrator_ShouldReturnInvoiceSummary()
    {
        Ride[]rides={new Ride(4.0,5),new Ride(0.1,1)};
        InvoiceSummary Summary=invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,50);
        Assert.assertEquals(expectedInvoiceSummary,Summary);
    }
    /* T.c 4:-Given User Id Invoice Service Get List Of Ride */
    @Test
    public void givenUserIdAndRides_WhenInvoiceGenrator_ShouldReturnInvoiceSummary()
    {
        String userId="dhiraj@123";
        Ride[]rides={new Ride(4.0,5),new Ride(0.1,1)};
        invoiceService.addRides(userId,rides);
        InvoiceSummary Summary=invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,50);
        Assert.assertEquals(expectedInvoiceSummary,Summary);
    }
}
