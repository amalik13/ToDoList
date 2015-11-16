package ToDo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import model.Status;
import model.Todolist;
import model.Todouser;
import ToDo.DBUtil;

public class ListDB {

	public Todouser getProfile(String username){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Todouser usr = null;
		
		try {
			String sql = "select u from Todouser u where u.username = :username";
			TypedQuery<Todouser> q = em.createQuery(sql, Todouser.class);
			q.setParameter("username", username);
			
			usr = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return usr;
	}
	
	
	
	public Todouser getProfile(String username, String pwd){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Todouser usr = null;
		
		try {
			String sql = "select u from Todouser u where u.username = :username and u.pwd = :pwd";
			TypedQuery<Todouser> q = em.createQuery(sql, Todouser.class);
			q.setParameter("username", username);
			q.setParameter("pwd", pwd);
			
			usr = q.getSingleResult();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return usr;
	}
	
	
	public boolean createNewUser(String username, String pwd){
		boolean isSuccess = false;
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		Todouser user = new Todouser();
		user.setPwd(pwd);
		user.setUsername(username);
		
		
		trans.begin();
		
		try{
			em.persist(user);
			trans.commit();
			isSuccess = true;
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally{
			em.close();
		}
		
		return isSuccess;
	}
	
	
/*	public ArrayList<Adminproduct> getAllUsers(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Adminproduct> fd = null;
		
		try {
			String sql = "select t from Adminproduct t";
			TypedQuery<Adminproduct> results = em.createQuery(sql, Adminproduct.class);
			
			fd = results.getResultList();
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
		
		return new ArrayList<Adminproduct>(fd);
	}
		*/
		/*public void InsertRecords(String id, String desc, String CompDate, String DueDate,String SID, String priority, String username, String totalCost){
			boolean isSuccess = false;
			
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			
			Todolist list = new Todolist();
			user.setTotalprice(totalCost);;
			user.setUsername(username);
			
			trans.begin();
			
			try{
				em.persist(user);
				trans.commit();
				isSuccess = true;
			}catch(Exception e){
				System.out.println(e);
				trans.rollback();
			}finally{
				em.close();
			}
			
			
		}*/
		
		
		
		public ArrayList<Todolist> getAllProducts( String username){
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			List<Todolist> fd = null;
			
			try {
				String sql1 = "select u.todolists from Todouser u where u.username = :username";
				TypedQuery<Todolist> q1 = em.createQuery(sql1, Todolist.class);
				q1.setParameter("username", username);
				
				/*String sql = "select u from Todolist u where u.todouser = :username";
				TypedQuery<Todolist> results = em.createQuery(sql, Todolist.class);
				results.setParameter("username", username);
				*/
				
				fd = q1.getResultList();
				
			} catch (Exception e){
				System.out.println(e);
			} finally {
				em.close();
			}
			
			return new ArrayList<Todolist>(fd);
		}
	
	
}
