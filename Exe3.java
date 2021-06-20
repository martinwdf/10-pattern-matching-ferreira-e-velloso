public class Exe3 {
    static int count = 0;
    static void KMPSearch(String pat, String txt) 
	{ 
		int M = pat.length(); 
		int N = txt.length(); 

		// cria lps[] que vai guardar o maior 
		// valor prefixo sufixo para o padrão 
		int lps[] = new int[M]; 
		int j = 0; // index for pat[] 

		// Calcula lps[] 
		computeLPSArray(pat, M, lps); 

		int i = 0; // index for txt[] 
		while (i < N) { 
            count++;
			if (pat.charAt(j) == txt.charAt(i)) { 
				j++; 
				i++;
                count++; 
			} 
			if (j == M) {
                count++; 
				System.out.println("Found pattern "
								+ "at index " + (i - j)); 
				j = lps[j - 1]; 
			} 

			// mismatch após j matches 
			else if (i < N && pat.charAt(j) != txt.charAt(i)) { 
                count++;
				// Não faz match dos caracteres lps[0..lps[j-1]], 
				// não é necesssário, eles combinarão 
				if (j != 0) {
                    count++;
                    j = lps[j - 1]; 
                }
				else{
                    count++;
                    i = i + 1; 
                }
			} 
		} 
	} 
	static void computeLPSArray(String pat, int M, int lps[]) 
	{ 
		// tamanho do maior prefixo sufixo anterior 
		int len = 0; 
		int i = 1; 
		lps[0] = 0; // lps[0] is always 0 

		// loop calcula lps[i] for i = 1 to M-1 
		while (i < M) { 
            count++;
			if (pat.charAt(i) == pat.charAt(len)) { 
                count++;
				len++; 
				lps[i] = len; 
				i++; 
			} 
			else // (pat[i] != pat[len]) 
			{ 
                count++;
				if (len != 0) { 
					len = lps[len - 1];
                    count++; 
				} 
				else // if (len == 0) 
				{ 
                    count++;
					lps[i] = len; 
					i++; 
				} 
			}
        }
    }
    static String geraString(int size, int rep) {

		StringBuilder res = new StringBuilder();

		String charStr = "ABCDEFGHIJKLMOPQRSTWXYZ";

		int posCharStr = 0;

		

		if (size > 0 && rep > 0 && rep < charStr.length()) {

			for (int i = 0; i < size; i++) {

				res.append(charStr.charAt(posCharStr));

				posCharStr++;

				if (posCharStr == rep)

					posCharStr = 0;

			}

		}

		return res.toString();

	}
    public static void main(String[] args) {
        System.out.println("String: " + geraString(22, 2));
      KMPSearch(geraString(500000, 20), geraString(550000, 20));
      System.out.println("Número de Interações: " + count);
      System.out.println("Número de Instruções:" + 111);
      System.out.println("Complexidade no pior caso: O(n)");
    }
}
