package NoNameTel;

public class Region{

	private String code;
	
	public Region(String areaCode){//Constructor
		code = areaCode;
	}

	public String getCode() { //getter method for areacode
		return code;
	}
        
    @Override
    public String toString(){//String representation using string format
        String result = "      "+code +"\n";
      
        return result;
    }

}

