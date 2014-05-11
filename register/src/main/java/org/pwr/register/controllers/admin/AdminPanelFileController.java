package org.pwr.register.controllers.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.pwr.register.controllers.FileController;
import org.pwr.register.controllers.HomeController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/adminPanel")
public class AdminPanelFileController {

	@RequestMapping(value = "/upload/", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity uploadFile(
			@RequestBody MultipartFile file) {
		//System.out.println(file.getOriginalFilename());
		//System.out.println(file.getName());
		//System.out.println(HomeController.getResourcesPath());
		String name = FileController.getResourcesPath() + "/" + file.getOriginalFilename();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(name)));
				stream.write(bytes);
				stream.close();

				return new ResponseEntity<String>("You successfully uploaded ",
						HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<String>("You failed to upload "
						+ e.getMessage(), HttpStatus.CONFLICT);

			}
		} else {
			return new ResponseEntity<String>(
					"You failed to upload because the file was empty.",
					HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		}
	}

	

}
