package UseDao;

import java.awt.image.BufferedImage;
import java.sql.Timestamp;

public interface UserData {

	boolean checkUser(String userName, String password);

	void DeletUser(String userName, String password);
	void insertUser(String name,String mail,String Address,String Gender,String MobNo,String city,String state,int pincode,String Qualification,String AccNo ,String UserName,String Password,String Religion,String category,String category2, int Income,String PAN,String Accupation,String Adhar,Timestamp currentTimestamp);

	BufferedImage getPhoto(String Username);

	void updateAcc(String name, String email, String address, String gender, String mobileNo, String city, String state,
			int pincode, String qualification, String username, String Password, String religion, String category, int income,Timestamp dateAndTime
			);

	double myBalance(String userName, String password);
	
	void addTransactionHostry( String senderAccNo,String RecieverAccNo,double amount,Timestamp dateTime);

	boolean transferMoney(String senderAccount, String receiverAccount, String password, double amountToTransfer);

	boolean transferMoneybyPhoneNo(String senderPhnNo, String receiverPhnNo, String password, double amountToTransfer);

	boolean transferMoneyByAadhaar(String senderAdhaar, String receiverAdhaar, String password, double amountToTransfer);
	

}
