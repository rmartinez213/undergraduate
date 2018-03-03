
public class Hw7P3 {
	public static void main(String[] args) {
		String [] myNoun = {"phones", "people", "world", "computer", "art", "year", "method", "family", "system", "literature", "control", "knowledge", "software", "library", "television", "internet", "fact", "temprature", "society", "active", "television"};
		String [] myAdjectives = {"abandoned", "beneficial", "cheap", "delightful", "easy", "flithy", "gloomy", "hairy", "insignificant", "joyful", "lazy", "negative", "old-fashioned", "playful", "qualified", "reliable", "sad", "tiny", "ugly", "wealthy", "fat"};
		String [] myVerbs = {"analyze", "beg", "catch", "dictate", "expel", "forgive", "growl", "howl", "inform", "jagger", "jump", "kick", "lift", "move", "object", "preach", "poke", "recieve", "snort", "threaten", "typed"};
		String [] myPrepositions = {"aboard", "about", "above", "across", "after", "against", "along", "among", "before", "at", "as", "around", "beneath", "below", "beside", "between", "beyond", "during", "except", "excluding", "inside", "above", "within"};
		String [] myArticle = {"the", "a"};
		int generation = getGeneration();
		int generation2 = getGeneration2();
		int generation3 = getGeneration3();
		int generation4 = getGeneration4();
		for(int i = 0 ; i < 1 ; i++){
			System.out.print(myArticle[generation3] + " " + myAdjectives[generation] + 
					" " + myNoun[generation] + " " + myVerbs[generation2] +
					" " + myPrepositions[generation] + " " + myArticle[generation4] +
					" " + myAdjectives[generation2] + " " + myNoun[generation2]);
		}
	}
	
	public static int getGeneration(){
		int generationbeta = 0 + (int)(Math.random() * (20 - 0 + 1));
		return generationbeta;
	}
	public static int getGeneration2(){
		int generationbeta2 = 0 + (int)(Math.random() * (20 - 0 + 1));
		return generationbeta2;
	}
	public static int getGeneration3(){
		int generationbeta3 = 0 + (int)(Math.random() * (1 - 0 + 1));
		return generationbeta3;
	}
	public static int getGeneration4(){
		int generationbeta4 = 0 + (int)(Math.random() * (1 - 0 + 1));
		return generationbeta4;
	}
}
