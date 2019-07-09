
public class KMP {
	
	
	public static void searchSubString(String text, String ptrn) {
		
		char [] textArr = text.toCharArray();
		char [] ptrnArr = ptrn.toCharArray();
		
        int i = 0, j = 0;
        // pattern and text lengths
        int ptrnLen = ptrn.length();
        int txtLen = text.length();
 
        // initialize new array and preprocess the pattern
        int[] b = calcPrefixTable(ptrn);
 
        while (i < txtLen) {
            while (j >= 0 && textArr[i] != ptrnArr[j]) {
                j = b[j];
            }
            i++;
            j++;
 
            // a match is found
            if (j == ptrnLen) {
                System.out.println("found substring at index:" + (i - ptrnLen));
                if (j < ptrnLen)
                j = b[j];
            }
        }
    }

	
	public static int [] calcPrefixTable (String pattern) {
		
		char [] patternArray = pattern.toCharArray();
		
		int [] result = new int [pattern.length()];
		
		result[0] = 0;
		
		int leader = 1;
		int trailer = 0;
		
		for (int i = 1; i < result.length; i++) {
			
			if (patternArray[leader] == patternArray[trailer]) {
				result[i] = ++trailer;
				leader++;
			}
			else {
				if (trailer == 0) {
					result[i] = 0;
					leader++;
				}
				else {
					while (trailer != 0) {
						trailer = result[trailer - 1];
						if (patternArray[trailer] == patternArray[leader]) {
							leader++;
							result[i] = trailer + 1;
							break;
						}
					}
					if (trailer == 0) {
						leader++;
						result[i] = 0;
					}
				}
			}
			
		}
		
		return result;
		
	}
	
	public static void printTable (int [] prefix) {
		
		for (int i : prefix) {
			System.out.print(i + " - ");
		}
		System.out.println();
	}
	
	
	public static void main (String [] args) {
		
		System.out.println("KMP.java");
		
		int [] result = calcPrefixTable("abcaby");
		
		printTable(result);
		
		int [] result2 = calcPrefixTable("acacabacacabacacac");
		
		printTable(result2);
		
		
		searchSubString ("acacabacacabacacac", "acacabacacabacacac");
		
	}
}
