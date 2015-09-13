class GnSchedule{
	
	private Double sn;\\序號 
	private Double batch;\\執行批號 
	private String service;\\服務名稱 
	private String flag;\\執行狀態 
	private String query1;\\條件1 
	private String query2;\\條件2 
	private String query3;\\條件3 
	private String createdby;\\新增者 
	private Timestamp createdtime;\\新增時間 
	private String modifiedby;\\修改者 
	private Timestamp modifiedtime;\\修改時間 
	private String testAbc;\\hahaha 

	
	public Double getSn(){return this.sn;}
	public Double getBatch(){return this.batch;}
	public String getService(){return this.service;}
	public String getFlag(){return this.flag;}
	public String getQuery1(){return this.query1;}
	public String getQuery2(){return this.query2;}
	public String getQuery3(){return this.query3;}
	public String getCreatedby(){return this.createdby;}
	public Timestamp getCreatedtime(){return this.createdtime;}
	public String getModifiedby(){return this.modifiedby;}
	public Timestamp getModifiedtime(){return this.modifiedtime;}
	public String getTestAbc(){return this.testAbc;}

	public void setSn(Double sn){this.sn=sn;}
	public void setBatch(Double batch){this.batch=batch;}
	public void setService(String service){this.service=service;}
	public void setFlag(String flag){this.flag=flag;}
	public void setQuery1(String query1){this.query1=query1;}
	public void setQuery2(String query2){this.query2=query2;}
	public void setQuery3(String query3){this.query3=query3;}
	public void setCreatedby(String createdby){this.createdby=createdby;}
	public void setCreatedtime(Timestamp createdtime){this.createdtime=createdtime;}
	public void setModifiedby(String modifiedby){this.modifiedby=modifiedby;}
	public void setModifiedtime(Timestamp modifiedtime){this.modifiedtime=modifiedtime;}
	public void setTestAbc(String testAbc){this.testAbc=testAbc;}

	
	public String toString(){
		return ""
				+","+getSn()
				+","+getBatch()
				+","+getService()
				+","+getFlag()
				+","+getQuery1()
				+","+getQuery2()
				+","+getQuery3()
				+","+getCreatedby()
				+","+getCreatedtime()
				+","+getModifiedby()
				+","+getModifiedtime()
				+","+getTestAbc()

				;
	}
	
}
