import java.io.Serializable;
import java.sql.Timestamp;

import com.bot.gnweb.dto.GnScheduleDTO;
import com.bot.gnweb.model.GnSchedule;
import com.bot.gnweb.tool.RandomData;

class ~TableDto implements Serializable{
	
	private ~~type ~~name;\\~~comment 
	
	public ~TableDto(){}
	
	
	public ~~type get~~Name(){return this.~~name;}
	public void set~~Name(~~type ~~name){this.~~name=~~name;}
	
	public ~TableDto(~TableDto dto){setValue(dto);}
	public ~TableDto(~Table entity){setValue(entity);}
	
	public ~TableDto setValue(~TableDto dto){
		set~~Name(dto.get~~Name());//~~comment
		return ~Table
	}
	
	public ~Table setValue(~Table entity){
		set~~Name(entity.get~~Name());//~~comment
		return ~Table
	}
	
	public ~TableDTO setRandom(){
		set~~Name(RandomData.get~~Name());//~~comment
		return this;
	}
	
	public ~Table toEntity(){
		~Table entity = new ~Table();
		entity.set~~Name(get~~Name());//~~comment
		return entity;
	}
	
	public String toString(){
		return ""
				+","+get~~Name()\\~~comment
				;
	}
	
	
	
}