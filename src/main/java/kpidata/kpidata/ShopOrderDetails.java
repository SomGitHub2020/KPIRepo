package kpidata.kpidata;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ShopOrderDetails {

	public void getOrderQuantities(List<OrderQty> lstOrderQtys) throws IOException{
		
		  String stringURL = "http://9.220.9.130:50200/XMII/Illuminator?IsTesting=T&QueryTemplate=Default/Som/OCP_KPI/ProductionOrder/SQL_GetShopOrderDetails&Content-Type=text/xml&IllumLoginName=som&IllumLoginPassword=password@1";
		  
		  	URL url = new URL(stringURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
			InputStream in = conn.getInputStream();
			
	      DocumentBuilderFactory dbf =
	          DocumentBuilderFactory.newInstance();
	      DocumentBuilder db = null;
			try {
				db = dbf.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	      Document doc = null;
			try {
				doc = (Document) db.parse(in);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
			NodeList nodes = ((org.w3c.dom.Document) doc).getElementsByTagName("Row");
			//NodeList nodes = ((org.w3c.dom.Document) doc).getElementsByTagName("TimeZoneResponse");
	      
	      // iterate the employees
			
	      for (int i = 0; i < nodes.getLength(); i++) {
	         Element element = (Element) nodes.item(i);
	         
	         NodeList target = element.getElementsByTagName("QTY_TO_BUILD");
	         Element line = (Element) target.item(0);
	         String Target = getCharacterDataFromElement(line);

	         NodeList actual = element.getElementsByTagName("QTY_DONE");
	         line = (Element) actual.item(0);
	         String Actual = getCharacterDataFromElement(line);
    
	         lstOrderQtys.add(new OrderQty(Actual,Target));
	         
	         
				System.out.print(i);

	      }
		
	}
	
	 public static String getCharacterDataFromElement(Element e) {
		    Node child = e.getFirstChild();
		    if (child instanceof CharacterData) {
		       CharacterData cd = (CharacterData) child;

		       return cd.getData();
		    }
		    return "?";
		  }

	 public OrderDetail getOrderData() throws IOException  {
		
		 String stringURL = "http://9.220.9.130:50200/XMII/Illuminator?IsTesting=T&QueryTemplate=Default/Som/OCP_KPI/ProductionOrder/SQL_GetShopOrderDetails&Content-Type=text/xml&IllumLoginName=som&IllumLoginPassword=password@1";
		  
		  	URL url = new URL(stringURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
			InputStream in = conn.getInputStream();
			
	      DocumentBuilderFactory dbf =
	          DocumentBuilderFactory.newInstance();
	      DocumentBuilder db = null;
			try {
				db = dbf.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	      Document doc = null;
			try {
				doc = (Document) db.parse(in);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
			NodeList nodes = ((org.w3c.dom.Document) doc).getElementsByTagName("Row");
			//NodeList nodes = ((org.w3c.dom.Document) doc).getElementsByTagName("TimeZoneResponse");
	      
			OrderDetail orderdetail = new OrderDetail();

	        for (int i = 0; i < nodes.getLength(); i++) {
	            Element element = (Element) nodes.item(i);
	            
	          
	            
	           NodeList nodelist = element.getElementsByTagName("SHOP_ORDER");
	            Element elem = (Element) nodelist.item(0);
	            //OrderNum = getCharacterDataFromElement(line);
	            orderdetail.setOrdernum(getCharacterDataFromElement(elem));
	            
	            nodelist = element.getElementsByTagName("ITEM_BO");
	            elem = (Element) nodelist.item(0);
	            //OrderNum = getCharacterDataFromElement(line);
	            orderdetail.setMaterial(getCharacterDataFromElement(elem).replaceFirst("ItemBO:PPME,", ""));

	        }
		
	      return orderdetail;
        
		

		
	}
	
}
