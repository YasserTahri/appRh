package tn.myapps.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Conge implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Integer idConge;
	@Temporal(TemporalType.DATE)
	private Date begin_date;
	@Temporal(TemporalType.DATE)
	private Date end_date;
	private String comment;
	
	public Integer getIdConge() {
		return idConge;
	}
	public Conge(Date begin_date, Date end_date, String comment) {
		super();
		this.begin_date = begin_date;
		this.end_date = end_date;
		this.comment = comment;
	}
	public void setIdConge(Integer idConge) {
		this.idConge = idConge;
	}
	
	public Date getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
