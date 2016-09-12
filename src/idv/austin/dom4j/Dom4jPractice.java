package idv.austin.dom4j;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

public class Dom4jPractice {

	public static void main(String[] args) throws UnsupportedEncodingException, DocumentException {
		System.out.println("[START]");
		String requestXML = "<?xml version='1.0' encoding='UTF-8' ?>\r\n<ERA_DISP>\r\n<CASE_ID>2014070013</CASE_ID>\r\n<REPORT_CODE>LIFELINES_DAMAGES</REPORT_CODE><MASTER>A4<NAME>Austin</NAME><AGE>40</AGE></MASTER>\r\n</ERA_DISP>";
		String testXML = "<DataOutput><Blocking><EventID>100004596</EventID><EventName><![CDATA[0507民航局測試]]></EventName><RailType><![CDATA[台鐵]]></RailType><TRALine><![CDATA[西部(縱)幹線]]></TRALine><End1_Station><![CDATA[大林]]></End1_Station><End2_Station><![CDATA[民雄]]></End2_Station><Status><![CDATA[2]]></Status><Mileage><![CDATA[286K+900M東正線]]></Mileage><City>Q</City><Country>Q05</Country><LocDesc><![CDATA[大林=民雄間]]></LocDesc><Location><LONG>120.432</LONG><LAT>23.558</LAT></Location><InitTime><![CDATA[20130829 - 060300]]></InitTime><EstiFixDay><![CDATA[]]></EstiFixDay><EstiFixDate><![CDATA[]]></EstiFixDate><EventDesc><![CDATA[因康芮颱風帶來豪雨影響，民雄站北端大水淹過軌面，自6時03分起民雄=大林間東線暫時不通。綜調所02-2138]]></EventDesc><ProcessCxt><![CDATA[康芮颱風豪大雨,水淹過軌面.二水=林鳳營間東西線不通(趕時間的旅客請改搭其他交通工具)]]></ProcessCxt><Budget><![CDATA[0]]></Budget><Descp><![CDATA[]]></Descp><CreateTime><![CDATA[20140516 - 155512]]></CreateTime><CreateUser><![CDATA[rail]]></CreateUser><EditTime><![CDATA[]]></EditTime><EditUser><![CDATA[]]></EditUser></Blocking><Blocking><EventID>100004594</EventID><EventName><![CDATA[0507民航局測試]]></EventName><RailType><![CDATA[台鐵]]></RailType><TRALine><![CDATA[西部(縱)幹線]]></TRALine><End1_Station><![CDATA[松山]]></End1_Station><End2_Station><![CDATA[臺北]]></End2_Station><Status><![CDATA[2]]></Status><Mileage><![CDATA[23K+800M東正線]]></Mileage><City>A</City><Country>A17</Country><LocDesc><![CDATA[松山=臺北間]]></LocDesc><Location><LONG>121.561</LONG><LAT>25.046</LAT></Location><InitTime><![CDATA[20130418 - 055700]]></InitTime><EstiFixDay><![CDATA[]]></EstiFixDay><EstiFixDate><![CDATA[]]></EstiFixDate><EventDesc><![CDATA[05:57分1次行經松山、台北間東正線時，發現K23+800處電車線斷落。]]></EventDesc><ProcessCxt><![CDATA[06:10出動搶修車，改以西正線單線行車，06:50成立二級應變小組。]]></ProcessCxt><Budget><![CDATA[]]></Budget><Descp><![CDATA[]]></Descp><CreateTime><![CDATA[20140516 - 155512]]></CreateTime><CreateUser><![CDATA[rail]]></CreateUser><EditTime><![CDATA[]]></EditTime><EditUser><![CDATA[]]></EditUser></Blocking><Blocking><EventID>100004592</EventID><EventName><![CDATA[0507民航局測試]]></EventName><RailType><![CDATA[台鐵]]></RailType><TRALine><![CDATA[臺東線]]></TRALine><End1_Station><![CDATA[瑞穗]]></End1_Station><End2_Station><![CDATA[富源]]></End2_Station><Status><![CDATA[2]]></Status><Mileage><![CDATA[57K+300M正線]]></Mileage><City>U</City><Country>U09</Country><LocDesc><![CDATA[富源=瑞穗間]]></LocDesc><Location><LONG>121.377</LONG><LAT>23.551</LAT></Location><InitTime><![CDATA[20130403 - 075500]]></InitTime><EstiFixDay><![CDATA[]]></EstiFixDay><EstiFixDate><![CDATA[]]></EstiFixDate><EventDesc><![CDATA[04時30分鐵工局東工處電力工程隊架線車在瑞穗、富源間K57+300處，發生兩輛平車出軌事故，致路線暫時不通。]]></EventDesc><ProcessCxt><![CDATA[]]></ProcessCxt><Budget><![CDATA[]]></Budget><Descp><![CDATA[]]></Descp><CreateTime><![CDATA[20140516 - 155512]]></CreateTime><CreateUser><![CDATA[rail]]></CreateUser><EditTime><![CDATA[]]></EditTime><EditUser><![CDATA[]]></EditUser></Blocking><Blocking><EventID>100004589</EventID><EventName><![CDATA[0507民航局測試]]></EventName><RailType><![CDATA[台鐵]]></RailType><TRALine><![CDATA[西部(縱)幹線]]></TRALine><End1_Station><![CDATA[松山]]></End1_Station><End2_Station><![CDATA[臺北]]></End2_Station><Status><![CDATA[2]]></Status><Mileage><![CDATA[23K+800M東正線]]></Mileage><City>A</City><Country>A17</Country><LocDesc><![CDATA[松山=臺北間]]></LocDesc><Location><LONG>121.561</LONG><LAT>25.046</LAT></Location><InitTime><![CDATA[20130911 - 055700]]></InitTime><EstiFixDay><![CDATA[]]></EstiFixDay><EstiFixDate><![CDATA[]]></EstiFixDate><EventDesc><![CDATA[05:57分1次行經松山、台北間東正線時，發現K23+800處電車線斷落。]]></EventDesc><ProcessCxt><![CDATA[06:10出動搶修車，改以西正線單線行車，06:50成立二級應變小組。]]></ProcessCxt><Budget><![CDATA[]]></Budget><Descp><![CDATA[]]></Descp><CreateTime><![CDATA[20140516 - 144258]]></CreateTime><CreateUser><![CDATA[rail]]></CreateUser><EditTime><![CDATA[]]></EditTime><EditUser><![CDATA[]]></EditUser></Blocking><Blocking><EventID>100004585</EventID><EventName><![CDATA[0507民航局測試]]></EventName><RailType><![CDATA[台鐵]]></RailType><TRALine><![CDATA[臺東線]]></TRALine><End1_Station><![CDATA[瑞穗]]></End1_Station><End2_Station><![CDATA[富源]]></End2_Station><Status><![CDATA[2]]></Status><Mileage><![CDATA[57K+300M正線]]></Mileage><City>U</City><Country>U09</Country><LocDesc><![CDATA[富源=瑞穗間]]></LocDesc><Location><LONG>121.377</LONG><LAT>23.551</LAT></Location><InitTime><![CDATA[20130903 - 075500]]></InitTime><EstiFixDay><![CDATA[]]></EstiFixDay><EstiFixDate><![CDATA[]]></EstiFixDate><EventDesc><![CDATA[04時30分鐵工局東工處電力工程隊架線車在瑞穗、富源間K57+300處，發生兩輛平車出軌事故，致路線暫時不通。]]></EventDesc><ProcessCxt><![CDATA[]]></ProcessCxt><Budget><![CDATA[]]></Budget><Descp><![CDATA[]]></Descp><CreateTime><![CDATA[20140516 - 144258]]></CreateTime><CreateUser><![CDATA[rail]]></CreateUser><EditTime><![CDATA[]]></EditTime><EditUser><![CDATA[]]></EditUser></Blocking><Resume><EventID>100002507</EventID><EventName><![CDATA[0507民航局測試]]></EventName><RailType>台鐵</RailType><Mileage><![CDATA[77K+71.5080000000016M西正線]]></Mileage><City><![CDATA[宜蘭縣]]></City><Country><![CDATA[五結鄉]]></Country><LocDesc><![CDATA[]]></LocDesc><Location><LONG>121.774</LONG><LAT>24.705</LAT></Location><ProcessCxt><![CDATA[ R12班車無法通行 ]]></ProcessCxt><Damage><![CDATA[導致鐵路停駛無法通行 ]]></Damage><Context><![CDATA[ R12班車無法通行 ]]></Context><Status><![CDATA[]]></Status><BlockTime><![CDATA[20130908 - 192500]]></BlockTime><RepairTime><![CDATA[20130912 - 075500]]></RepairTime><CreateTime><![CDATA[20140516 - 144258]]></CreateTime><CreateUser><![CDATA[rail]]></CreateUser><EditTime><![CDATA[]]></EditTime><EditUser><![CDATA[]]></EditUser></Resume><Suspend><EventID>100002607</EventID><EventName><![CDATA[0507民航局測試]]></EventName><RailType><![CDATA[台鐵]]></RailType><TRALine><![CDATA[內灣線]]></TRALine><End1_Station><![CDATA[世博]]></End1_Station><End2_Station><![CDATA[內灣]]></End2_Station><Status><![CDATA[全面停駛]]></Status><TrainNo><![CDATA[412]]></TrainNo><EventDesc><![CDATA[有颱風]]></EventDesc><Context><![CDATA[]]></Context><CreateTime>20140618 - 153049</CreateTime><CreateUser>hywebqqq</CreateUser><EditTime>20140618 - 153049</EditTime><EditUser></EditUser></Suspend><Suspend><EventID>100002603</EventID><EventName><![CDATA[0507民航局測試]]></EventName><RailType><![CDATA[台鐵]]></RailType><TRALine><![CDATA[西部(縱)幹線]]></TRALine><End1_Station><![CDATA[二水]]></End1_Station><End2_Station><![CDATA[大林]]></End2_Station><Status><![CDATA[部分停駛]]></Status><TrainNo><![CDATA[111;    222;    333;    444]]></TrainNo><EventDesc><![CDATA[自動介接test test]]></EventDesc><Context><![CDATA[旅資台 TEST 1025，第2次續報]]></Context><CreateTime>20140516 - 155512</CreateTime><CreateUser>rail</CreateUser><EditTime>20140516 - 155512</EditTime><EditUser></EditUser></Suspend><Suspend><EventID>100002601</EventID><EventName><![CDATA[0507民航局測試]]></EventName><RailType><![CDATA[台鐵]]></RailType><TRALine><![CDATA[西部(縱)幹線]]></TRALine><End1_Station><![CDATA[後壁]]></End1_Station><End2_Station><![CDATA[新營]]></End2_Station><Status><![CDATA[部分停駛]]></Status><TrainNo><![CDATA[111;    222;    369]]></TrainNo><EventDesc><![CDATA[\"0924第1次介接測試\"因OO颱風造成樹木傾倒、侵入路線進而造成111列車出軌人員死傷發生]]></EventDesc><Context><![CDATA[\"0924第1次介接測試\"測試完畢]]></Context><CreateTime>20140516 - 144258</CreateTime><CreateUser>rail</CreateUser><EditTime>20140516 - 144258</EditTime><EditUser></EditUser></Suspend><Suspend><EventID>100002599</EventID><EventName><![CDATA[0507民航局測試]]></EventName><RailType><![CDATA[台鐵]]></RailType><TRALine><![CDATA[臺東線]]></TRALine><End1_Station><![CDATA[東里]]></End1_Station><End2_Station><![CDATA[臺東]]></End2_Station><Status><![CDATA[部分停駛]]></Status><TrainNo><![CDATA[100;    101]]></TrainNo><EventDesc><![CDATA[0919第1次介接測試，因颱風造成土石流掩沒路線，以致路線中斷無法行駛]]></EventDesc><Context><![CDATA[0917第1次測試，針對路線阻斷造成旅客不便之處，已通知相關車站加強旅客廣播]]></Context><CreateTime>20140516 - 144258</CreateTime><CreateUser>rail</CreateUser><EditTime>20140516 - 144258</EditTime><EditUser></EditUser></Suspend><Suspend><EventID>100002597</EventID><EventName><![CDATA[0507民航局測試]]></EventName><RailType><![CDATA[台鐵]]></RailType><TRALine><![CDATA[南迴線]]></TRALine><End1_Station><![CDATA[枋野]]></End1_Station><End2_Station><![CDATA[枋山]]></End2_Station><Status><![CDATA[部分停駛]]></Status><TrainNo><![CDATA[888]]></TrainNo><EventDesc><![CDATA[\"0917介接測試\"因OO陸上颱風造成9K+900處土石流，並造成999次列車機車檔泥板受損]]></EventDesc><Context><![CDATA[0917測試完畢]]></Context><CreateTime>20140516 - 144258</CreateTime><CreateUser>rail</CreateUser><EditTime>20140516 - 144258</EditTime><EditUser></EditUser></Suspend><Airport><EventID>100006354</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirPortName><![CDATA[綠島機場]]></AirPortName><Status><![CDATA[暫停起降或關閉]]></Status><Closedate>20140515 - 123000</Closedate><Reason><![CDATA[受0507民航局測試影響 颱風]]></Reason><ResumeTime></ResumeTime><Note><![CDATA[暫停起降]]></Note><CreateTime>20140515 - 150623</CreateTime><CreateTime>20140515 - 151100</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134521</EditTime><EditUser>caa01</EditUser></Airport><Airport><EventID>100006346</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirPortName><![CDATA[七美機場]]></AirPortName><Status><![CDATA[暫停起降或關閉]]></Status><Closedate>20140507 - 123000</Closedate><Reason><![CDATA[受0507民航局測試影響 333]]></Reason><ResumeTime></ResumeTime><Note><![CDATA[暫停起降]]></Note><CreateTime>20140507 - 112455</CreateTime><CreateTime>20140507 - 121611</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140507 - 112455</EditTime><EditUser></EditUser></Airport><Airport><EventID>100006352</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirPortName><![CDATA[臺灣桃園國際機場]]></AirPortName><Status><![CDATA[暫停起降或關閉]]></Status><Closedate>20140507 - 123000</Closedate><Reason><![CDATA[受0514民航局測試影響 333]]></Reason><ResumeTime></ResumeTime><Note><![CDATA[關閉]]></Note><CreateTime>20140507 - 112455</CreateTime><CreateTime>20140507 - 121611</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140507 - 112455</EditTime><EditUser></EditUser></Airport><Airport><EventID>100006344</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirPortName><![CDATA[七美機場]]></AirPortName><Status><![CDATA[暫停起降或關閉]]></Status><Closedate>20140507 - 123000</Closedate><Reason><![CDATA[受0507民航局測試影響 11111]]></Reason><ResumeTime></ResumeTime><Note><![CDATA[暫停起降]]></Note><CreateTime>20140507 - 112219</CreateTime><CreateTime>20140507 - 121611</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140507 - 112219</EditTime><EditUser></EditUser></Airport><Airport><EventID>100006342</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirPortName><![CDATA[臺中機場]]></AirPortName><Status><![CDATA[暫停起降或關閉]]></Status><Closedate>20140507 - 103000</Closedate><Reason><![CDATA[受0507民航局測試影響 ]]></Reason><ResumeTime></ResumeTime><Note><![CDATA[暫停起降]]></Note><CreateTime>20140507 - 110940</CreateTime><CreateTime>20140507 - 121611</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140507 - 110940</EditTime><EditUser></EditUser></Airport><FlightTraffic><EventID>100403929</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 193000]]></FlyTime><AirLine><![CDATA[立榮航空]]></AirLine><Flight><![CDATA[B7340]]></Flight><Station><![CDATA[北竿-松山]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 113638</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134721</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403927</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 132000]]></FlyTime><AirLine><![CDATA[立榮航空]]></AirLine><Flight><![CDATA[B7338]]></Flight><Station><![CDATA[北竿-松山]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 113638</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134721</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403925</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 090000]]></FlyTime><AirLine><![CDATA[立榮航空]]></AirLine><Flight><![CDATA[B7336]]></Flight><Station><![CDATA[北竿-松山]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 113638</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134721</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403923</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 171000]]></FlyTime><AirLine><![CDATA[立榮航空]]></AirLine><Flight><![CDATA[B7320]]></Flight><Station><![CDATA[南竿-松山]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 113340</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134721</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403921</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 133500]]></FlyTime><AirLine><![CDATA[立榮航空]]></AirLine><Flight><![CDATA[B7372]]></Flight><Station><![CDATA[南竿-臺中]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 113340</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134721</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403919</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 075000]]></FlyTime><AirLine><![CDATA[立榮航空]]></AirLine><Flight><![CDATA[B7302]]></Flight><Station><![CDATA[南竿-松山]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 113340</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134721</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403917</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 073000]]></FlyTime><AirLine><![CDATA[立榮航空]]></AirLine><Flight><![CDATA[B73102]]></Flight><Station><![CDATA[南竿-松山]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 113340</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134721</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403915</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 135000]]></FlyTime><AirLine><![CDATA[德安航空]]></AirLine><Flight><![CDATA[DA7508]]></Flight><Station><![CDATA[蘭嶼-臺東]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 111908</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134721</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403913</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 144000]]></FlyTime><AirLine><![CDATA[德安航空]]></AirLine><Flight><![CDATA[DA7518]]></Flight><Station><![CDATA[蘭嶼-臺東]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 111539</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134721</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403911</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 111000]]></FlyTime><AirLine><![CDATA[德安航空]]></AirLine><Flight><![CDATA[DA7506]]></Flight><Station><![CDATA[蘭嶼-臺東]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 111539</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134721</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403909</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 102000]]></FlyTime><AirLine><![CDATA[德安航空]]></AirLine><Flight><![CDATA[DA7504]]></Flight><Station><![CDATA[蘭嶼-臺東]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 111539</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134721</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403907</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 092500]]></FlyTime><AirLine><![CDATA[德安航空]]></AirLine><Flight><![CDATA[DA7502]]></Flight><Station><![CDATA[蘭嶼-臺東]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 111539</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134721</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403905</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 130000]]></FlyTime><AirLine><![CDATA[德安航空]]></AirLine><Flight><![CDATA[DA7304]]></Flight><Station><![CDATA[綠島-臺東]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 111045</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134720</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403903</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 085000]]></FlyTime><AirLine><![CDATA[德安航空]]></AirLine><Flight><![CDATA[DA7302]]></Flight><Station><![CDATA[綠島-臺東]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 111045</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134720</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403901</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 183000]]></FlyTime><AirLine><![CDATA[復興航空GE]]></AirLine><Flight><![CDATA[GE020]]></Flight><Station><![CDATA[花蓮-松山]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105926</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134720</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403899</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 150000]]></FlyTime><AirLine><![CDATA[復興航空GE]]></AirLine><Flight><![CDATA[GE018]]></Flight><Station><![CDATA[花蓮-松山]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105926</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134720</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403897</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 213000]]></FlyTime><AirLine><![CDATA[復興航空GE]]></AirLine><Flight><![CDATA[GE3137]]></Flight><Station><![CDATA[天津-花蓮]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105900</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134720</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403895</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 184000]]></FlyTime><AirLine><![CDATA[華信航空]]></AirLine><Flight><![CDATA[AE394]]></Flight><Station><![CDATA[臺東-松山]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105827</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134720</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403893</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 175500]]></FlyTime><AirLine><![CDATA[立榮航空]]></AirLine><Flight><![CDATA[B7858]]></Flight><Station><![CDATA[臺東-松山]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105827</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134720</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403891</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 162000]]></FlyTime><AirLine><![CDATA[德安航空]]></AirLine><Flight><![CDATA[DA7311]]></Flight><Station><![CDATA[臺東-綠島]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105827</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134720</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403889</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 201500]]></FlyTime><AirLine><![CDATA[復興航空GE]]></AirLine><Flight><![CDATA[GE228]]></Flight><Station><![CDATA[高雄-馬公]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105726</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134720</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403887</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 193500]]></FlyTime><AirLine><![CDATA[立榮航空]]></AirLine><Flight><![CDATA[B76275]]></Flight><Station><![CDATA[高雄-馬公]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105726</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134720</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403885</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 212000]]></FlyTime><AirLine><![CDATA[港龍航空]]></AirLine><Flight><![CDATA[KA457]]></Flight><Station><![CDATA[高雄-香港]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105726</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134720</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403883</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 212000]]></FlyTime><AirLine><![CDATA[國泰航空]]></AirLine><Flight><![CDATA[CX5457]]></Flight><Station><![CDATA[高雄-香港]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105726</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134720</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403881</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 135000]]></FlyTime><AirLine><![CDATA[中華航空]]></AirLine><Flight><![CDATA[CI167]]></Flight><Station><![CDATA[關西-高雄]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105659</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134720</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403879</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 114000]]></FlyTime><AirLine><![CDATA[中華航空]]></AirLine><Flight><![CDATA[CI712]]></Flight><Station><![CDATA[馬尼拉-高雄]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105659</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134720</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403877</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 110500]]></FlyTime><AirLine><![CDATA[中國南方航空]]></AirLine><Flight><![CDATA[CZ669]]></Flight><Station><![CDATA[CGQ-高雄]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105659</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134719</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403875</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 183000]]></FlyTime><AirLine><![CDATA[立榮航空]]></AirLine><Flight><![CDATA[B7649]]></Flight><Station><![CDATA[臺南-馬公]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105611</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134719</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403873</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 161500]]></FlyTime><AirLine><![CDATA[立榮航空]]></AirLine><Flight><![CDATA[B7647]]></Flight><Station><![CDATA[臺南-馬公]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105611</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134719</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403871</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 130000]]></FlyTime><AirLine><![CDATA[中華航空]]></AirLine><Flight><![CDATA[CI7868]]></Flight><Station><![CDATA[香港-臺南]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105539</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134719</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403869</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 153000]]></FlyTime><AirLine><![CDATA[立榮航空]]></AirLine><Flight><![CDATA[B79255]]></Flight><Station><![CDATA[嘉義-金門]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105439</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134719</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403867</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 190500]]></FlyTime><AirLine><![CDATA[立榮航空]]></AirLine><Flight><![CDATA[B76231]]></Flight><Station><![CDATA[臺中-馬公]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105240</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134719</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403865</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 173000]]></FlyTime><AirLine><![CDATA[立榮航空]]></AirLine><Flight><![CDATA[B7629]]></Flight><Station><![CDATA[臺中-馬公]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105240</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134719</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403863</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 122000]]></FlyTime><AirLine><![CDATA[東方航空]]></AirLine><Flight><![CDATA[MU7478]]></Flight><Station><![CDATA[臺中-太原]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105240</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134719</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403861</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 112000]]></FlyTime><AirLine><![CDATA[東方航空]]></AirLine><Flight><![CDATA[MU7477]]></Flight><Station><![CDATA[太原-臺中]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 105146</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134719</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403859</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 234000]]></FlyTime><AirLine><![CDATA[中華航空]]></AirLine><Flight><![CDATA[CI5991]]></Flight><Station><![CDATA[桃園-廈門]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 101213</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134719</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403857</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 162500]]></FlyTime><AirLine><![CDATA[東方航空]]></AirLine><Flight><![CDATA[MU2568]]></Flight><Station><![CDATA[桃園-LJG]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 101213</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134719</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403855</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 124000]]></FlyTime><AirLine><![CDATA[長榮航空]]></AirLine><Flight><![CDATA[BR869]]></Flight><Station><![CDATA[桃園-香港]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 101213</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134719</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403853</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 124000]]></FlyTime><AirLine><![CDATA[香港航空]]></AirLine><Flight><![CDATA[HX1869]]></Flight><Station><![CDATA[桃園-香港]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 101213</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134719</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403851</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 073000]]></FlyTime><AirLine><![CDATA[長榮航空]]></AirLine><Flight><![CDATA[BR658]]></Flight><Station><![CDATA[桃園-安克拉]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 101213</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134719</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403849</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 171000]]></FlyTime><AirLine><![CDATA[長榮航空]]></AirLine><Flight><![CDATA[BR870]]></Flight><Station><![CDATA[香港-桃園]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 101134</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134718</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403847</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 171000]]></FlyTime><AirLine><![CDATA[香港航空]]></AirLine><Flight><![CDATA[HX1870]]></Flight><Station><![CDATA[香港-桃園]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 101134</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134718</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403845</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 133500]]></FlyTime><AirLine><![CDATA[東方航空]]></AirLine><Flight><![CDATA[MU2567]]></Flight><Station><![CDATA[LJG-桃園]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 101134</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134718</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403843</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 194500]]></FlyTime><AirLine><![CDATA[復興航空GE]]></AirLine><Flight><![CDATA[GE5175]]></Flight><Station><![CDATA[松山-馬公]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 095759</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134718</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403841</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 193000]]></FlyTime><AirLine><![CDATA[復興航空GE]]></AirLine><Flight><![CDATA[GE513]]></Flight><Station><![CDATA[松山-馬公]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 095759</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134718</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403839</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 190000]]></FlyTime><AirLine><![CDATA[華信航空]]></AirLine><Flight><![CDATA[AE369]]></Flight><Station><![CDATA[松山-馬公]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 095759</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134718</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403837</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 204500]]></FlyTime><AirLine><![CDATA[廈門航空]]></AirLine><Flight><![CDATA[MF884]]></Flight><Station><![CDATA[松山-福州]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 095759</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134718</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403835</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 204500]]></FlyTime><AirLine><![CDATA[復興航空GE]]></AirLine><Flight><![CDATA[GE9884]]></Flight><Station><![CDATA[松山-福州]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 095759</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134718</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403833</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140507 - 194500]]></FlyTime><AirLine><![CDATA[廈門航空]]></AirLine><Flight><![CDATA[MF882]]></Flight><Station><![CDATA[松山-廈門]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140507 - 095759</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134718</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403938</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140515 - 130000]]></FlyTime><AirLine><![CDATA[德安航空]]></AirLine><Flight><![CDATA[DA7304]]></Flight><Station><![CDATA[綠島-臺東]]></Station><Delay><![CDATA[取消]]></Delay><Reason><![CDATA[1]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140515 - 150439</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134521</EditTime><EditUser>caa01</EditUser></FlightTraffic><FlightTraffic><EventID>100403936</EventID><EventName><![CDATA[0507民航局測試]]></EventName><FlyTime><![CDATA[20140515 - 085000]]></FlyTime><AirLine><![CDATA[德安航空]]></AirLine><Flight><![CDATA[DA7302]]></Flight><Station><![CDATA[綠島-臺東]]></Station><Delay><![CDATA[延誤]]></Delay><Reason><![CDATA[1]]></Reason><Note><![CDATA[0507民航局測試]]></Note><CreateTime>20140515 - 150439</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 134521</EditTime><EditUser>caa01</EditUser></FlightTraffic><AirportFacility><EventID>100003959</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirStationName><![CDATA[臺北松山機場]]></AirStationName><DamageDate>20140515 - 143000</DamageDate><RepairDay>1</RepairDay><RepairDate></RepairDate><Status><![CDATA[rere]]></Status><Policy><![CDATA[ere]]></Policy><Cost><![CDATA[12222]]></Cost><Note><![CDATA[ere]]></Note><CreateTime>20140515 - 143704</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140519 - 135629</EditTime><EditUser>caa01</EditUser></AirportFacility><AirportFacility><EventID>100003938</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirStationName><![CDATA[恆春機場]]></AirStationName><DamageDate>20140507 - 123000</DamageDate><RepairDay>3</RepairDay><RepairDate></RepairDate><Status><![CDATA[33]]></Status><Policy><![CDATA[33]]></Policy><Cost><![CDATA[3]]></Cost><Note><![CDATA[33]]></Note><CreateTime>20140507 - 112709</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140514 - 114001</EditTime><EditUser>caa01</EditUser></AirportFacility><AirportFacility><EventID>100003922</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirStationName><![CDATA[屏東機場]]></AirStationName><DamageDate>20140507 - 123000</DamageDate><RepairDay>2</RepairDay><RepairDate></RepairDate><Status><![CDATA[62]]></Status><Policy><![CDATA[62]]></Policy><Cost><![CDATA[2]]></Cost><Note><![CDATA[62]]></Note><CreateTime>20140507 - 113809</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140507 - 113809</EditTime><EditUser></EditUser></AirportFacility><AirportFacility><EventID>100003920</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirStationName><![CDATA[屏東機場]]></AirStationName><DamageDate>20140507 - 123000</DamageDate><RepairDay>9</RepairDay><RepairDate></RepairDate><Status><![CDATA[9]]></Status><Policy><![CDATA[9]]></Policy><Cost><![CDATA[9]]></Cost><Note><![CDATA[9]]></Note><CreateTime>20140507 - 113736</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140507 - 113736</EditTime><EditUser></EditUser></AirportFacility><AirportFacility><EventID>100003926</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirStationName><![CDATA[蘭嶼機場]]></AirStationName><DamageDate>20140507 - 123000</DamageDate><RepairDay>9</RepairDay><RepairDate></RepairDate><Status><![CDATA[9]]></Status><Policy><![CDATA[9]]></Policy><Cost><![CDATA[9]]></Cost><Note><![CDATA[9]]></Note><CreateTime>20140507 - 113452</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140507 - 113452</EditTime><EditUser></EditUser></AirportFacility><AirportFacility><EventID>100003936</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirStationName><![CDATA[恆春機場]]></AirStationName><DamageDate>20140507 - 123000</DamageDate><RepairDay>2</RepairDay><RepairDate></RepairDate><Status><![CDATA[2]]></Status><Policy><![CDATA[2]]></Policy><Cost><![CDATA[2]]></Cost><Note><![CDATA[2]]></Note><CreateTime>20140507 - 112337</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140507 - 112337</EditTime><EditUser></EditUser></AirportFacility><AirportFacility><EventID>100003934</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirStationName><![CDATA[恆春機場]]></AirStationName><DamageDate>20140507 - 123000</DamageDate><RepairDay>1</RepairDay><RepairDate></RepairDate><Status><![CDATA[1]]></Status><Policy><![CDATA[1]]></Policy><Cost><![CDATA[1]]></Cost><Note><![CDATA[]]></Note><CreateTime>20140507 - 112237</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140507 - 112237</EditTime><EditUser></EditUser></AirportFacility><AirportFacility><EventID>100003924</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirStationName><![CDATA[馬祖南竿機場]]></AirStationName><DamageDate>20140507 - 123000</DamageDate><RepairDay>1</RepairDay><RepairDate></RepairDate><Status><![CDATA[跑道燈光設備損壞]]></Status><Policy><![CDATA[跟換燈光設備]]></Policy><Cost><![CDATA[10000000]]></Cost><Note><![CDATA[]]></Note><CreateTime>20140507 - 111130</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140507 - 111130</EditTime><EditUser></EditUser></AirportFacility><AirportFacility><EventID>100003932</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirStationName><![CDATA[]]></AirStationName><DamageDate>20140507 - 093000</DamageDate><RepairDay>2</RepairDay><RepairDate></RepairDate><Status><![CDATA[rterwtertwtwretwrewretrewertrewtrwerter]]></Status><Policy><![CDATA[werttwretwertwerttwertwertwerwerttwert]]></Policy><Cost><![CDATA[1000000]]></Cost><Note><![CDATA[]]></Note><CreateTime>20140507 - 101031</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140507 - 101031</EditTime><EditUser></EditUser></AirportFacility><AirportFacility><EventID>100003930</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirStationName><![CDATA[]]></AirStationName><DamageDate>20140507 - 093000</DamageDate><RepairDay>1</RepairDay><RepairDate></RepairDate><Status><![CDATA[監控設備損壞]]></Status><Policy><![CDATA[立即更換件]]></Policy><Cost><![CDATA[50000]]></Cost><Note><![CDATA[]]></Note><CreateTime>20140507 - 100750</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140507 - 100750</EditTime><EditUser></EditUser></AirportFacility><AirportFacility><EventID>100003928</EventID><EventName><![CDATA[0507民航局測試]]></EventName><AirStationName><![CDATA[]]></AirStationName><DamageDate>20140507 - 093000</DamageDate><RepairDay>12</RepairDay><RepairDate></RepairDate><Status><![CDATA[雷達損壞]]></Status><Policy><![CDATA[testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest]]></Policy><Cost><![CDATA[1000000]]></Cost><Note><![CDATA[]]></Note><CreateTime>20140507 - 100255</CreateTime><CreateUser>caa01</CreateUser><EditTime>20140507 - 100255</EditTime><EditUser></EditUser></AirportFacility><ResourcePrepareState><EventID>5999</EventID><EventName><![CDATA[0507民航局測試]]></EventName><RPSOrgName><![CDATA[高速鐵路工程局捷運工程處]]></RPSOrgName><RPSHumanCount>2</RPSHumanCount><RPSMachineCount>4</RPSMachineCount><RPSNote><![CDATA[]]></RPSNote><CreateTime>20140512 - 134646</CreateTime><CreateUser>hywebqqq</CreateUser><EditTime>20140512 - 134646</EditTime><EditUser></EditUser></ResourcePrepareState></DataOutput>";
		org.dom4j.Document document4j = new SAXReader().read(new ByteArrayInputStream(requestXML.getBytes("UTF-8")));
		org.dom4j.Element rootElm = document4j.getRootElement();
		
		Iterator<org.dom4j.Element> iterator = rootElm.elementIterator();
		for(; iterator.hasNext();){
			org.dom4j.Element ele = (org.dom4j.Element)iterator.next();
			System.out.println(ele.getName());
			System.out.println(ele.getData());
			System.out.println(ele.getQName());
			System.out.println(ele.getParent().getText());
			System.out.println(ele.getText());
			System.out.println(ele.getNamespacePrefix());
		}
		
		System.out.println("-----------requestXML-----------");
		
		System.out.println("-----blockList------");
		
		int i = 0;
		org.dom4j.Element testElement = getRootElement(testXML);
		List<DefaultElement> blockList = testElement.elements("Blocking");
		for(DefaultElement objs:blockList){
			System.out.println("item:" + i++);
			System.out.println(objs);
			System.out.println(objs.getClass().getName());
			System.out.println(objs.getName());
			System.out.println(objs.getStringValue());
			System.out.println(objs.getText());
			System.out.println(objs.getQName());
		}
		
		System.out.println("-----list------");
		
		List<DefaultElement> list = testElement.elements();
		for(DefaultElement objs:list){
			System.out.println("item:" + i++);
			System.out.println(objs);
			System.out.println(objs.getClass().getName());
			System.out.println(objs.getName());
			System.out.println(objs.getStringValue());
			System.out.println(objs.getText());
			System.out.println(objs.getQName());
		}
		
		System.out.println("-----------");
		
		System.out.println("CASE_ID:");
		org.dom4j.Element element = rootElm.element("CASE_ID");
	//	element.setName("CASE_ID_123");
	//	rootElm.add(element);
		element.addAttribute("KEY", "123");
		element.addComment("comment123");
		element.addText("addText");
		element.addEntity("foo", "bar");
		System.out.println(rootElm.element("CASE_ID"));
		System.out.println(rootElm.element("CASE_ID").getText());
		
		System.out.println("MASTER:");
		System.out.println(rootElm.element("MASTER").getText());
		System.out.println(rootElm.element("MASTER").element("NAME").getText());
		
		System.out.println("RootElement.TEXT:");
		System.out.println(document4j.getRootElement().getText());
		System.out.println("XMLEncoding:");
		System.out.println(document4j.getXMLEncoding());
		System.out.println("NodeTypeName:");
		System.out.println(document4j.getNodeTypeName());
		System.out.println("asXML:");
		System.out.println(document4j.asXML());
		System.out.println("[END]");
		
	}
	
