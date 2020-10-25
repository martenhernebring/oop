package se.hernebring.translate;
import se.hernebring.utils.CharacterUtils;
public class RobbersLanguage implements Translator {

    @Override
    public String translate(String text) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(CharacterUtils.isConsonant(ch)){
                sb.append(ch);
                sb.append('o');
                sb.append(ch);
            } else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
}
