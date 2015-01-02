package org.ikgroup.domain;

public class SequenceDemo {
	
	/**
	 * DB_ID.
	 */
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "ID: " + id;
	}

}
