package ToDo;

import java.util.ArrayList;

import ToDo.ListDB;
import model.Todolist;
import model.Status;
import model.Todouser;

public class ListInterfece {

	ListDB db = new ListDB();
	
	public boolean isUserExist(String userName){
		boolean isExist = false;
		
		Todouser t = db.getProfile(userName);
		if (t != null){
			isExist = true;
		}
		
		return isExist;
	}
	
	public boolean isUserMatching(String userName, String pwd)
	{
		boolean isExist = false;
		
		Todouser t = db.getProfile(userName, pwd);
		if (t != null){
			isExist = true;
		}
		
		return isExist;
	}
	
	public boolean createNewAccount(String userName, String password){
		boolean isSuccess = false;
		
		//create new account
		if(db.createNewUser(userName, password)){
			isSuccess = true;
		}
		
		return isSuccess;
		
	}
	public ArrayList<Todolist> pullProduct(String userName){
		ArrayList<Todolist> ProductsList= new ArrayList<Todolist>();
			ListDB WD = new ListDB();
			ProductsList= WD.getAllProducts(userName);
			
			return ProductsList;
	}
	
	
	
}
