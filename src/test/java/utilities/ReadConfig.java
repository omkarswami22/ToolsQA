package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		// String fileName = System.getProperty("user.dir") +
		// "\\src\\test\\resources\\config.properties";

		File src = new File("./configuretion\\Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

// Text Box Inputs
	public String geturl() {
		String url = pro.getProperty("BaseUrl");
		return url;
	}

	public String BrowserName() {

		String Browsername = pro.getProperty("BrowserName");
		return Browsername;
	}

	public String getDriverGecko() {
		String gekod = pro.getProperty("geckodriver");
		return gekod;
	}

	public String UserName() {
		String UserName = pro.getProperty("username");
		return UserName;
	}

	public String EmailR() {
		String Email = pro.getProperty("Email");
		return Email;
	}

	public String Exetime() {
		String Executiontime = pro.getProperty("extimeout");
		return Executiontime;
	}

	public String Current_Adress() {
		String CurrentAdress = pro.getProperty("CurrentAdress");
		return CurrentAdress;
	}

	public String PermanentAddress() {
		String permanentAddress = pro.getProperty("permanentAddress");
		return permanentAddress;
	}

// For Web Table Inputs
	public String FirstName() {
		String FirstName = pro.getProperty("FirstName");
		return FirstName;
	}

	public String LastName() {
		String LastName = pro.getProperty("lastName");
		return LastName;
	}

	public String EamilForWebTable() {
		String EamilTable = pro.getProperty("emailForWebTable");
		return EamilTable;
	}

	public String Age() {
		String Age = pro.getProperty("age");
		return Age;
	}

	public String Salary() {
		String Salary = pro.getProperty("salary");
		return Salary;
	}

	public String Department() {
		String Department = pro.getProperty("department");
		return Department;
	}

	// Upload and Download
	public String upload() {
		String Upload = pro.getProperty("Upload");
		return Upload;
	}

	// FormsInput
	public String firstN() {
		String firstN = pro.getProperty("FirstName1");
		return firstN;
	}

	public String lastN() {
		String lastN = pro.getProperty("LastName1");
		return lastN;
	}

	public String Email() {
		String Email = pro.getProperty("EMAIL1");
		return Email;
	}

	public String MoNo() {
		String MoNo = pro.getProperty("MobileNumber");
		return MoNo;
	}

	public String Subject() {
		String Subject = pro.getProperty("subject");
		return Subject;
	}

	public String Path() {
		String Path = pro.getProperty("Path");
		return Path;
	}

	public String CurrentAdd() {
		String CurrentAdd = pro.getProperty("CurrentAdd");
		return CurrentAdd;
	}

	public String State() {
		String State1 = pro.getProperty("state");
		return State1;
	}

	public String City() {
		String City = pro.getProperty("city");
		return City;
	}

}
