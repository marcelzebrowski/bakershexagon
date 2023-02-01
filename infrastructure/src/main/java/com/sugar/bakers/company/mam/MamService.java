package com.sugar.bakers.company.mam;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class MamService {

    @RequestMapping(value = "/images/{picture}", method = RequestMethod.GET)
    public void getImage(HttpServletResponse response, @PathVariable String picture) throws IOException {
        Resource resource = new ClassPathResource("images/" + picture+ ".png");
        InputStream in = resource.getInputStream();
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }
}
