<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*"%>

<%
	//String fileName="C:/Users/DV-premendrak/Desktop/Foundations Of AJAX.pdf";
	String fileName = request.getParameter("fileName");
	fileName = (fileName != null && !fileName.trim().equals("")) ? fileName
			.trim() : "";
	if (!fileName.equals("")) {
		out.println(fileName);
		File f = new File(fileName);
		if (f.exists() && f.isFile()) {
			int length = 0;
			ServletOutputStream op = response.getOutputStream();
			ServletContext context = getServletConfig()
					.getServletContext();
			String mimetype = context.getMimeType(fileName);
			response.setContentType((mimetype != null) ? mimetype
					: "application/octet-stream");
			response.setContentLength((int) f.length());
			//response.setHeader("Content-Disposition","attachment:filename="+fileName);
			/***
			 * While setting the header, 
			 * replace "attachment" with "inline" so that the browser will try 
			 * to open the file with default application in your machine. 
			 **/
			response.setHeader("Content-Disposition",
					"inline:filename=" + fileName);
			//complete file downloading using buffering
			byte[] bbuf = new byte[1024];
			DataInputStream in = new DataInputStream(
					new FileInputStream(f));

			while ((in != null) && ((length = in.read(bbuf)) != -1)) {
				op.write(bbuf, 0, length);
			}
			in.close();
			op.flush();
			op.close();

		} else if (f.exists() && f.isDirectory()) {

			File[] children = f.listFiles();
			if (children != null && children.length > 0) {
%>
<ul>
	<%
		for (File child : children) {
	%>
	<li><a href="<%="?fileName=" + child.getAbsolutePath()%>"><%=child.getName()%></a></li>
	<%
		}
	%>
</ul>
<%
	}

		}
	}
%>