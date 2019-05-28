package NoNameTel;
public class DirectoryEntry {
    
    protected String initials,  address, city, telephone;//Attributes
    
    public DirectoryEntry(String qinitial, String qAddress, String qCity, String qTelephone){//Constructor
        initials = qinitial;     
        address = qAddress;
        telephone = qTelephone;
        city = qCity;
    }

    public void setTelephone(String tele){ //replaces the current telephone number to a different one
        telephone = tele;
    }
    @Override
    public String toString(){//String representation using string format
        String result = (initials + "\n" + address + "\n" + telephone + "\n" + city+"\n");
      
        return '\n' + result;
    }
}
