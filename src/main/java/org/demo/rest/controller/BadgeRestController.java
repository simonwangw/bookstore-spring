/*
 * Created on 3 avr. 2014 ( Time 19:39:49 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.demo.rest.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.demo.bean.Badge;
import org.demo.business.service.BadgeService;
import org.demo.web.listitem.BadgeListItem;

/**
 * Spring MVC controller for 'Badge' management.
 */
@Controller
public class BadgeRestController {

	@Resource
	private BadgeService badgeService;
	
	@RequestMapping( value="/items/badge",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<BadgeListItem> findAllAsListItems() {
		List<Badge> list = badgeService.findAll();
		List<BadgeListItem> items = new LinkedList<BadgeListItem>();
		for ( Badge badge : list ) {
			items.add(new BadgeListItem( badge ) );
		}
		return items;
	}
	
	@RequestMapping( value="/badge",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Badge> findAll() {
		return badgeService.findAll();
	}

	@RequestMapping( value="/badge/{badgeNumber}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Badge findOne(@PathVariable("badgeNumber") Integer badgeNumber) {
		return badgeService.findById(badgeNumber);
	}
	
	@RequestMapping( value="/badge",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Badge create(@RequestBody Badge badge) {
		return badgeService.create(badge);
	}

	@RequestMapping( value="/badge/{badgeNumber}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Badge update(@PathVariable("badgeNumber") Integer badgeNumber, @RequestBody Badge badge) {
		return badgeService.update(badge);
	}

	@RequestMapping( value="/badge/{badgeNumber}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("badgeNumber") Integer badgeNumber) {
		badgeService.delete(badgeNumber);
	}
	
}
