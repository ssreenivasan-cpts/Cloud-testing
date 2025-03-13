package utilities;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class TestHostAdd {

	public static String messagebody;
	public static void main(String[] args) throws MessagingException {
		
	
		MonitoringMail mail = new MonitoringMail();
		 
		try {
			messagebody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/CLO-Testing/Extent_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messagebody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

