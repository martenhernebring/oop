package se.hernebring.translate;
import se.hernebring.utils.CharacterUtils;
public class AllLanguage implements Translator {

    @Override
    public String translate(String text) {
        StringBuilder sb = new StringBuilder();
        boolean isNewWord = true;
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(isNewWord && CharacterUtils.isConsonant(ch)){
                sb.append(ch);
                sb.append("all");
                isNewWord = false;
            } else {
                if(ch == ' '){
                    isNewWord = true;
                }
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
