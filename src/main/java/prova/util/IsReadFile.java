package prova.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class IsReadFile {

	private int count = 1;
	private Double total = 0.0;

	DecimalFormat df = new DecimalFormat("#.###");

	public IsReadFile() {
	}

	public IsReadFile(String nameFile) {
		isRead(nameFile);
	}

	private void isRead(String nameFile) {

		try {
			FileInputStream file = new FileInputStream("file.txt");
			InputStreamReader input = new InputStreamReader(file);
			BufferedReader br = new BufferedReader(input);

			String linha;

			List<String> lines = new ArrayList<String>();

			while ((linha = br.readLine()) != null) {
				lines.add(linha);
			}

			toSumLines(lines);

		} catch (Exception e) {
			System.out.println("Erro ao Ler o Arquivo");
		}

	}

	private void toSumLines(List<String> lines) {

		for (String s : lines) {

			String[] res = s.split("\\|");

			total = 0.0;
			for (int i = 0; i < res.length; i++) {

				if (new IsDouble().test(res[i])) {
					total += Double.valueOf(res[i]);
				}

			}

			System.out.println(" Total da Linha  " + count++ + "  é :  " + df.format(total));

		}

	}

}
