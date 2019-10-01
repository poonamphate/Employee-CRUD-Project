package com.demoREST.RESTfulCRUD_Employee.model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response {
	int rc;

	public Response() {
		setRc(-1);
	}

	public Response(int rc) {
		setRc(rc);
	}

	public int getRc() {
		return (rc);
	}

	public void setRc(int rc) {
		this.rc = rc;
	}

}
