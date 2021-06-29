package hfu.modgswe.aufgabe1.pojo;

public class ServiceCall {
        private String CustomerName;
        private String CustomerID;
        private String CallTypeCode;
        private String DateOfCallString;

    public ServiceCall() {
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getCallTypeCode() {
        return CallTypeCode;
    }

    public void setCallTypeCode(String callTypeCode) {
        CallTypeCode = callTypeCode;
    }

    public String getDateOfCallString() {
        return DateOfCallString;
    }

    public void setDateOfCallString(String dateOfCallString) {
        DateOfCallString = dateOfCallString;
    }
}