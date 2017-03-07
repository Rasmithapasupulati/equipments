package com.nt.QR;

import com.beingjavaguys.dao.UserDaoImpl;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.glxn.qrgen.image.ImageType;

@SuppressWarnings("unused")
public class QRCode extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
System.out.println("request: "+request);
		String qrtext = request.getParameter("Equipment_Name");

		ByteArrayOutputStream out = QRCode.from(qrtext).to(
				ImageType.PNG).stream();
		
		response.setContentType("image/png");
		response.setContentLength(out.size());
		
		OutputStream outStream = response.getOutputStream();

		outStream.write(out.toByteArray());

		outStream.flush();
		outStream.close();
	}

	private static net.glxn.qrgen.QRCode from(String qrtext) {
		// TODO Auto-generated method stub
		return null;
	}
}
