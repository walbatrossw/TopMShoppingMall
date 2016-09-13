package com.topshop.commons;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.topshop.dao.MemberDao;

@WebListener
public class topShopContextListener implements ServletContextListener {

 
    public topShopContextListener() {
        // TODO Auto-generated constructor stub
    }
    
    public void contextInitialized(ServletContextEvent arg0)  { 
        MemberDao memberDao = new MemberDao();
        ServletContext sc = arg0.getServletContext();
        //DI - 의존성 주입
        //ServletContext 영역에 Listener 생성시 페이지 컨트롤러 객체를 생성하여 담아둡니다.
        //memberDao객체도
        
    }
    
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

   
	
}
