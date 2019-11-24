public class ReplaceString {
    public static void main(String[] args) {
        String testString = "I never heard of “Uglification,”’ Alice ventured to say. ‘What is it?’";
        String[] wordList = testString.split("\\s");

        for (String eachWord : wordList) {
            System.out.println(eachWord);
            System.out.println(eachWord.replaceAll("\\p{Punct}", "").toLowerCase());
        }


    }
}
