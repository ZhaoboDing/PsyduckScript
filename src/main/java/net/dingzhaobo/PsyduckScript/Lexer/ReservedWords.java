package net.dingzhaobo.PsyduckScript.Lexer;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservedWords {
    private Map<String, Token> map = new HashMap<String, Token>();

    public ReservedWords() {
        String filename = "reserved_words_map.xml";
        load(filename);
    }

    public Token getToken(String lexeme) {
        if (map.containsKey(lexeme)) {
            return map.get(lexeme);
        }
        else {
            return Token.ID;
        }
    }

    private void load(String filename) {
        try {
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
                    map.put(lexeme, Token.valueOf(token));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
