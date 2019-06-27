/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import static java.util.concurrent.TimeUnit.SECONDS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Email {

 /**
  * @param args
  * @throws InterruptedException
  */
 public static void main(String[] args) throws InterruptedException, FileNotFoundException, UnsupportedEncodingException {
     int total = 0;
     PrintWriter writer = new PrintWriter("UNREAD.txt", "UTF-8");
  System.setProperty("webdriver.chrome.driver", "C:\\Gecko\\chromedriver.exe");
  ChromeDriver driver  = new ChromeDriver();
  driver.get("http://mail.google.com");
  driver.manage().timeouts().implicitlyWait(70, SECONDS);
  driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("elshugetch@gmail.com");
  driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
  driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("jesjesus");
  driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span")).click();
 Thread.sleep(5000);

//  String inbox=driver.findElement(By.xpath("//div[@class= 'bsU']")).getText();
   List<WebElement> unread_email = driver.findElements(By.xpath("//*[@class='zF']"));
      
  for (int i = 0; i < unread_email.size(); i++) {

            if (!unread_email.get(i).getText().equals("")) {

                total += 1;

                writer.println("You have an unread email from: " + unread_email.get(i).getText());
            }
        }

       
 writer.println("Total unread emails: " + total);
        writer.close();
        driver.close();

//  String unreadInboxMails=inbox.substring(inbox.indexOf("(")+1,inbox.indexOf(")"));
//  System.out.println("inbox  "+inbox);
//  System.out.println(unreadInboxMails);
//  
//  List<WebElement> mailsObj=driver.findElements(By.xpath("//*[@class='zA zE']"));
//  
//  System.out.println("total no of unread mails are==="+mailsObj.size());
//  mailsObj.get(0).click();
//  
  

 }}
