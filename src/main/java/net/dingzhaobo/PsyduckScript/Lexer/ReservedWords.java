package net.dingzhaobo.PsyduckScript.Lexer;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservedWords {
    private Map<String, String> map = new HashMap<String, String>();

    public ReservedWords() {
        try {
            String filename = "reserved_words_map.xml";
            InputStream is = ClassLoader.getSystemResourceAsStream(filename);

            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(is);
            Element root = document.getRootElement();
            List<Element> wordList = root.getChildren("word");

            for (Element word : wordList) {
                String lexeme = word.getChildTextTrim("lexeme");
                String token = word.getChildTextTrim("token");
                if (map.containsKey(lexeme)) {
                    throw new Exception("Duplicated lexeme");
                }
                else {
                    map.put(lexeme, token);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isLexemeReserved(String lexeme) {
        return map.containsKey(lexeme);
    }

    public String getToken(String lexeme) {
        if (map.containsKey(lexeme)) {
            return map.get(lexeme);
        }
        else {
            return lexeme;
        }
    }
}
