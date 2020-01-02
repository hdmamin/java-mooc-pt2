
public class Main {

    public static void main(String[] args) {
        // write test code here
        System.out.println(isAWeekDay("mon"));
        System.out.println(isAWeekDay("monday"));
        System.out.println(allVowels("after"));
        System.out.println(allVowels("oouiea"));
        System.out.println(allVowels("iieeaataaee"));
        System.out.println(clockTime("20:00:00"));
    }
    
    public static boolean isAWeekDay(String text) {
        return text.matches("mon|tue|wed|thu|fri|sat|sun");
    }
    
    public static boolean allVowels(String text) {
        return text.matches("(a|e|i|o|u|ä|ö)*");
    }
    
    public static boolean clockTime(String text) {
        if (text.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}")) {
            String[] parts = text.split(":");
            
            for (int i=0; i<3; i++) {
                int num = Integer.parseInt(parts[i]);
                if ((i == 0 & !validHour(num)) | ((i > 0 & !validMinuteOrSecond(num)))) {
                    System.out.println(i + " " + num);
                    return false;
                }                    
            }
            
            return true;
        }
        
        return false;
    }
    
    public static boolean validHour(int num) {
        return num >= 0 & num <= 23;
    }
    
    public static boolean validMinuteOrSecond(int num) {
        return num >= 0 & num <= 59;
    }
}
