package com.mosaicDs_pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MosiacDSHome {
	
	
	public By homeMenu=By.xpath("//a[@href='#/landing']");
	public By dataSourceMenu=By.xpath("//a[@href='#/dataSourceView']");
	public By flowMenu=By.xpath("//a[@href='#/appDetail']");
	public By analyticsMenu=By.xpath("//a[@href='#/notebooks']");
	public By searchMenu=By.xpath("//a[@href='#/searchIndex']");
	public By developerMenu=By.xpath("//a[@href='#/customComponent']");
	public By monitorMenu=By.xpath("//a[@href='#/taskTracker']");
	public By exploreMenu=By.xpath("//a[@href='#/hiveExplore']");
	public By marketplaceMenu=By.xpath("//a[@href='#/marketplace']");
		
	WebDriver driver;
	   
	public MosiacDSHome(WebDriver driver){
		this.driver=driver;
	}
	
	
	   
	   
	
	
}
