package pkg1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MailMerge1 {
	public static void mailmerge1(String fname1, String fname2) throws IOException{
		String part1 = fname1.split("\\.")[0];
		File f1 = new File(fname2);
		File f2 = new File(fname1);
		FileWriter fw1 = new FileWriter(part1+"_out.txt");
		Scanner sc1 = new Scanner(f1); //template1.txt
		Scanner sc2 = new Scanner(f2); //names1.txt
		String template1 = sc1.nextLine();

		
		while(sc2.hasNextLine()) {
			String[] arr1 = sc2.nextLine().split(",");
			String out1 = template1
			.replace("$1", arr1[0])
			.replace("$2", arr1[1])
			.replace("$3", arr1[2]);
			String temp1 = out1+"\n";
			fw1.write(temp1);			
		}
		
		sc1.close();
		sc2.close();
		fw1.close();
	}
	public static void main(String[] args) throws IOException {
		mailmerge1("names1.txt", "template1.txt");
	}
}
