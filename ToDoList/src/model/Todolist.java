package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TODOLIST database table.
 * 
 */
@Entity
@Table(name="ToDoList", schema="testuserdb")
@NamedQuery(name="Todolist.findAll", query="SELECT t FROM Todolist t")
public class Todolist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long tid;

	private String completedate;

	private String description;

	private String duedate;

	private String priority;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="SID")
	private Status status;

	//bi-directional many-to-one association to Todouser
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private Todouser todouser;

	public Todolist() {
	}

	public long getTid() {
		return this.tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getCompletedate() {
		return this.completedate;
	}

	public void setCompletedate(String completedate) {
		this.completedate = completedate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuedate() {
		return this.duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Todouser getTodouser() {
		return this.todouser;
	}

	public void setTodouser(Todouser todouser) {
		this.todouser = todouser;
	}

}