import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class HelloWorldApp {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\S+");

        String textFile = null;

        if (args != null && args.length > 0)
            textFile = args[0];

        textFile = "C:\\Users\\oeila\\Documents\\What is Java and why do I need it_.html";

        System.out.println("textFile="+textFile); // Display the string.

        List<String> list = new ArrayList<String>();

        try (BufferedReader in = new BufferedReader(new FileReader(textFile))) {
            String line;

            try {
                while ((line = in.readLine()) != null) {

                    String[] strs = line.split("[ \\_\\/\\t\\.\\(\\)\\+\\<\\>\\,\\{\\}\\:\\-\\=]");

                    if (strs != null && strs.length > 0)

                        for (int i = 0; i < strs.length; i++) {

                            String str = strs[i];

                            if (str != null && str.length() > 0) {
                                Matcher matcher = pattern.matcher(str);

                                boolean matchFound = matcher.find();

                                if (matchFound)
                                    list = BinaryTree.<String>addKey(list, str);
                            }
                        }
                }
            } catch(Exception exception) {

            }

        } catch(Exception exception) {

        }

        //list = new ArrayList<String>();

        list = BinaryTree.<String>addKey(list, "banana");
        list = BinaryTree.<String>addKey(list, "apple");
        list = BinaryTree.<String>addKey(list, "peach");
        list = BinaryTree.<String>addKey(list, "orange");
        list = BinaryTree.<String>addKey(list, "apricot");
        list = BinaryTree.<String>addKey(list, "grape ");

        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i)+", ");

        System.out.println();

        String key = "ssjd";

        Boolean isFound = BinaryTree.<String>findKey(list, key);

        System.out.println("key: "+key+", isFound: "+isFound);

        key = "java";

        isFound = BinaryTree.<String>findKey(list, key);

        System.out.println("key: "+key+", isFound: "+isFound);
    }
}