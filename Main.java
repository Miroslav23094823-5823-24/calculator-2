
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Main calculator = new Main();
        calculator.calculate();

    }
    void calculate() throws Exception {
        String result="";
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите значение");
        String viragenie = sc.nextLine();
        int mestoznaka = -100;
        if (viragenie.indexOf("+") != -1) {
            mestoznaka = viragenie.indexOf("+");
        }
        if (viragenie.indexOf("-") != -1) {
            mestoznaka = viragenie.indexOf("-");
        }
        if (viragenie.indexOf("*") != -1) {
            mestoznaka = viragenie.indexOf("*");
        }
        if (viragenie.indexOf("/") != -1) {
            mestoznaka = viragenie.indexOf("/");
        }
        if(mestoznaka == -100) {
            throw new Exception("Нет знака");
        }
        String perviy = viragenie.substring(0, mestoznaka);
        String vtoroi = viragenie.substring(mestoznaka + 1);
        String znak = viragenie.substring(mestoznaka, mestoznaka + 1);

        if(perviy.indexOf("\"")==-1 && vtoroi.indexOf("\"")==-1) {
            int a = Integer.parseInt(perviy);
            int b = Integer.parseInt(vtoroi);
            if(a>10||b>10)
                throw new Exception("Слишком большие числа");
            if (znak.equals("+")) {
                int c = a + b;
                result=Integer.toString(c);
            }
            if (znak.equals("-")) {
                int c = a - b;
                result=Integer.toString(c);
            }
            if (znak.equals("*")) {
                int c = a * b;

                result=Integer.toString(c);
            }
            if (znak.equals("/")) {
                int c = a / b;

                result=Integer.toString(c);
            }
        }

        if(perviy.indexOf("\"")!=-1 && vtoroi.indexOf("\"")==-1){
            int b = Integer.parseInt(vtoroi);
            if (znak.equals("*")) {
                String c="";
                for(int i=0;i<b;i++)
                    c=c+perviy.substring(1,perviy.length()-1);

                result="\""+c+"\"";
            }
            if (znak.equals("-")) {
                throw  new Exception("Нельзя вычесть число из строки");

            }
            if (znak.equals("+")) {
                throw  new Exception("Нельзя прибавить число к строке");

            }
            if (znak.equals("/")) {
                int l = perviy.length()/b;
                String c = perviy.substring(1,l);

                result="\""+c+"\"";


            }
        }
        if(perviy.indexOf("\"")!=-1 && vtoroi.indexOf("\"")!=-1)
        {
                if (znak.equals("+")){
                result = sumStrings(perviy,vtoroi);
            }
            if (znak.equals("-")){
                perviy = perviy.substring(1,perviy.length()-1);
                vtoroi = vtoroi.substring(1,vtoroi.length()-1);
                if(perviy.indexOf(vtoroi)==-1)
                    result = perviy;
                if(perviy.indexOf(vtoroi)!=-1)
                {
                    String nachalo = perviy.substring(0,perviy.indexOf(vtoroi));
                    String konec = perviy.substring(perviy.indexOf(vtoroi)+vtoroi.length());

                    result="\""+nachalo+konec+"\"";
                }

            }
            if(perviy.length()>12||vtoroi.length()>12){
                throw new Exception("Слишком много символов");
            }

        }
        outputData(result);


    }
    void  outputData(String res){
        if(res.length()>40){
            res = res.substring(0,40)+"...\"";
        }
        System.out.println(res);
    }
    String sumStrings(String perviy, String vtoroi){
        perviy = perviy.substring(1,perviy.length()-1);
        vtoroi = vtoroi.substring(1,vtoroi.length()-1);

        return "\""+perviy+vtoroi+"\"";
    }
}
