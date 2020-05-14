import com.cabinvoicegenrator.*;
import com.cabinvoicegenrator.forenum.CabRides;
import com.cabinvoicegenrator.repoisitory.RideRepoisitory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGenratorTest {
    private InvoiceService invoiceService;
    private RideRepoisitory rideRepoisitory;
    private Ride[] rides = null;
    InvoiceSummary expectedInvoiceSummary;

    @Before
    public void intialize() {
        invoiceService = new InvoiceService();
        rideRepoisitory = new RideRepoisitory();
        invoiceService.setRideRepository(rideRepoisitory);
        rides = new Ride[]{
                new Ride(CabRides.NORMAL, 2.0, 5),
                new Ride(CabRides.PREMIUM, 0.1, 1)
        };
        expectedInvoiceSummary = new InvoiceSummary(2, 45);
    }

    @Test
    public void givenNormalRide_WhenInvoiceGenrator_ShouldReturnTotalFare() {
        rides = new Ride[]{
                new Ride(CabRides.NORMAL, 2.0, 5),
        };
        InvoiceSummary Summary = invoiceService.getTotalFare(rides);
        expectedInvoiceSummary = new InvoiceSummary(1, 25);
        Assert.assertEquals(expectedInvoiceSummary, Summary);
    }

    @Test
    public void givenNormalRides_WhenInvoiceGenrator_ShouldReturnMinimumFare() {
        rides = new Ride[]{
                new Ride(CabRides.NORMAL, 0.1, 1),
        };
        InvoiceSummary Summary = invoiceService.getTotalFare(rides);
        expectedInvoiceSummary = new InvoiceSummary(1, 5);
        Assert.assertEquals(expectedInvoiceSummary, Summary);
    }

    @Test
    public void givenPremiumRides_WhenInvoiceGenrator_ShouldReturnTotalFare() {
        rides = new Ride[]{
                new Ride(CabRides.PREMIUM, 2.0, 5),
        };
        InvoiceSummary Summary = invoiceService.getTotalFare(rides);
        expectedInvoiceSummary = new InvoiceSummary(1, 40);
        Assert.assertEquals(expectedInvoiceSummary, Summary);
    }

    @Test
    public void givenPremiumRides_WhenInvoiceGenrator_ShouldReturnMinimumFare() {
        rides = new Ride[]{
                new Ride(CabRides.PREMIUM, 0.1, 2),
        };
        InvoiceSummary Summary = invoiceService.getTotalFare(rides);
        expectedInvoiceSummary = new InvoiceSummary(1, 20);
        Assert.assertEquals(expectedInvoiceSummary, Summary);
    }

    @Test
    public void givenMultipleRidesForPremium_WhenInvoiceGenrator_ShouldReturnInvoiceSummar() {
        rides = new Ride[]{
                new Ride(CabRides.PREMIUM, 2.0, 5),
                new Ride(CabRides.PREMIUM, 2.0, 1)
        };
        InvoiceSummary Summary = invoiceService.getTotalFare(rides);
        expectedInvoiceSummary = new InvoiceSummary(2, 72);
        Assert.assertEquals(expectedInvoiceSummary, Summary);
    }

    @Test
    public void givenMultipleRidesForNormal_WhenInvoiceGenrator_ShouldReturnInvoiceSummar() {
        rides = new Ride[]{
                new Ride(CabRides.NORMAL, 2.0, 5),
                new Ride(CabRides.NORMAL, 2.0, 1)
        };
        InvoiceSummary Summary = invoiceService.getTotalFare(rides);
        expectedInvoiceSummary = new InvoiceSummary(2, 46);
        Assert.assertEquals(expectedInvoiceSummary, Summary);
    }

    @Test
    public void givenMultipleRides_WhenInvoiceGenrator_ShouldReturnInvoiceSummary() {
        rides = new Ride[]{
                new Ride(CabRides.NORMAL, 2.0, 5),
                new Ride(CabRides.PREMIUM, 0.1, 1),
                new Ride(CabRides.NORMAL, 2.0, 5),
                new Ride(CabRides.PREMIUM, 0.1, 1)
        };
        InvoiceSummary Summary = invoiceService.getTotalFare(rides);
        expectedInvoiceSummary = new InvoiceSummary(4, 90);
        Assert.assertEquals(expectedInvoiceSummary, Summary);
    }

    @Test
    public void givenUserIdAndRides_WhenInvoiceGenrator_ShouldReturnInvoiceSummary() {
        String userId = "dhiraj@123";
        invoiceService.addRides(userId, rides);
        rides = new Ride[]{
                new Ride(CabRides.NORMAL, 2.0, 5),
                new Ride(CabRides.PREMIUM, 0.1, 1),
                new Ride(CabRides.NORMAL, 2.0, 5),
                new Ride(CabRides.PREMIUM, 0.1, 1)
        };
        InvoiceSummary Summary = invoiceService.getInvoiceSummary(userId);
        expectedInvoiceSummary = new InvoiceSummary(2, 45);
        Assert.assertEquals(expectedInvoiceSummary, Summary);
    }
}




