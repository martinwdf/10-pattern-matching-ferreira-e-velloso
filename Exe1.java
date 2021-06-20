//Enunciado 1
public class Exe1 {
    static int count = 0;
    static int findPattern(String s1, String s2){
        int t1 = s1.length();
        int t2 = s2.length();
        int i=0;
        count++;

        while (i < t1) {
            count++;
            if(s1.charAt(i)== s2.charAt(0)){
                count++;
                int aux=i+1;
                boolean isEqual = true;
                for (int j=1; j< t2 && isEqual; j++) {
                    count++;
                    if(s1.charAt(aux) != s2.charAt(j)){
                        count++;
                        isEqual=false;
                    }
                    aux++;
                }

                if(isEqual){
                    count++;
                    System.out.println("Found Pattern at: " + i);
                    return i;
                }
            }
            i++;
            
            
            
        }
        return -1;
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
        
        String s1 = "ABCDCBDCBDACBDABDCBADF", s2 = "ADF";
        findPattern(geraString(550000, 20), geraString(500000, 20));
        System.out.println("Número de Interações: " + count);
        System.out.println("Número de instruções: " + 53);
        System.out.println("Complexidade no pior caso: O(n)");
    }
}
