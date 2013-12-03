public class EXZEZDM{

	DataObject dto //該Bean的固定命名

	private String mawb;//1:託運單主號
	private String hawb;//2:託運單分號
	private BigDecimal itemNo;//3:序號
	private String goodsDesc;//4:貨物名稱
	private String brand;//5:牌名(商標)
	private String model;//6:型號
	private String spec;//7:成分及規格
	private String cccCode;//8:貨品分類號列
	private BigDecimal qty;//9:數量
	private String qtyUnit;//10:數量單位
	private BigDecimal netWeight;//11:淨重
	private BigDecimal twdFob;//12:離岸價格(新台幣)
	private String stMode;//13:統計方式代碼

	public EXZEZDM(){

	}


	public void getValue(){

		DataObject dto = new DataObject()
		dto.getValue("MAWB");//1:託運單主號
		dto.getValue("HAWB");//2:託運單分號
		dto.getValue("ITEM_NO");//3:序號
		dto.getValue("GOODS_DESC");//4:貨物名稱
		dto.getValue("BRAND");//5:牌名(商標)
		dto.getValue("MODEL");//6:型號
		dto.getValue("SPEC");//7:成分及規格
		dto.getValue("CCC_CODE");//8:貨品分類號列
		dto.getValue("QTY");//9:數量
		dto.getValue("QTY_UNIT");//10:數量單位
		dto.getValue("NET_WEIGHT");//11:淨重
		dto.getValue("TWD_FOB");//12:離岸價格(新台幣)
		dto.getValue("ST_MODE");//13:統計方式代碼

		return dto;
	}

	public void getDataObject(){

		DataObject dto = new DataObject()
		dto.setValue(this.getMawb())
		dto.setValue(this.getHawb())
		dto.setValue(this.getItemNo())
		dto.setValue(this.getGoodsDesc())
		dto.setValue(this.getBrand())
		dto.setValue(this.getModel())
		dto.setValue(this.getSpec())
		dto.setValue(this.getCccCode())
		dto.setValue(this.getQty())
		dto.setValue(this.getQtyUnit())
		dto.setValue(this.getNetWeight())
		dto.setValue(this.getTwdFob())
		dto.setValue(this.getStMode())

		return dto;
	}

	public void setValue(DataObject dto){

		dto.setValue("MAWB", this.getMawb());//1:託運單主號
		dto.setValue("HAWB", this.getHawb());//2:託運單分號
		dto.setValue("ITEM_NO", this.getItemNo());//3:序號
		dto.setValue("GOODS_DESC", this.getGoodsDesc());//4:貨物名稱
		dto.setValue("BRAND", this.getBrand());//5:牌名(商標)
		dto.setValue("MODEL", this.getModel());//6:型號
		dto.setValue("SPEC", this.getSpec());//7:成分及規格
		dto.setValue("CCC_CODE", this.getCccCode());//8:貨品分類號列
		dto.setValue("QTY", this.getQty());//9:數量
		dto.setValue("QTY_UNIT", this.getQtyUnit());//10:數量單位
		dto.setValue("NET_WEIGHT", this.getNetWeight());//11:淨重
		dto.setValue("TWD_FOB", this.getTwdFob());//12:離岸價格(新台幣)
		dto.setValue("ST_MODE", this.getStMode());//13:統計方式代碼


	}
	public Map<String, Object> getMap(){
		Map<String, Object> ansMap = new TreeMap<String, Object>();
		ansMap.put("MAWB", this.getMawb());
		ansMap.put("HAWB", this.getHawb());
		ansMap.put("ITEM_NO", this.getItemNo());
		ansMap.put("GOODS_DESC", this.getGoodsDesc());
		ansMap.put("BRAND", this.getBrand());
		ansMap.put("MODEL", this.getModel());
		ansMap.put("SPEC", this.getSpec());
		ansMap.put("CCC_CODE", this.getCccCode());
		ansMap.put("QTY", this.getQty());
		ansMap.put("QTY_UNIT", this.getQtyUnit());
		ansMap.put("NET_WEIGHT", this.getNetWeight());
		ansMap.put("TWD_FOB", this.getTwdFob());
		ansMap.put("ST_MODE", this.getStMode());
		return ansMap;
	}
	public String toString(){
		String ans = "";
		ans += "MAWB="+mawbthis.getMawb()+"(託運單主號),"//託運單主號
		ans += "HAWB="+hawbthis.getHawb()+"(託運單分號),"//託運單分號
		ans += "ITEM_NO="+itemNothis.getItemNo()+"(序號),"//序號
		ans += "GOODS_DESC="+goodsDescthis.getGoodsDesc()+"(貨物名稱),"//貨物名稱
		ans += "BRAND="+brandthis.getBrand()+"(牌名(商標)),"//牌名(商標)
		ans += "MODEL="+modelthis.getModel()+"(型號),"//型號
		ans += "SPEC="+specthis.getSpec()+"(成分及規格),"//成分及規格
		ans += "CCC_CODE="+cccCodethis.getCccCode()+"(貨品分類號列),"//貨品分類號列
		ans += "QTY="+qtythis.getQty()+"(數量),"//數量
		ans += "QTY_UNIT="+qtyUnitthis.getQtyUnit()+"(數量單位),"//數量單位
		ans += "NET_WEIGHT="+netWeightthis.getNetWeight()+"(淨重),"//淨重
		ans += "TWD_FOB="+twdFobthis.getTwdFob()+"(離岸價格(新台幣)),"//離岸價格(新台幣)
		ans += "ST_MODE="+stModethis.getStMode()+"(統計方式代碼),"//統計方式代碼
		return ans;
	}
}

