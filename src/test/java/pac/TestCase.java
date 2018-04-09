package pac;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.yto.pac.http.HttpHelper;

public class TestCase {
	@Test
	public void test1()
	{
		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
		System.out.println(cal.getTimeInMillis());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.setTime(new Date());
		System.out.println(cal.getTimeInMillis());
		
		
	}
	
	@Test
	public void test2()
	{
//		System.out.println(HttpHelper.getMethodName("name"));
		
		StringBuffer sb = new StringBuffer();
		sb.append("asldkfa;");
		System.out.println(sb.substring(0,sb.length()-1));
	}
}
