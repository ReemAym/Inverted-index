package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String[] files={"doc1.txt","doc2.txt","doc3.txt","doc4.txt","doc5.txt","doc6.txt","doc7.txt","doc8.txt","doc9.txt","doc10.txt"};

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a string: ");
        String word= sc.next();
        Index ind=new Index();
        ind.buildIndex(files,word);




    }
}
