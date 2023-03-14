package Utility;

public enum ERegexPattern {
	
    FIRST_NAME_PATTERN("^[A-Z]{1}[a-z]{1,}$"),
    MOBILE_NO_PATTERN("^(91)?[0-9]{10}"),
    Email_ID_PATTERN("^[a-z]+([+-.])?(.[a-z]+)?(.[0-9]+)?@([0-9]+.)?([a-z]+.)?([a-z]+.)?([a-z]+.)?$");

    String constant;
    private ERegexPattern(String constant)
    {
        this.constant=constant;
    }
    public String getValue()
    {
        return constant;
    }
}
