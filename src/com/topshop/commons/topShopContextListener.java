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
        //DI - ������ ����
        //ServletContext ������ Listener ������ ������ ��Ʈ�ѷ� ��ü�� �����Ͽ� ��ƵӴϴ�.
        //memberDao��ü��
        
    }
    
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

   
	
}
