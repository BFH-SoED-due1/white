/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.helpers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SuppressWarnings("rawtypes")
public class JAXBHelper {
	public static void saveInstance ( OutputStream outputStream , Object instance )

	throws JAXBException, IOException {
	Marshaller marshaller = JAXBContext. newInstance ( instance . getClass () ). createMarshaller () ;
	marshaller.setProperty ( Marshaller . JAXB_FORMATTED_OUTPUT , Boolean . TRUE );
	marshaller.marshal ( instance , outputStream );
	outputStream.flush() ;
	}

	public static Object loadInstance ( InputStream inputStream , Class instanceClass )
	throws JAXBException, IOException {
	// LengthUnits lengthUnits = JAXB . unmarshal ( inputStream , LengthUnits . class );
	Unmarshaller unmarshaller = JAXBContext . newInstance ( instanceClass ). createUnmarshaller () ;
	Object instance = unmarshaller . unmarshal ( inputStream );
	return instance ;
	}
	static class LocalFileSchemaResolver extends SchemaOutputResolver {
		private File baseDir ;
		public LocalFileSchemaResolver ( File baseDir ) {
		this . baseDir = baseDir ;
		}
		public Result createOutput ( String namespaceUri , String suggestedFileName )
		throws IOException {
		return new StreamResult (new File ( baseDir , suggestedFileName ));
		}
		}
		public static void saveSchema ( File baseDir , Class ... classes )
		throws JAXBException , IOException {
		JAXBContext context = JAXBContext . newInstance ( classes );
		context . generateSchema ( new LocalFileSchemaResolver ( baseDir ));
		}
}

