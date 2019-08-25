package com.yilmazakkan.petclinic.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yilmazakkan.petclinic.model.Owner;
import com.yilmazakkan.petclinic.service.PetClinicService;

@Controller
public class PetClinicNewOwnerController
{
	@Autowired
	private PetClinicService petClinicService;
	
	
	@RequestMapping(value="/owners/new", method=RequestMethod.GET)
	public String newOwner() {
			
			return "newOwner";
		}
	
	@ModelAttribute
	public Owner initModel() {
		return new Owner();
	}
	
	@RequestMapping(value="/owners/new", method=RequestMethod.POST)
	public String handlerFormSubmit( @ModelAttribute @Valid Owner owner, BindingResult bindingResult, RedirectAttributes redirectAttributes)  {
		if (bindingResult.hasErrors()) {
			return"newOwner";
			
		}
		
		petClinicService.createOwner(owner);
		redirectAttributes.addFlashAttribute("message", "Owner created with id :" + owner.getId()); //jsp sayfasına eklenen id mesaj verir.
		return "redirect:/owners";
	}
}
