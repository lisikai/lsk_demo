package com.icss.model;

public class Dvd {
	private int dvdId;         //序号
	private String dvdName;    //名字
	private String status;	   //状态 可借  不可借
	private int lendCount;     //借出次数
	public Dvd() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Dvd [dvdId=" + dvdId + ", dvdName=" + dvdName + ", status=" + status + ", lendCount=" + lendCount + "]";
	}


	public Dvd(String dvdName) {
		super();
		this.dvdName = dvdName;
	}


	public Dvd(int dvdId, String dvdName) {
		super();
		this.dvdId = dvdId;
		this.dvdName = dvdName;
	}

	public int getDvdId() {
		return dvdId;
	}
	public void setDvdId(int dvdId) {
		this.dvdId = dvdId;
	}
	public String getDvdName() {
		return dvdName;
	}
	public void setDvdName(String dvdName) {
		this.dvdName = dvdName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLendCount() {
		return lendCount;
	}
	public void setLendCount(int lendCount) {
		this.lendCount = lendCount;
	}
	public Dvd(int dvdId, String dvdName, String status, int lendCount) {
		super();
		this.dvdId = dvdId;
		this.dvdName = dvdName;
		this.status = status;
		this.lendCount = lendCount;
	}
	
	
}
