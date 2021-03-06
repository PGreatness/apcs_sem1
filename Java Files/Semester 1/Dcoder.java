public class Dcoder{

    private static final String VOWELS = "aeiou";

    public static boolean hasA (String w,String letter) {
	if ((w != null) && (letter.length() == 1)) {
	    int index = 0;
	    while (index < w.length()) {
		if (w.substring(index,index + 1).equals(letter)) {
		    return true;
		}
		else {
		    index += 1;
		}
	    }
	    return false;
	}
	else {
	    return false;
	}
    } // end hasA

    public static boolean isAVowel (String letter) {
	for (int index = 0; index < VOWELS.length(); index += 1) { // iterates through the array of vowels
	    if (hasA(letter,VOWELS.substring(index,index + 1))) { // if the letter is equal to one of the vowels
		return true; // then return true
	    }
	}
	return false; // if not, return false
    } // end isAVowel()

    public static int countVowels (String w) {
	if (w == "") { // if w is a null string
	    return -1; // then return -1
	}
	else {
	    int count = 0;
	    for (int index = 0; index < w.length(); index += 1) { // iterate through w
		if (isAVowel(w.substring(index,index + 1))) { // call the isAVowell method to save time. If the letter being in question is a vowel
		    count += 1; // then add one to the vowel counter
		}
	    }
	    return count;
	}
    } // end countVowels()

    public static boolean hasAVowel (String w) {
	return countVowels(w) > 0;
    } // end hasAVowel()

    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels (String w) {
	if (countVowels(w) == -1) { // if w is a null string
	    return "ERROR"; // then return "ERROR"
	}
	else if (countVowels(w) == 0) { // if w has no vowels
	    return "none"; // then return "none"
	}
	else {
	    String vowels = "";
	    for (int index = 0; index < w.length(); index += 1) { // iterate through w
		if (isAVowel(w.substring(index,index + 1))) { // if the letter in question is a vowel 
		    vowels += w.substring(index,index + 1); // then append concatinate it to vowels (string to be returned at the end of iteration)
		}
	    }
	    return vowels;
	}
    } // end allVowels()

    public static String firstVowel (String w) {
	for (int index = 0; index < w.length(); index += 1) { // iterates through w
	    if (isAVowel(w.substring(index,index + 1))) { // if a letter in question is identified as a vowel
		return w.substring(index,index + 1); // return the letter
	    }
	}
	return "none"; // if w has no vowels, return "none"
    } // end firstVowel()

    public static boolean beginsWithVowel (String w) {
	return isAVowel(w.substring(0,1));
    } // end beginsWithVowel()
    
    public static boolean haveCap(String W) {
	for (int x = W.length(); x > 0; x--) {
	    if (W.substring(0,1).equals(W.substring(0,1).toUpperCase())) {
		return true;
	    }else{
		W =  W.substring(1, W.length());
	    }
	}
	return false;
    }

    public static String engToPig(String w) {
	//special cases:',-,y
	if (hasA(w,"'")) {
	    return engToPig(w.substring(0,w.indexOf("'"))) + "'" + engToPig(w.substring(w.indexOf("'") + 1));
	}
	else if (hasA(w,"-")) {
	    return engToPig(w.substring(0,w.indexOf("-")))+ "-" +engToPig(w.substring(w.indexOf("-") + 1));
	} //Get rid of substring of -1 for y
	else if (w.indexOf("y") == 0) /* || w.indexOf("y") == -1) */{
	    return w.substring(w.indexOf("y")) + w.substring(0,w.indexOf("y")) + "ay";
	} 
	//all other cases
	else {
	    if (beginsWithVowel(w)) {
		return w + "way";
	    }else{
		if (w.indexOf(firstVowel(w)) != -1) {
		    if (haveCap(w)) {
			int x = (int) w.indexOf(firstVowel(w));
			return (w.substring(x, x + 1).toUpperCase() + w.substring(x + 1, w.length()) + w.substring(0,x).toLowerCase() + "ay");
		    }else{
			int x = (int) w.indexOf(firstVowel(w));
			return (w.substring(x, x + 1) + w.substring(x + 1, w.length()) + w.substring(0,x) + "ay");
		    }
		}else{
		    return w;
		}
	    }
	}
    } 

    public static void main (String [] args) {
	System.out.println("-----engToPig Tests-----");
	System.out.println(engToPig("Grapple"));
	System.out.println(engToPig("pRotractor"));
	System.out.println(engToPig("none"));
	System.out.println(engToPig("apple")); // return appleway
	System.out.println(engToPig("strong")); // return ongstray
	System.out.println(engToPig("java")); // return avajay
	System.out.println(engToPig("Hello")); // return elloHay
	System.out.println(engToPig("every-one")); // return every-oneway
	System.out.println(engToPig("of")); // return ofway
	System.out.println(engToPig("you")); // return ouyay
	System.out.println(engToPig("wasn't"));
    } // end main()
} // end class Pig
