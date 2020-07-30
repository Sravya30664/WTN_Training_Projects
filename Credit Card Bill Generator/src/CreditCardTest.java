import static org.junit.Assert.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import java.util.Date;
import com.wipro.ccbill.entity.CreditCardBill;
import com.wipro.ccbill.entity.Transaction;
import com.wipro.ccbill.exception.InputValidationException;
public class CreditCardTest {
	static SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
	private String creditCardNo;
	private String customerId;
	private Date billDate;
	private Transaction monthTransactions[];
	CreditCardBill cbill;
	//CreditCardBill cbill;
	/*@Before
	public void init(){
		Transaction monthTransaction[]=new Transaction[5];
		try {
			monthTransaction[0]=new Transaction("1111222233334444",formatter.parse("01/02/2016"),"household",8000.0,"DB");

			monthTransaction[1]=new Transaction("1111222233334444",formatter.parse("05/02/2016"),"Textile",12000.0,"DB");

			monthTransaction[2]=new Transaction("1111222233334444",formatter.parse("12/02/2016"),"movie",2700.0,"DB");

			monthTransaction[3]=new Transaction("1111222233334444",formatter.parse("16/02/2016"),"paid",19000.0,"CR");

			monthTransaction[4]=new Transaction("1111222233334444",formatter.parse("19/02/2016"),"household",4500.0,"DB");

			CreditCardBill ccbill=new CreditCardBill("1111222233334444","ABC123",formatter.parse("02/03/2016"),monthTransaction);
			
			cbill=new CreditCardBill("1111222233334444","ABC123",formatter.parse("02/03/2016"),monthTransaction);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			}*/

	

	@Test
	public void calculateBillAmountTest() {
		Transaction monthTransaction[]=new Transaction[5];
		try {
			monthTransaction[0]=new Transaction("1111222233334444",formatter.parse("01/02/2016"),"household",8000.0,"DB");

			monthTransaction[1]=new Transaction("1111222233334444",formatter.parse("05/02/2016"),"Textile",12000.0,"DB");

			monthTransaction[2]=new Transaction("1111222233334444",formatter.parse("12/02/2016"),"movie",2700.0,"DB");

			monthTransaction[3]=new Transaction("1111222233334444",formatter.parse("16/02/2016"),"paid",19000.0,"CR");

			monthTransaction[4]=new Transaction("1111222233334444",formatter.parse("19/02/2016"),"household",4500.0,"DB");

			cbill=new CreditCardBill("1111222233334444","ABC123",formatter.parse("02/03/2016"),monthTransaction);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(8335.983333333334,cbill.calculateBillAmount(),0);
	}
	@Test
	public void validateDateTest() throws InputValidationException {
		
		Transaction monthTransaction[]=new Transaction[5];
		try {
			monthTransaction[0]=new Transaction("1111222233334444",formatter.parse("01/02/2016"),"household",8000.0,"DB");

			monthTransaction[1]=new Transaction("1111222233334444",formatter.parse("05/02/2016"),"Textile",12000.0,"DB");

			monthTransaction[2]=new Transaction("1111222233334444",formatter.parse("12/02/2016"),"movie",2700.0,"DB");

			monthTransaction[3]=new Transaction("1111222233334444",formatter.parse("16/02/2016"),"paid",19000.0,"CR");

			monthTransaction[4]=new Transaction("1111222233334444",formatter.parse("19/02/2016"),"household",4500.0,"DB");

			 cbill=new CreditCardBill("1111222233334444","ABC123",formatter.parse("02/03/2016"),monthTransaction);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("valid",cbill.validateDate());
	}
	@Test
	public void getAmountTest() {
		Transaction monthTransaction[]=new Transaction[5];
		try {
			monthTransaction[0]=new Transaction("1111222233334444",formatter.parse("01/02/2016"),"household",8000.0,"DB");

			monthTransaction[1]=new Transaction("1111222233334444",formatter.parse("05/02/2016"),"Textile",12000.0,"DB");

			monthTransaction[2]=new Transaction("1111222233334444",formatter.parse("12/02/2016"),"movie",2700.0,"DB");

			monthTransaction[3]=new Transaction("1111222233334444",formatter.parse("16/02/2016"),"paid",19000.0,"CR");

			monthTransaction[4]=new Transaction("1111222233334444",formatter.parse("19/02/2016"),"household",4500.0,"DB");

			 cbill=new CreditCardBill("1111222233334444","ABC123",formatter.parse("02/03/2016"),monthTransaction);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(27200.0,cbill.getTotalAmount("DB"),0);
	}
}
