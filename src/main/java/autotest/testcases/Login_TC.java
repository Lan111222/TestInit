package autotest.testcases;

public class Login_TC extends CommonBase{

	public Login_TC() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void login_success() {
		this.startBrower("", "chrome");
		
		this.pause(10);
		
		this.closeBrower(getDriver());
	}

}
