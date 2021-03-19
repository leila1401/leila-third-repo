package com.saraya;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saraya.model.PhotoService;
@Controller
public class PhotoController {
	@Autowired 
	private PhotoService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value="/photo-list", method = RequestMethod.GET)
	public String showPhotoList(ModelMap model) {
		String user = getLoggedInUserName();
		model.addAttribute("photos", service.retrievePhotos(user));
		return "photoList";
	}
	@RequestMapping(value = "/add-photo", method = RequestMethod.GET)
	public String showAddPhotoPage(ModelMap model) {
		model.addAttribute("photo", new Photo());
		return "add-photo";
	}

	@RequestMapping(value = "/add-photo", method = RequestMethod.POST)
	public String addPhoto(ModelMap model, @Valid Photo photo, BindingResult result) {

		if (result.hasErrors())
			return "add-photo";

		service.addPhoto(getLoggedInUserName(), photo.getPhotoUrl(), photo.getTitle(),
				photo.getTargetDate());
		model.clear();
		return "redirect:/photo-list";
	}
	@RequestMapping(value = "/update-photo", method = RequestMethod.GET)
	public String showUpdatePhotoPage(ModelMap model, @RequestParam int id) {
		model.addAttribute("photo", service.retrievePhoto(id));
		return "add-photo";
	}

	@RequestMapping(value = "/update-photo", method = RequestMethod.POST)
	public String updatePhoto(ModelMap model, @Valid Photo photo,
			BindingResult result) {
		if (result.hasErrors())
			return "add-photo";

		photo.setUser(getLoggedInUserName());
		service.UpDatePhoto(photo);

		model.clear();
		return "redirect:/photo-list";
	}

	@RequestMapping(value = "/delete-photo", method = RequestMethod.GET)
	public String deletePhoto(@RequestParam int id) {
		service.deletePhoto(id);

		return "redirect:/photo-list";
	}


	private String getLoggedInUserName() {
		// TODO Auto-generated method stub
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();	
		}
		return principal.toString();
	}
	
}




