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

public class SiteDetails {

	public void getSiteList(List<SiteList> lstSiteLists) throws IOException {

		String stringURL = "http://9.220.9.130:50200/XMII/Illuminator?IsTesting=T&QueryTemplate=Default/Som/OCP_KPI/SQL_GetSiteList&Content-Type=text/xml&IllumLoginName=som&IllumLoginPassword=password@1";

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

		for (int i = 0; i < nodes.getLength(); i++) {
			Element element = (Element) nodes.item(i);

			NodeList site = element.getElementsByTagName("SITE");
			Element line = (Element) site.item(0);
			String Site = getCharacterDataFromElement(line);

			NodeList desc = element.getElementsByTagName("DESCRIPTION");
			line = (Element) desc.item(0);
			String Desc = getCharacterDataFromElement(line);

			lstSiteLists.add(new SiteList(Site,Desc));


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

}
