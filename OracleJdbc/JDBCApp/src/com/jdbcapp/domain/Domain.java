package com.jdbcapp.domain;

import java.util.Date;

/**
 * 
 * @author Sudarsan
 */
public abstract class Domain implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String guid;
	private Integer createdBy;
	private Date createdOn;
	private Integer modifiedBy;
	private Date modifiedOn;
	private Integer active;

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public String toString() {
		StringBuilder toStringBuilder = new StringBuilder();
		toStringBuilder.append(super.toString());
		toStringBuilder.append("\n");
		toStringBuilder.append("\nid: ");
		toStringBuilder.append(id);
		toStringBuilder.append("\nguid: ");
		toStringBuilder.append(guid);
		toStringBuilder.append("\ncreatedBy: ");
		toStringBuilder.append(createdBy);
		toStringBuilder.append("\ncreatedOn: ");
		toStringBuilder.append(createdOn);
		toStringBuilder.append("\nmodifiedBy: ");
		toStringBuilder.append(modifiedBy);
		toStringBuilder.append("\nmodifiedOn: ");
		toStringBuilder.append(modifiedOn);
		toStringBuilder.append("\nactive: ");
		toStringBuilder.append(active);
		return toStringBuilder.toString();
	}

}
