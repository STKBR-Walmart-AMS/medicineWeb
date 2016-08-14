/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.softtek.medicine.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softtek.medicine.model.Incident;
import com.softtek.medicine.model.RemedyUser;
import com.softtek.medicine.util.Util;

@Controller
@RequestMapping(value = "/")
public class MemberController {
	// @Autowired
	// private MemberDao memberDao;

	private Util utils = new Util();
	List<Incident> lstIncident = new ArrayList<Incident>();

	@RequestMapping(method = RequestMethod.GET)
	public String displaySortedMembers(Model model) {
		model.addAttribute("newMember", new RemedyUser());
		// model.addAttribute("members", memberDao.findAllOrderedByName());
		return "index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerNewMember(@Valid @ModelAttribute("newMember") RemedyUser newMember, BindingResult result,
			Model model) {
		if (!result.hasErrors()) {

			HashMap<Object, Object> map = new HashMap<Object, Object>();

			map = utils.getRemedyList(newMember.getName(), newMember.getPassword());

			if (map.containsKey("error")) {
				model.addAttribute("error", map.get("error"));
				return "index";
			} else if (map.containsKey("incidentList")) {
				lstIncident.add((Incident) map.get("incidentList"));
			} else {
				model.addAttribute("error", "Lista vazia!");
				return "index";
			}
			return "redirect:/";

		} else

		{
			return "index";
		}
	}

}
