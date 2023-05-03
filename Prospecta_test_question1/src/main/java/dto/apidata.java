package dto;

import java.security.KeyStore;
import java.util.List;

public class apidata {
	
	private Integer count;

    private List<KeyStore.Entry> entries;

    public apidata() {
    }

    //all param construct //
    public apidata(Integer count, List<KeyStore.Entry> entries) {
        this.count = count;
        this.entries = entries;
    }

    
    // all getter setter implemented//
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<KeyStore.Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<KeyStore.Entry> entries) {
        this.entries = entries;
    }

}
