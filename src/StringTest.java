public class StringTest {

    public static void main(String[] args) {

        System.out.println(new StringTest().getString("AB"));


    }

    private String getString(String string){
        String changeString="";

        if(string.length()==1){
            if(string.contains("A")){
                changeString ="B1";
            }
            if(string.contains("B")){
                changeString ="B2";
            }
            if(string.contains("C")){
                changeString ="B3";
            }
        }

        if(string.length()==2){
            String str1 ="";
            String str2="";
            if(string.substring(0,1).contains("A")){
                str1 ="B1";
            }
            if(string.substring(0,1).contains("B")){
                str1 ="B2";
            }
            if(string.substring(0,1).contains("C")){
                str1 ="B3";
            }
            if(string.substring(1,2).contains("A")){
                str2 ="B1";
            }
            if(string.substring(1,2).contains("B")){
                str2 ="B2";
            }
            if(string.substring(1,2).contains("C")){
                str2 ="B3";
            }
            changeString = str1+","+str2;
        }
        return changeString;
    }
}
