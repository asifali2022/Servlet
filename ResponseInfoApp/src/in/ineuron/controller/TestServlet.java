package in.ineuron.controller;

import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");
		File file=new File("E:\\javap\\ResponseInfoApp\\14.jpeg");
		FileInputStream fis=new FileInputStream(file);
		byte[] b=new byte[(int)file.length()];
		fis.read(b);
		
		ServletOutputStream stream = response.getOutputStream();
		stream.write(b);
		stream.flush();
		stream.close();
		
		
	}

}
