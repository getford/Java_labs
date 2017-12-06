import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

import static sun.font.CreatedFontTracker.MAX_FILE_SIZE;

@WebServlet(urlPatterns = "/sss")
public class Sss extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet:SSS");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        downloadFile(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Sss: doPost()");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY_IMAGE;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        item.write(storeFile);
                        ServletContext servletContext = getServletContext();
                        servletContext.setAttribute("img-dir", filePath);
                        servletContext.getAttribute("img-dir");
                        System.out.println(servletContext.getAttribute("img-dir"));
                    }
                }
            }
        } catch (Exception ex) {
            req.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }
    }

    private void downloadFile(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String fileName = req.getParameter("fn");
        String filePath = req.getServletContext().getInitParameter("file-dir");

        resp.setContentType("application/download");
        resp.addHeader("Content-Disposition", "attachment; filename = " + fileName);


    }
}




/*
    String fileName = req.getParameter("filename");
    String filePath = req.getParameter("filename");

        req.setCharacterEncoding("utf-8");
                resp.setCharacterEncoding("utf-8");

                ServletOutputStream servletOutputStream = resp.getOutputStream();
                resp.addHeader("Content-Disposition", "attachment;filename=" + fileName);

                File file = new File(getServletContext().getRealPath("/"), filePath + "/" + fileName);
                long len = file.length();
                resp.setHeader("Content-Length", String.valueOf(len));
                resp.setContentType("application/download");

                FileInputStream fileInputStream = new FileInputStream(file);
                int tmp;
                while ((tmp = fileInputStream.read())!= -1){
                servletOutputStream.write(tmp);
                }

                fileInputStream.close();
                servletOutputStream.close();

        //-----------------------------------------------------------------------------------
        resp.setContentType("text/plain");
        resp.setHeader("Content-Disposition", "attachment;filename=filename.docx");

        ServletContext servletContext = getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/file.docx");

        String filename = req.getParameter("file");
        //String dir = getServletContext().getInitParameter("file-dir");

        System.out.println("filename: " + filename);
        //System.out.println("dir: " + dir);*/