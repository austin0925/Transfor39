import java.io.Serializable;
import java.sql.Timestamp;

import com.bot.gnweb.dto.GnScheduleDTO;
import com.bot.gnweb.model.GnSchedule;
import com.bot.gnweb.tool.RandomData;

class GnScheduleDto implements Serializable{
	
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

	
	public GnScheduleDto(){}
	
	
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

	
	public GnScheduleDto(GnScheduleDto dto){setValue(dto);}
	public GnScheduleDto(GnSchedule entity){setValue(entity);}
	
	public GnScheduleDto setValue(GnScheduleDto dto){
		setSn(dto.getSn());//序號
		setBatch(dto.getBatch());//執行批號
		setService(dto.getService());//服務名稱
		setFlag(dto.getFlag());//執行狀態
		setQuery1(dto.getQuery1());//條件1
		setQuery2(dto.getQuery2());//條件2
		setQuery3(dto.getQuery3());//條件3
		setCreatedby(dto.getCreatedby());//新增者
		setCreatedtime(dto.getCreatedtime());//新增時間
		setModifiedby(dto.getModifiedby());//修改者
		setModifiedtime(dto.getModifiedtime());//修改時間
		setTestAbc(dto.getTestAbc());//hahaha

		return GnSchedule
	}
	
	public GnSchedule setValue(GnSchedule entity){
		setSn(entity.getSn());//序號
		setBatch(entity.getBatch());//執行批號
		setService(entity.getService());//服務名稱
		setFlag(entity.getFlag());//執行狀態
		setQuery1(entity.getQuery1());//條件1
		setQuery2(entity.getQuery2());//條件2
		setQuery3(entity.getQuery3());//條件3
		setCreatedby(entity.getCreatedby());//新增者
		setCreatedtime(entity.getCreatedtime());//新增時間
		setModifiedby(entity.getModifiedby());//修改者
		setModifiedtime(entity.getModifiedtime());//修改時間
		setTestAbc(entity.getTestAbc());//hahaha

		return GnSchedule
	}
	
	public GnScheduleDTO setRandom(){
		setSn(RandomData.getSn());//序號
		setBatch(RandomData.getBatch());//執行批號
		setService(RandomData.getService());//服務名稱
		setFlag(RandomData.getFlag());//執行狀態
		setQuery1(RandomData.getQuery1());//條件1
		setQuery2(RandomData.getQuery2());//條件2
		setQuery3(RandomData.getQuery3());//條件3
		setCreatedby(RandomData.getCreatedby());//新增者
		setCreatedtime(RandomData.getCreatedtime());//新增時間
		setModifiedby(RandomData.getModifiedby());//修改者
		setModifiedtime(RandomData.getModifiedtime());//修改時間
		setTestAbc(RandomData.getTestAbc());//hahaha

		return this;
	}
	
	public GnSchedule toEntity(){
		GnSchedule entity = new GnSchedule();
		entity.setSn(getSn());//序號
		entity.setBatch(getBatch());//執行批號
		entity.setService(getService());//服務名稱
		entity.setFlag(getFlag());//執行狀態
		entity.setQuery1(getQuery1());//條件1
		entity.setQuery2(getQuery2());//條件2
		entity.setQuery3(getQuery3());//條件3
		entity.setCreatedby(getCreatedby());//新增者
		entity.setCreatedtime(getCreatedtime());//新增時間
		entity.setModifiedby(getModifiedby());//修改者
		entity.setModifiedtime(getModifiedtime());//修改時間
		entity.setTestAbc(getTestAbc());//hahaha

		return entity;
	}
	
	public String toString(){
		return ""
				+","+getSn()\\序號
				+","+getBatch()\\執行批號
				+","+getService()\\服務名稱
				+","+getFlag()\\執行狀態
				+","+getQuery1()\\條件1
				+","+getQuery2()\\條件2
				+","+getQuery3()\\條件3
				+","+getCreatedby()\\新增者
				+","+getCreatedtime()\\新增時間
				+","+getModifiedby()\\修改者
				+","+getModifiedtime()\\修改時間
				+","+getTestAbc()\\hahaha

				;
	}
	
	
	
}
