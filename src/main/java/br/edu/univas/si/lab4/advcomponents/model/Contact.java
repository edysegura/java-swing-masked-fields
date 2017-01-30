package br.edu.univas.si.lab4.advcomponents.model;

public class Contact {
	
	private String phone1;
	private String phone2;
	private String zipCode;
	private String state;
	/**
	 * @return the phone1
	 */
	public String getPhone1() {
		return phone1;
	}
	/**
	 * @param phone1 the phone1 to set
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	/**
	 * @return the phone2
	 */
	public String getPhone2() {
		return phone2;
	}
	/**
	 * @param phone2 the phone2 to set
	 */
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Phone 1:\t ")
		  .append(getPhone1())
		  .append("\n")
		  .append("Phone 2:\t ")
		  .append(getPhone2())
		  .append("\n")
		  .append("Zip Code:\t ")
		  .append(getZipCode())
		  .append("\n")
		  .append("State:\t ")
		  .append(getState());
		
		return sb.toString();
	}

}