	/**
	 * [START]
[START]
CASE_ID
2014070013
org.dom4j.QName@4bdeec8a [name: CASE_ID namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]




2014070013

REPORT_CODE
LIFELINES_DAMAGES
org.dom4j.QName@735cb618 [name: REPORT_CODE namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]




LIFELINES_DAMAGES

MASTER
A4
org.dom4j.QName@87201e62 [name: MASTER namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]




A4

-----------requestXML-----------
-----blockList------
item:0
org.dom4j.tree.DefaultElement@34fa4704 [Element: <Blocking attributes: []/>]
org.dom4j.tree.DefaultElement
Blocking
1000045960507民航局測試台鐵西部(縱)幹線大林民雄2286K+900M東正線QQ05大林=民雄間120.43223.55820130829 - 060300因康芮颱風帶來豪雨影響，民雄站北端大水淹過軌面，自6時03分起民雄=大林間東線暫時不通。綜調所02-2138康芮颱風豪大雨,水淹過軌面.二水=林鳳營間東西線不通(趕時間的旅客請改搭其他交通工具)020140516 - 155512rail

org.dom4j.QName@dc3dd055 [name: Blocking namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:1
org.dom4j.tree.DefaultElement@1b4c72c8 [Element: <Blocking attributes: []/>]
org.dom4j.tree.DefaultElement
Blocking
1000045940507民航局測試台鐵西部(縱)幹線松山臺北223K+800M東正線AA17松山=臺北間121.56125.04620130418 - 05570005:57分1次行經松山、台北間東正線時，發現K23+800處電車線斷落。06:10出動搶修車，改以西正線單線行車，06:50成立二級應變小組。20140516 - 155512rail

org.dom4j.QName@dc3dd055 [name: Blocking namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:2
org.dom4j.tree.DefaultElement@3803b678 [Element: <Blocking attributes: []/>]
org.dom4j.tree.DefaultElement
Blocking
1000045920507民航局測試台鐵臺東線瑞穗富源257K+300M正線UU09富源=瑞穗間121.37723.55120130403 - 07550004時30分鐵工局東工處電力工程隊架線車在瑞穗、富源間K57+300處，發生兩輛平車出軌事故，致路線暫時不通。20140516 - 155512rail

org.dom4j.QName@dc3dd055 [name: Blocking namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:3
org.dom4j.tree.DefaultElement@7bc09d02 [Element: <Blocking attributes: []/>]
org.dom4j.tree.DefaultElement
Blocking
1000045890507民航局測試台鐵西部(縱)幹線松山臺北223K+800M東正線AA17松山=臺北間121.56125.04620130911 - 05570005:57分1次行經松山、台北間東正線時，發現K23+800處電車線斷落。06:10出動搶修車，改以西正線單線行車，06:50成立二級應變小組。20140516 - 144258rail

org.dom4j.QName@dc3dd055 [name: Blocking namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:4
org.dom4j.tree.DefaultElement@22842dc7 [Element: <Blocking attributes: []/>]
org.dom4j.tree.DefaultElement
Blocking
1000045850507民航局測試台鐵臺東線瑞穗富源257K+300M正線UU09富源=瑞穗間121.37723.55120130903 - 07550004時30分鐵工局東工處電力工程隊架線車在瑞穗、富源間K57+300處，發生兩輛平車出軌事故，致路線暫時不通。20140516 - 144258rail

org.dom4j.QName@dc3dd055 [name: Blocking namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
-----list------
item:5
org.dom4j.tree.DefaultElement@34fa4704 [Element: <Blocking attributes: []/>]
org.dom4j.tree.DefaultElement
Blocking
1000045960507民航局測試台鐵西部(縱)幹線大林民雄2286K+900M東正線QQ05大林=民雄間120.43223.55820130829 - 060300因康芮颱風帶來豪雨影響，民雄站北端大水淹過軌面，自6時03分起民雄=大林間東線暫時不通。綜調所02-2138康芮颱風豪大雨,水淹過軌面.二水=林鳳營間東西線不通(趕時間的旅客請改搭其他交通工具)020140516 - 155512rail

org.dom4j.QName@dc3dd055 [name: Blocking namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:6
org.dom4j.tree.DefaultElement@1b4c72c8 [Element: <Blocking attributes: []/>]
org.dom4j.tree.DefaultElement
Blocking
1000045940507民航局測試台鐵西部(縱)幹線松山臺北223K+800M東正線AA17松山=臺北間121.56125.04620130418 - 05570005:57分1次行經松山、台北間東正線時，發現K23+800處電車線斷落。06:10出動搶修車，改以西正線單線行車，06:50成立二級應變小組。20140516 - 155512rail

org.dom4j.QName@dc3dd055 [name: Blocking namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:7
org.dom4j.tree.DefaultElement@3803b678 [Element: <Blocking attributes: []/>]
org.dom4j.tree.DefaultElement
Blocking
1000045920507民航局測試台鐵臺東線瑞穗富源257K+300M正線UU09富源=瑞穗間121.37723.55120130403 - 07550004時30分鐵工局東工處電力工程隊架線車在瑞穗、富源間K57+300處，發生兩輛平車出軌事故，致路線暫時不通。20140516 - 155512rail

org.dom4j.QName@dc3dd055 [name: Blocking namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:8
org.dom4j.tree.DefaultElement@7bc09d02 [Element: <Blocking attributes: []/>]
org.dom4j.tree.DefaultElement
Blocking
1000045890507民航局測試台鐵西部(縱)幹線松山臺北223K+800M東正線AA17松山=臺北間121.56125.04620130911 - 05570005:57分1次行經松山、台北間東正線時，發現K23+800處電車線斷落。06:10出動搶修車，改以西正線單線行車，06:50成立二級應變小組。20140516 - 144258rail

org.dom4j.QName@dc3dd055 [name: Blocking namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:9
org.dom4j.tree.DefaultElement@22842dc7 [Element: <Blocking attributes: []/>]
org.dom4j.tree.DefaultElement
Blocking
1000045850507民航局測試台鐵臺東線瑞穗富源257K+300M正線UU09富源=瑞穗間121.37723.55120130903 - 07550004時30分鐵工局東工處電力工程隊架線車在瑞穗、富源間K57+300處，發生兩輛平車出軌事故，致路線暫時不通。20140516 - 144258rail

org.dom4j.QName@dc3dd055 [name: Blocking namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:10
org.dom4j.tree.DefaultElement@13d97585 [Element: <Resume attributes: []/>]
org.dom4j.tree.DefaultElement
Resume
1000025070507民航局測試台鐵77K+71.5080000000016M西正線宜蘭縣五結鄉121.77424.705 R12班車無法通行 導致鐵路停駛無法通行  R12班車無法通行 20130908 - 19250020130912 - 07550020140516 - 144258rail

org.dom4j.QName@91b2b44d [name: Resume namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:11
org.dom4j.tree.DefaultElement@29b278f1 [Element: <Suspend attributes: []/>]
org.dom4j.tree.DefaultElement
Suspend
1000026070507民航局測試台鐵內灣線世博內灣全面停駛412有颱風20140618 - 153049hywebqqq20140618 - 153049

org.dom4j.QName@f4d5381c [name: Suspend namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:12
org.dom4j.tree.DefaultElement@4222b9a [Element: <Suspend attributes: []/>]
org.dom4j.tree.DefaultElement
Suspend
1000026030507民航局測試台鐵西部(縱)幹線二水大林部分停駛111;    222;    333;    444自動介接test test旅資台 TEST 1025，第2次續報20140516 - 155512rail20140516 - 155512

org.dom4j.QName@f4d5381c [name: Suspend namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:13
org.dom4j.tree.DefaultElement@5f5c8d94 [Element: <Suspend attributes: []/>]
org.dom4j.tree.DefaultElement
Suspend
1000026010507民航局測試台鐵西部(縱)幹線後壁新營部分停駛111;    222;    369"0924第1次介接測試"因OO颱風造成樹木傾倒、侵入路線進而造成111列車出軌人員死傷發生"0924第1次介接測試"測試完畢20140516 - 144258rail20140516 - 144258

org.dom4j.QName@f4d5381c [name: Suspend namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:14
org.dom4j.tree.DefaultElement@35532075 [Element: <Suspend attributes: []/>]
org.dom4j.tree.DefaultElement
Suspend
1000025990507民航局測試台鐵臺東線東里臺東部分停駛100;    1010919第1次介接測試，因颱風造成土石流掩沒路線，以致路線中斷無法行駛0917第1次測試，針對路線阻斷造成旅客不便之處，已通知相關車站加強旅客廣播20140516 - 144258rail20140516 - 144258

org.dom4j.QName@f4d5381c [name: Suspend namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:15
org.dom4j.tree.DefaultElement@6477fcac [Element: <Suspend attributes: []/>]
org.dom4j.tree.DefaultElement
Suspend
1000025970507民航局測試台鐵南迴線枋野枋山部分停駛888"0917介接測試"因OO陸上颱風造成9K+900處土石流，並造成999次列車機車檔泥板受損0917測試完畢20140516 - 144258rail20140516 - 144258

org.dom4j.QName@f4d5381c [name: Suspend namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:16
org.dom4j.tree.DefaultElement@16db3bc [Element: <Airport attributes: []/>]
org.dom4j.tree.DefaultElement
Airport
1000063540507民航局測試綠島機場暫停起降或關閉20140515 - 123000受0507民航局測試影響 颱風暫停起降20140515 - 15062320140515 - 151100caa0120140519 - 134521caa01

org.dom4j.QName@281cf4ab [name: Airport namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:17
org.dom4j.tree.DefaultElement@4932fc5f [Element: <Airport attributes: []/>]
org.dom4j.tree.DefaultElement
Airport
1000063460507民航局測試七美機場暫停起降或關閉20140507 - 123000受0507民航局測試影響 333暫停起降20140507 - 11245520140507 - 121611caa0120140507 - 112455

org.dom4j.QName@281cf4ab [name: Airport namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:18
org.dom4j.tree.DefaultElement@3256e684 [Element: <Airport attributes: []/>]
org.dom4j.tree.DefaultElement
Airport
1000063520507民航局測試臺灣桃園國際機場暫停起降或關閉20140507 - 123000受0514民航局測試影響 333關閉20140507 - 11245520140507 - 121611caa0120140507 - 112455

org.dom4j.QName@281cf4ab [name: Airport namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:19
org.dom4j.tree.DefaultElement@6737fded [Element: <Airport attributes: []/>]
org.dom4j.tree.DefaultElement
Airport
1000063440507民航局測試七美機場暫停起降或關閉20140507 - 123000受0507民航局測試影響 11111暫停起降20140507 - 11221920140507 - 121611caa0120140507 - 112219

org.dom4j.QName@281cf4ab [name: Airport namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:20
org.dom4j.tree.DefaultElement@d00078c [Element: <Airport attributes: []/>]
org.dom4j.tree.DefaultElement
Airport
1000063420507民航局測試臺中機場暫停起降或關閉20140507 - 103000受0507民航局測試影響 暫停起降20140507 - 11094020140507 - 121611caa0120140507 - 110940

org.dom4j.QName@281cf4ab [name: Airport namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:21
org.dom4j.tree.DefaultElement@7cef7efe [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039290507民航局測試20140507 - 193000立榮航空B7340北竿-松山延誤0507民航局測試20140507 - 113638caa0120140519 - 134721caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:22
org.dom4j.tree.DefaultElement@4f7a95c6 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039270507民航局測試20140507 - 132000立榮航空B7338北竿-松山延誤0507民航局測試20140507 - 113638caa0120140519 - 134721caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:23
org.dom4j.tree.DefaultElement@78ff22ed [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039250507民航局測試20140507 - 090000立榮航空B7336北竿-松山延誤0507民航局測試20140507 - 113638caa0120140519 - 134721caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:24
org.dom4j.tree.DefaultElement@364e33aa [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039230507民航局測試20140507 - 171000立榮航空B7320南竿-松山取消0507民航局測試20140507 - 113340caa0120140519 - 134721caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:25
org.dom4j.tree.DefaultElement@4821f9c0 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039210507民航局測試20140507 - 133500立榮航空B7372南竿-臺中延誤0507民航局測試20140507 - 113340caa0120140519 - 134721caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:26
org.dom4j.tree.DefaultElement@2e93d13f [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039190507民航局測試20140507 - 075000立榮航空B7302南竿-松山取消0507民航局測試20140507 - 113340caa0120140519 - 134721caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:27
org.dom4j.tree.DefaultElement@6a8e96fc [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039170507民航局測試20140507 - 073000立榮航空B73102南竿-松山延誤0507民航局測試20140507 - 113340caa0120140519 - 134721caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:28
org.dom4j.tree.DefaultElement@375ab10b [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039150507民航局測試20140507 - 135000德安航空DA7508蘭嶼-臺東延誤0507民航局測試20140507 - 111908caa0120140519 - 134721caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:29
org.dom4j.tree.DefaultElement@231d6591 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039130507民航局測試20140507 - 144000德安航空DA7518蘭嶼-臺東取消0507民航局測試20140507 - 111539caa0120140519 - 134721caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:30
org.dom4j.tree.DefaultElement@5ef72499 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039110507民航局測試20140507 - 111000德安航空DA7506蘭嶼-臺東取消0507民航局測試20140507 - 111539caa0120140519 - 134721caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:31
org.dom4j.tree.DefaultElement@3383e984 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039090507民航局測試20140507 - 102000德安航空DA7504蘭嶼-臺東延誤0507民航局測試20140507 - 111539caa0120140519 - 134721caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:32
org.dom4j.tree.DefaultElement@1957f388 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039070507民航局測試20140507 - 092500德安航空DA7502蘭嶼-臺東延誤0507民航局測試20140507 - 111539caa0120140519 - 134721caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:33
org.dom4j.tree.DefaultElement@5d3572b7 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039050507民航局測試20140507 - 130000德安航空DA7304綠島-臺東取消0507民航局測試20140507 - 111045caa0120140519 - 134720caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:34
org.dom4j.tree.DefaultElement@5ffe7c2f [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039030507民航局測試20140507 - 085000德安航空DA7302綠島-臺東延誤0507民航局測試20140507 - 111045caa0120140519 - 134720caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:35
org.dom4j.tree.DefaultElement@3c8b22e5 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039010507民航局測試20140507 - 183000復興航空GEGE020花蓮-松山取消0507民航局測試20140507 - 105926caa0120140519 - 134720caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:36
org.dom4j.tree.DefaultElement@52a00770 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038990507民航局測試20140507 - 150000復興航空GEGE018花蓮-松山延誤0507民航局測試20140507 - 105926caa0120140519 - 134720caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:37
org.dom4j.tree.DefaultElement@8487471 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038970507民航局測試20140507 - 213000復興航空GEGE3137天津-花蓮延誤0507民航局測試20140507 - 105900caa0120140519 - 134720caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:38
org.dom4j.tree.DefaultElement@4cd4aaf6 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038950507民航局測試20140507 - 184000華信航空AE394臺東-松山取消0507民航局測試20140507 - 105827caa0120140519 - 134720caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:39
org.dom4j.tree.DefaultElement@1e2423e2 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038930507民航局測試20140507 - 175500立榮航空B7858臺東-松山取消0507民航局測試20140507 - 105827caa0120140519 - 134720caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:40
org.dom4j.tree.DefaultElement@56afd9e3 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038910507民航局測試20140507 - 162000德安航空DA7311臺東-綠島延誤0507民航局測試20140507 - 105827caa0120140519 - 134720caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:41
org.dom4j.tree.DefaultElement@3309f28b [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038890507民航局測試20140507 - 201500復興航空GEGE228高雄-馬公取消0507民航局測試20140507 - 105726caa0120140519 - 134720caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:42
org.dom4j.tree.DefaultElement@52129dda [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038870507民航局測試20140507 - 193500立榮航空B76275高雄-馬公延誤0507民航局測試20140507 - 105726caa0120140519 - 134720caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:43
org.dom4j.tree.DefaultElement@44397d4e [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038850507民航局測試20140507 - 212000港龍航空KA457高雄-香港取消0507民航局測試20140507 - 105726caa0120140519 - 134720caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:44
org.dom4j.tree.DefaultElement@1a51aee0 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038830507民航局測試20140507 - 212000國泰航空CX5457高雄-香港延誤0507民航局測試20140507 - 105726caa0120140519 - 134720caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:45
org.dom4j.tree.DefaultElement@68b0019f [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038810507民航局測試20140507 - 135000中華航空CI167關西-高雄延誤0507民航局測試20140507 - 105659caa0120140519 - 134720caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:46
org.dom4j.tree.DefaultElement@7b3aa36a [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038790507民航局測試20140507 - 114000中華航空CI712馬尼拉-高雄延誤0507民航局測試20140507 - 105659caa0120140519 - 134720caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:47
org.dom4j.tree.DefaultElement@46bec35a [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038770507民航局測試20140507 - 110500中國南方航空CZ669CGQ-高雄延誤0507民航局測試20140507 - 105659caa0120140519 - 134719caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:48
org.dom4j.tree.DefaultElement@160b6dff [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038750507民航局測試20140507 - 183000立榮航空B7649臺南-馬公取消0507民航局測試20140507 - 105611caa0120140519 - 134719caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:49
org.dom4j.tree.DefaultElement@48628ba7 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038730507民航局測試20140507 - 161500立榮航空B7647臺南-馬公延誤0507民航局測試20140507 - 105611caa0120140519 - 134719caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:50
org.dom4j.tree.DefaultElement@3dbea611 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038710507民航局測試20140507 - 130000中華航空CI7868香港-臺南延誤0507民航局測試20140507 - 105539caa0120140519 - 134719caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:51
org.dom4j.tree.DefaultElement@2f88c5c2 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038690507民航局測試20140507 - 153000立榮航空B79255嘉義-金門延誤0507民航局測試20140507 - 105439caa0120140519 - 134719caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:52
org.dom4j.tree.DefaultElement@3c6f5bef [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038670507民航局測試20140507 - 190500立榮航空B76231臺中-馬公延誤0507民航局測試20140507 - 105240caa0120140519 - 134719caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:53
org.dom4j.tree.DefaultElement@32fcc6e8 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038650507民航局測試20140507 - 173000立榮航空B7629臺中-馬公取消0507民航局測試20140507 - 105240caa0120140519 - 134719caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:54
org.dom4j.tree.DefaultElement@7166c37e [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038630507民航局測試20140507 - 122000東方航空MU7478臺中-太原延誤0507民航局測試20140507 - 105240caa0120140519 - 134719caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:55
org.dom4j.tree.DefaultElement@11acbf5c [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038610507民航局測試20140507 - 112000東方航空MU7477太原-臺中延誤0507民航局測試20140507 - 105146caa0120140519 - 134719caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:56
org.dom4j.tree.DefaultElement@64473a14 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038590507民航局測試20140507 - 234000中華航空CI5991桃園-廈門取消0507民航局測試20140507 - 101213caa0120140519 - 134719caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:57
org.dom4j.tree.DefaultElement@362a7b [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038570507民航局測試20140507 - 162500東方航空MU2568桃園-LJG取消0507民航局測試20140507 - 101213caa0120140519 - 134719caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:58
org.dom4j.tree.DefaultElement@641ef158 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038550507民航局測試20140507 - 124000長榮航空BR869桃園-香港取消0507民航局測試20140507 - 101213caa0120140519 - 134719caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:59
org.dom4j.tree.DefaultElement@2b76fbc2 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038530507民航局測試20140507 - 124000香港航空HX1869桃園-香港取消0507民航局測試20140507 - 101213caa0120140519 - 134719caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:60
org.dom4j.tree.DefaultElement@108a93d9 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038510507民航局測試20140507 - 073000長榮航空BR658桃園-安克拉延誤0507民航局測試20140507 - 101213caa0120140519 - 134719caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:61
org.dom4j.tree.DefaultElement@79f0940a [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038490507民航局測試20140507 - 171000長榮航空BR870香港-桃園取消0507民航局測試20140507 - 101134caa0120140519 - 134718caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:62
org.dom4j.tree.DefaultElement@21875b11 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038470507民航局測試20140507 - 171000香港航空HX1870香港-桃園取消0507民航局測試20140507 - 101134caa0120140519 - 134718caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:63
org.dom4j.tree.DefaultElement@3d6bca49 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038450507民航局測試20140507 - 133500東方航空MU2567LJG-桃園取消0507民航局測試20140507 - 101134caa0120140519 - 134718caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:64
org.dom4j.tree.DefaultElement@6fad9e1f [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038430507民航局測試20140507 - 194500復興航空GEGE5175松山-馬公取消0507民航局測試20140507 - 095759caa0120140519 - 134718caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:65
org.dom4j.tree.DefaultElement@6f683e80 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038410507民航局測試20140507 - 193000復興航空GEGE513松山-馬公延誤0507民航局測試20140507 - 095759caa0120140519 - 134718caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:66
org.dom4j.tree.DefaultElement@24df7ea4 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038390507民航局測試20140507 - 190000華信航空AE369松山-馬公延誤0507民航局測試20140507 - 095759caa0120140519 - 134718caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:67
org.dom4j.tree.DefaultElement@4cf353e5 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038370507民航局測試20140507 - 204500廈門航空MF884松山-福州延誤0507民航局測試20140507 - 095759caa0120140519 - 134718caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:68
org.dom4j.tree.DefaultElement@7b0906da [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038350507民航局測試20140507 - 204500復興航空GEGE9884松山-福州取消0507民航局測試20140507 - 095759caa0120140519 - 134718caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:69
org.dom4j.tree.DefaultElement@da11151 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004038330507民航局測試20140507 - 194500廈門航空MF882松山-廈門延誤0507民航局測試20140507 - 095759caa0120140519 - 134718caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:70
org.dom4j.tree.DefaultElement@4977e3d4 [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039380507民航局測試20140515 - 130000德安航空DA7304綠島-臺東取消10507民航局測試20140515 - 150439caa0120140519 - 134521caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:71
org.dom4j.tree.DefaultElement@5e0e98fa [Element: <FlightTraffic attributes: []/>]
org.dom4j.tree.DefaultElement
FlightTraffic
1004039360507民航局測試20140515 - 085000德安航空DA7302綠島-臺東延誤10507民航局測試20140515 - 150439caa0120140519 - 134521caa01

org.dom4j.QName@438f874d [name: FlightTraffic namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:72
org.dom4j.tree.DefaultElement@105d7554 [Element: <AirportFacility attributes: []/>]
org.dom4j.tree.DefaultElement
AirportFacility
1000039590507民航局測試臺北松山機場20140515 - 1430001rereere12222ere20140515 - 143704caa0120140519 - 135629caa01

org.dom4j.QName@b157ec6e [name: AirportFacility namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:73
org.dom4j.tree.DefaultElement@67c1e630 [Element: <AirportFacility attributes: []/>]
org.dom4j.tree.DefaultElement
AirportFacility
1000039380507民航局測試恆春機場20140507 - 1230003333333320140507 - 112709caa0120140514 - 114001caa01

org.dom4j.QName@b157ec6e [name: AirportFacility namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:74
org.dom4j.tree.DefaultElement@6aef8e87 [Element: <AirportFacility attributes: []/>]
org.dom4j.tree.DefaultElement
AirportFacility
1000039220507民航局測試屏東機場20140507 - 1230002626226220140507 - 113809caa0120140507 - 113809

org.dom4j.QName@b157ec6e [name: AirportFacility namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:75
org.dom4j.tree.DefaultElement@157677ea [Element: <AirportFacility attributes: []/>]
org.dom4j.tree.DefaultElement
AirportFacility
1000039200507民航局測試屏東機場20140507 - 1230009999920140507 - 113736caa0120140507 - 113736

org.dom4j.QName@b157ec6e [name: AirportFacility namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:76
org.dom4j.tree.DefaultElement@14baaea8 [Element: <AirportFacility attributes: []/>]
org.dom4j.tree.DefaultElement
AirportFacility
1000039260507民航局測試蘭嶼機場20140507 - 1230009999920140507 - 113452caa0120140507 - 113452

org.dom4j.QName@b157ec6e [name: AirportFacility namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:77
org.dom4j.tree.DefaultElement@6c20a239 [Element: <AirportFacility attributes: []/>]
org.dom4j.tree.DefaultElement
AirportFacility
1000039360507民航局測試恆春機場20140507 - 1230002222220140507 - 112337caa0120140507 - 112337

org.dom4j.QName@b157ec6e [name: AirportFacility namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:78
org.dom4j.tree.DefaultElement@527a83a4 [Element: <AirportFacility attributes: []/>]
org.dom4j.tree.DefaultElement
AirportFacility
1000039340507民航局測試恆春機場20140507 - 123000111120140507 - 112237caa0120140507 - 112237

org.dom4j.QName@b157ec6e [name: AirportFacility namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:79
org.dom4j.tree.DefaultElement@6958ae49 [Element: <AirportFacility attributes: []/>]
org.dom4j.tree.DefaultElement
AirportFacility
1000039240507民航局測試馬祖南竿機場20140507 - 1230001跑道燈光設備損壞跟換燈光設備1000000020140507 - 111130caa0120140507 - 111130

org.dom4j.QName@b157ec6e [name: AirportFacility namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:80
org.dom4j.tree.DefaultElement@3d1a70a7 [Element: <AirportFacility attributes: []/>]
org.dom4j.tree.DefaultElement
AirportFacility
1000039320507民航局測試20140507 - 0930002rterwtertwtwretwrewretrewertrewtrwerterwerttwretwertwerttwertwertwerwerttwert100000020140507 - 101031caa0120140507 - 101031

org.dom4j.QName@b157ec6e [name: AirportFacility namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:81
org.dom4j.tree.DefaultElement@12da0348 [Element: <AirportFacility attributes: []/>]
org.dom4j.tree.DefaultElement
AirportFacility
1000039300507民航局測試20140507 - 0930001監控設備損壞立即更換件5000020140507 - 100750caa0120140507 - 100750

org.dom4j.QName@b157ec6e [name: AirportFacility namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:82
org.dom4j.tree.DefaultElement@270d75a3 [Element: <AirportFacility attributes: []/>]
org.dom4j.tree.DefaultElement
AirportFacility
1000039280507民航局測試20140507 - 09300012雷達損壞testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest100000020140507 - 100255caa0120140507 - 100255

org.dom4j.QName@b157ec6e [name: AirportFacility namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
item:83
org.dom4j.tree.DefaultElement@64a6345c [Element: <ResourcePrepareState attributes: []/>]
org.dom4j.tree.DefaultElement
ResourcePrepareState
59990507民航局測試高速鐵路工程局捷運工程處2420140512 - 134646hywebqqq20140512 - 134646

org.dom4j.QName@bb547b18 [name: ResourcePrepareState namespace: "org.dom4j.Namespace@babe [Namespace: prefix  mapped to URI ""]"]
-----------
CASE_ID:
org.dom4j.tree.DefaultElement@151ec7df [Element: <CASE_ID attributes: [org.dom4j.tree.DefaultAttribute@17d40c4e [Attribute: name KEY value "123"]]/>]
2014070013addTextbar
MASTER:
A4
Austin
RootElement.TEXT:




XMLEncoding:
UTF-8
NodeTypeName:
Document
asXML:
<?xml version="1.0" encoding="UTF-8"?>
<ERA_DISP>
<CASE_ID KEY="123">2014070013<!--comment123-->addTextbar</CASE_ID>
<REPORT_CODE>LIFELINES_DAMAGES</REPORT_CODE><MASTER>A4<NAME>Austin</NAME><AGE>40</AGE></MASTER>
</ERA_DISP>
[END]


	 */

	
}
