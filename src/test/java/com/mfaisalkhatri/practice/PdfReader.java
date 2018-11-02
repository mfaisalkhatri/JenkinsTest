package com.mfaisalkhatri.practice;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * @author Faisal
 *
 */
public class PdfReader {

	/**
	 * @throws IOException
	 */
	@Ignore
	@Test
	public void test1() throws IOException {

		URL url = new URL("file:///D:/Study/pdf_files/AI.pdf");

		BufferedInputStream TestFile = new BufferedInputStream(url.openStream());
		PDDocument doc = PDDocument.load(TestFile);
		// TestPDF.parse();
		String TestText = new PDFTextStripper().getText(doc);

		doc.close();
		TestFile.close();

		System.out.println(TestText);
		Assert.assertTrue(TestText.contains("What is Artificial Intelligence?"));
	}

	/**
	 * @throws IOException
	 */
	@Test
	public void test2() throws IOException {

		URL url = new URL("http://unec.edu.az/application/uploads/2014/12/pdf-sample.pdf");

		BufferedInputStream TestFile = new BufferedInputStream(url.openStream());
		PDDocument doc = PDDocument.load(TestFile);
		String TestText = new PDFTextStripper().getText(doc);

		doc.close();
		TestFile.close();

		System.out.println(TestText);

		Assert.assertTrue(
				TestText.contains("The free Acrobat Reader is easy to download and can be freely distributed "));
		System.out.println("Test case 2 Passed.");

	}

}
