package com.example.davids.minitabletapp.Entities;

/**
 * Created by Anton on 3/15/2017.
 */

public class StringText {
      float fontSize;
      String text;

    public StringText(float fontSize, String text, String textHeader, String number) {
        this.fontSize = fontSize;
        this.text = text;
        this.textHeader = textHeader;
        this.number = number;
    }

    String textHeader;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    String number;
    public String getTextHeader() {
        if (textHeader.indexOf(" ")!=-1) {
        String line1=textHeader.substring(0,textHeader.indexOf(" "));
        String line2  =textHeader.substring( textHeader.indexOf(" "),textHeader.length());
        return line1+"        "+line2.trim();
        }else {
            return textHeader;
        }
    }
    public String getTextHeaderWithoutSpaces() {
        if (textHeader.indexOf(" ")!=-1) {
            String line1 = textHeader.substring(0, textHeader.indexOf(" "));
            String line2 = textHeader.substring(textHeader.indexOf(" "), textHeader.length());
            return line1  +" "+line2.trim();
        }else {
            return textHeader;
        }
    }
    public void setTextHeader(String textHeader) {
        this.textHeader = textHeader;
    }







    public float getFontSize() {

        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
