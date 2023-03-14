package Utility;

import java.util.regex.Pattern;

import Exception.InvalidEmailIdException;
import Exception.InvalidMobilNoException;
import Exception.InvalidNameException;

public class RegexUtil {

public boolean isStartWithCapitalLatter(String input) {
  boolean checkCondition = Pattern.matches(ERegexPattern.FIRST_NAME_PATTERN.getValue(), input);
  if (checkCondition == false) {
      throw new InvalidNameException("Invalid Name !!!!!!!!!!!!!!!!!!!!!!");

  }

  return checkCondition;
}

public boolean isCheckMobileNumber(String input) {
  boolean checkCondition = Pattern.matches(ERegexPattern.MOBILE_NO_PATTERN.getValue(), input);
  if (checkCondition == false) {
      throw new InvalidMobilNoException("Invalid mobile number !!!!!!!!!!!!!!!!!!!");

  }

  return checkCondition;
}

public boolean isCheckEmailId(String input) {
  boolean checkCondition = Pattern.matches(ERegexPattern.Email_ID_PATTERN.getValue(), input);
  if (checkCondition == false) {
      throw new InvalidEmailIdException("Invalid Email Id !!!!!!!!!!!!!!!!!!!");


  }

  return checkCondition;
}
}
