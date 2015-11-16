package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TODOUSER database table.
 * 
 */
@Entity
@Table(name="Todouser", schema="testuserdb")
@NamedQuery(name="Todouser.findAll", query="SELECT t FROM Todouser t")
public class Todouser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String pwd;

	private BigDecimal userid;

	//bi-directional many-to-one association to Todolist
	@OneToMany(mappedBy="todouser")
	private List<Todolist> todolists;

	public Todouser() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public BigDecimal getUserid() {
		return this.userid;
	}

	public void setUserid(BigDecimal userid) {
		this.userid = userid;
	}

	public List<Todolist> getTodolists() {
		return this.todolists;
	}

	public void setTodolists(List<Todolist> todolists) {
		this.todolists = todolists;
	}

	public Todolist addTodolist(Todolist todolist) {
		getTodolists().add(todolist);
		todolist.setTodouser(this);

		return todolist;
	}

	public Todolist removeTodolist(Todolist todolist) {
		getTodolists().remove(todolist);
		todolist.setTodouser(null);

		return todolist;
	}

}