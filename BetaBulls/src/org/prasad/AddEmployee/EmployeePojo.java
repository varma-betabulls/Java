package org.prasad.AddEmployee;

import java.util.Date;

public class EmployeePojo {

	
	private String eid;
	private String ename;
	private String eaddress;
	private String ephone;
	private String edesg;
	private String edoj;
	private String eemail;
	private String fathername;
	private String eblood;
	private String edob;
	private String epin;
	private double total;
	private double avg;
	private int work;
	private String year;
	private String prevleave;
	private String sickleave;
	private String casualleave;
	private String tot;
	private String aveg;
	private Float tott;
	
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public String getEphone() {
		return ephone;
	}
	public void setEphone(String ephone) {
		this.ephone = ephone;
	}
	public String getEdesg() {
		return edesg;
	}
	public void setEdesg(String edesg) {
		this.edesg = edesg;
	}
	public String getEdoj() {
		return edoj;
	}
	public void setEdoj(String edoj) {
		this.edoj = edoj;
	}
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getEblood() {
		return eblood;
	}
	public void setEblood(String eblood) {
		this.eblood = eblood;
	}
	public String getEdob() {
		return edob;
	}
	public void setEdob(String edob) {
		this.edob = edob;
	}
	public String getEpin() {
		return epin;
	}
	public void setEpin(String epin) {
		this.epin = epin;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getWork() {
		return work;
	}
	public void setWork(int work) {
		this.work = work;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPrevleave() {
		return prevleave;
	}
	public void setPrevleave(String prevleave) {
		this.prevleave = prevleave;
	}
	public String getSickleave() {
		return sickleave;
	}
	public void setSickleave(String sickleave) {
		this.sickleave = sickleave;
	}
	public String getCasualleave() {
		return casualleave;
	}
	public void setCasualleave(String casualleave) {
		this.casualleave = casualleave;
	}
	public String getTot() {
		return tot;
	}
	public void setTot(String tot) {
		this.tot = tot;
	}
	public String getAveg() {
		return aveg;
	}
	public void setAveg(String aveg) {
		this.aveg = aveg;
	}
	public Float getTott() {
		return tott;
	}
	public void setTott(Float tott) {
		this.tott = tott;
	}
	public String toString() {
        return "EmployeePojo [userid=" + eid + ", empName=" + ename
                + ", Address=" + eaddress + ", Phone=" + ephone + ", email="
                + eemail + "]";
    }    

}
