public class RetValTest {
    private static class NoEmailException extends RuntimeException {

    }
    public static String extractCamEmail(String sentence) {
        if (sentence==null || sentence.length()==0)
            throw new IllegalArgumentException();
        String[] tokens = sentence.split(" "); // split into tokens
        for (String token : tokens) {
            if (token.endsWith("@cam.ac.uk")) {
                return token;
            }
        }
        throw new NoEmailException();
    }
    public static void main(String[] args) {
        try {
            String sEmail = RetValTest.extractCamEmail("My email is rkh23@cam.ac.uk");
            System.out.println("Success: " + sEmail);
        } catch (IllegalArgumentException e) {
            System.out.println("Supplied string empty");
        } catch (NoEmailException e) {
            System.out.println("No @cam address in supplied string");
        }
    }
}