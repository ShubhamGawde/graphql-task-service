package com.taskmanagement.taskservice.utilities;

public class Utils {

  public static boolean nullOrEmptyOrZero(Integer value) {
    return value == null || value.equals(Integer.MIN_VALUE) || value == 0;
  }

  public static boolean nullOrEmptyOrZero(Long value) {
    return value == null || value.equals(Long.MIN_VALUE) || value == 0;
  }

  public static boolean nullOrEmptyOrZero(Double value) {
    return value == null || value.equals(Double.MIN_VALUE) || value == 0;
  }

  public boolean nullOrEmptyOrZero(String value) {
    return value == null || value.isEmpty();
  }
}
