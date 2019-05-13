package com.lxisoft.sample;

import com.lxisoft.service.CustomerService;
import com.lxisoft.service.CustomerService1;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        CustomerService1 cs = new CustomerService();
    	System.out.println( cs.findAll().get(0).getfName() );
    }
}
