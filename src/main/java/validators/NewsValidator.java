package validators;

public class NewsValidator {

    public static boolean isCorrect(String header, String content, String image, String type) {
        return header != null && !header.equals("") &&
                content != null && !content.equals("") &&
                image != null && !image.equals("") &&
                type != null && !type.equals("");
    }
}
