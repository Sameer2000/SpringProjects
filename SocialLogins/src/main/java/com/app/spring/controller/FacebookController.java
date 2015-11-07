package com.app.spring.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.spring.enums.MessageConstants;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FacebookController {
	
	private static String ACCESS_TOKEN_URL = "https://graph.facebook.com/oauth/access_token?client_id={CLIENT_ID}&redirect_uri={REDIRECT_URL}&client_secret={CLIENT_SECRET}&code={CODE}";
	
	private static String BASE_URL = "https://graph.facebook.com/v2.5";
	
	@Value("${spring.facebook.appId}")
	private String appId;
	
	@Value("${spring.facebook.redirectUrl}")
	private String redirectUrl;
	
	@Value("${spring.facebook.appSecret}")
	private String appSecret;
	
	private static final Logger logger = LoggerFactory.getLogger(FacebookController.class);
	
	private static String ACCESS_TOKEN = "";
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		if(ACCESS_TOKEN != ""){
			return "redirect:/fb/result";
		}
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("clientId", appId);
		model.addAttribute("redirectUrl", redirectUrl);
		
		return "home";
	}
	
	@RequestMapping(value="/fb/callback", method = RequestMethod.GET)
	public ModelAndView processAccessCode(@RequestParam("code") String code) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		/**
		 * Facebook will return the code after if requested scopes are valid &
		 * accepted by user.
		 * or it can be null if something happens wrong or user not permit your app
		 * to access there data.
		 */
		if(code == null){
			mv.addObject("err", MessageConstants.SOMETHING_WENT_WRONG);
			mv.setViewName("redirect:/");
			return mv;
		}
		
		
		/**
		 * Setting Access Token Url Parameters to get access token.
		 * If parameter are valid the facebook will return the access token
		 * to get access the facebook rest api.
		 */
		ACCESS_TOKEN_URL = ACCESS_TOKEN_URL.replace("{CLIENT_ID}", appId)
											.replace("{REDIRECT_URL}", redirectUrl)
											.replace("{CLIENT_SECRET}", appSecret)
											.replace("{CODE}", code);
		URLConnection connection =  new URL(ACCESS_TOKEN_URL).openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String response;
		StringBuffer buffer = new StringBuffer();
		while((response = reader.readLine()) != null){
			buffer.append(response);
		}
		ACCESS_TOKEN = buffer.toString();
		System.out.println(ACCESS_TOKEN);
		if(ACCESS_TOKEN == ""){
			mv.addObject("err", MessageConstants.SOMETHING_WENT_WRONG);
			mv.setViewName("redirect:/");
			return mv;
		}
		mv.setViewName("redirect:/fb/result");
		return mv;
	}
	
	@RequestMapping(value="/fb/result", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getResult(){
		return new ModelAndView("redirect:"+BASE_URL+ "/me?" +ACCESS_TOKEN); 
	}
	
	@RequestMapping(value = "/fb/photos ")
	public ModelAndView getPhotos(){
		if(ACCESS_TOKEN != ""){
			return new ModelAndView("redirect:" +BASE_URL+ "/me/photos?" +ACCESS_TOKEN);
		}
		return new ModelAndView("redirect:/", "err", MessageConstants.NO_ACCESS_TOKEN);
	}
	
}
