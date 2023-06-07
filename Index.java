package com.company;

import java.io.*;
import java.util.*;

public class Index {
    HashMap<String, Entry> index;

   public Index() {
        index = new HashMap<String, Entry>();
    }

    public void search(String s) {
      boolean flag=false;

        for(Map.Entry<String,Entry> pair : index.entrySet())
        {
            if (pair.getKey().equals(s)) {
                flag=true;
                System.out.println("--The term is " + pair.getKey());
                System.out.println("Total frequency of term = " + pair.getValue().term_freq);
                System.out.println("Number of document = " + pair.getValue().doc_freq);

                System.out.println("Documents are: ");

                pair.getValue().pl.display();

                System.out.println(" ");
                System.out.println("---------------------------------------------------");
            }
        }

        if(!flag){
            System.out.println("THE TERM ENTERED IS NOT FOUND");
        }
    }





    public void buildIndex(String[] files,String s) {
        for (String doc : files) {
            try {
                File file=new File(doc);
                Scanner reader = new Scanner(file);
                while(reader.hasNextLine()) {
                  //  String[] words = reader.nextLine().split("\\W+");
                    String[] words = reader.nextLine().split(" ");
                    for (String term : words) {
                        term = term.toLowerCase();
                        if (!index.containsKey(term)) {
                            index.put(term, new Entry());
                        }
                        if (!index.get(term).pl.contain(doc)) {
                            index.get(term).doc_freq += 1;
                            index.get(term).pl.add(new Node(doc,null));
                        }
                        index.get(term).term_freq += 1;
                    }
                }
            } catch (IOException e) {
                System.out.println("File " + doc + " not found. Skip it");
            }
        }
        search(s);
    }

}
