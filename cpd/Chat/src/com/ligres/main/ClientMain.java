package com.ligres.main;

import com.ligres.client.Client;

public class ClientMain {

	public static void main(String[] args) {
		Client client = new Client("Gousenfire");
		client.connect("192.168.0.101", 4222);
		client.start();
	}

}
