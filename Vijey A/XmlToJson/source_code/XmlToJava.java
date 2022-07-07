package com.convertxml;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class XmlToJava {
 
 private static final int INDENTATION_FACTOR = 4;
 public static String xmlString=
		 "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
		 + "<catalog>"
		 + "   <book id=\"bk101\">"
		 + "      <author>Gambardella, Matthew</author>"
		 + "      <title>XML Developer's Guide</title>"
		 + "      <genre>Computer</genre>"
		 + "      <price>44.95</price>"
		 + "      <publish_date>2000-10-01</publish_date>"
		 + "      <description>An in-depth look at creating applications with XML.</description>"
		 + "   </book>"
		 + "   <book id=\"bk102\">\r\n"
		 + "      <author>Ralls, Kim</author>"
		 + "      <title>Midnight Rain</title>"
		 + "      <genre>Fantasy</genre>\r\n"
		 + "      <price>5.95</price>\r\n"
		 + "      <publish_date>2000-12-16</publish_date>"
		 + "      <description>A former architect battles corporate zombies,an evil sorceress, and her own childhood to become queen"
		 + "      of the world.</description>\r\n"
		 + "   </book>"
		 + "   <book id=\"bk103\">"
		 + "      <author>Corets, Eva</author>"
		 + "      <title>Maeve Ascendant</title>"
		 + "      <genre>Fantasy</genre>"
		 + "      <price>5.95</price>"
		 + "      <publish_date>2000-11-17</publish_date>"
		 + "      <description>After the collapse of a nanotechnology society in England, the young survivors lay the foundation for a new society.</description>"
		 + "   </book>"
		 + "   <book id=\"bk104\">"
		 + "      <author>Corets, Eva</author>"
		 + "      <title>Oberon's Legacy</title>"
		 + "      <genre>Fantasy</genre>"
		 + "      <price>5.95</price>"
		 + "      <publish_date>2001-03-10</publish_date>"
		 + "      <description>In post-apocalypse England, the mysterious agent known only as Oberon helps to create a new life or the inhabitants of London. Sequel to Maeve Ascendant.</description>"
		 + "   </book>"
		 + "</catalog>";
 

 public static void main(String[] args){
	 try {
		 JSONObject jsonObject = XML.toJSONObject(xmlString);
		 String jsonPrintString = jsonObject.toString(INDENTATION_FACTOR);
		 System.out.println(jsonPrintString);		 
	 }
	 catch(JSONException ex){
		 System.out.println("Error Message : "+ex.getMessage());	 
	 }
 }
}