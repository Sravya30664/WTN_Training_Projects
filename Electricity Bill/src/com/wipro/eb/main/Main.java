package com.wipro.eb.main;

import com.wipro.eb.service.ConnectionService;

public class Main {
	public static void main(String a[]) {
System.out.println(new ConnectionService().generateBill(130,100,"domestic"));
System.out.println(new ConnectionService().generateBill(120,140,"commercial"));
System.out.println(new ConnectionService().generateBill(180,100,"commercial"));
System.out.println(new ConnectionService().generateBill(190,100,"domestic"));
}
}
