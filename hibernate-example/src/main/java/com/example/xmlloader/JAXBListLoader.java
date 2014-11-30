package com.example.xmlloader;

import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXB;

public class JAXBListLoader {

	public static final <T> T load(InputStream xml, Class<T> clazz) {
		return (T) JAXB.unmarshal(xml, clazz);
	}
	
}
