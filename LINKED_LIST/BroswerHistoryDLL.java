import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    String url;
    Node back;
    Node next;
    
    Node(String url){
        this.url=url;
    }
    
    Node(String url,Node back,Node next){
        this.url=url;
        this.back=back;
        this.next=next;
    }
}

class Browser{
    
    Node currentPage;
    
    Browser(String homePage){
        currentPage=new Node(homePage);
    }
    
    void visit(String url){
        Node newPage=new Node(url);
        currentPage.next=newPage;
        newPage.back=currentPage;
        currentPage=newPage;
    }
    
    String back(int steps){
        while(steps>0){
            if(currentPage.back!=null){
                currentPage=currentPage.back;
            }else{
                break;
            }
            steps--;
        }
        
        return currentPage.url;
    }
    
    String forward(int steps){
        while(steps>0){
            if(currentPage.next!=null){
                currentPage=currentPage.next;
            }else{
                break;
            }
            steps--;
        }
        
        return currentPage.url;
    }
}

class BroswerHistoryDLL
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Browser page=new Browser("Google");
		System.out.println(page.currentPage.url);
		page.visit("Facebook");
		System.out.println(page.currentPage.url);
		page.visit("Instagarm");
		System.out.println(page.currentPage.url);
		System.out.println(page.back(3));
		page.back(1);
		page.forward(1);
		

	}
}
