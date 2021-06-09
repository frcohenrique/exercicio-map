package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> votes = new LinkedHashMap<>();

		System.out.print("Enter file full path: ");
		String pathStr = sc.nextLine();
		try (BufferedReader br = new BufferedReader(new FileReader(pathStr))) {

			String lines = br.readLine();
			while (lines != null) {
				String[] fields = lines.split(",");

				String name = fields[0];
				int value = Integer.parseInt(fields[1]);

				if (votes.containsKey(name)) {
					int votesSoFar = votes.get(name);
					votes.put(name, value + votesSoFar);
				} else {
					votes.put(name, value);
				}

				lines = br.readLine();
			}
			for (String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));
			}

		} catch (IOException e) {
			System.out.println("Error:" + e.getMessage());
		}

		sc.close();

	}

}
