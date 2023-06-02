package org.example;
public class Casting {
    public double decimalNum = 112.35;
    public String stringValue = "49";

    public int castDoubleToInt(double decimalNum) {
        return (int) decimalNum;
        }
        public int parseStringToInt(String stringValue) {
        return Integer.parseInt(stringValue);
        }
    }
