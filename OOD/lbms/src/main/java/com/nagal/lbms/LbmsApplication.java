package com.nagal.lbms;

import com.nagal.lbms.model.Book;
import com.nagal.lbms.model.BookItem;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class LbmsApplication {

	public static void main(String[] args) {


		Book GOT=new Book("GOT","Game Of thrones",new ArrayList<>(Arrays.asList("GG MARTIN","Ronak Sarkar")),new ArrayList<>(Arrays.asList("PENGUIN")));
		Book LOR=new Book("LOR","Lord of the Rings",new ArrayList<>(Arrays.asList("Dwarfs","Giants")),new ArrayList<>(Arrays.asList("WIZARD")));
		BookItem GOT1=new BookItem("GOT1",GOT);



	}
}
