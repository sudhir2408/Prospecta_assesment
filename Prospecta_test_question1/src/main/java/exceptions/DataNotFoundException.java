package exceptions;

public class DataNotFoundException {
	
	private static final long serialVersionUID = 1L;


    String dataName;
    String fieldName;
    String fieldValue1;
    Integer fieldValue2;



    public DataNotFoundException(String dataName, String fieldName, String fieldValue1) {
        super();
        this.dataName = dataName;
        this.fieldName = fieldName;
        this.fieldValue1 = fieldValue1;
    }

    public DataNotFoundException(String dataName, String fieldName, Integer fieldValue2) {
        super();
        this.dataName = dataName;
        this.fieldName = fieldName;
        this.fieldValue2 = fieldValue2;

}
}
