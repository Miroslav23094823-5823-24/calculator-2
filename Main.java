import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(
                System.in
        );
        System.out.println("Введите значение");
        String viragenie = sc.next
                        ();
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
                System.out.println(c);
            }
            if (znak.equals("-")) {
                int c = a - b;
                System.out.println(c);
            }
            if (znak.equals("*")) {
                int c = a * b;
                System.out.println(c);
            }
            if (znak.equals("/")) {
                int c = a / b;
                System.out.println(c);
            }
        }

        if(perviy.indexOf("\"")!=-1 && vtoroi.indexOf("\"")==-1){
            int b = Integer.parseInt(vtoroi);
            if (znak.equals("*")) {
                String c="";
                for(int i=0;i<b;i++)
                    c=c+perviy.substring(1,perviy.length()-1);
                System.out.println("\""+c+"\"");
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
                System.out.println("\""+c+"\"");

            }
        }
        if(perviy.indexOf("\"")!=-1 && vtoroi.indexOf("\"")!=-1)
        {
            if (znak.equals("+")){
                perviy = perviy.substring(1,perviy.length()-1);
                vtoroi = vtoroi.substring(1,vtoroi.length()-1);
                System.out.println("\""+perviy+vtoroi+"\"");
            }
            if (znak.equals("-")){
                perviy = perviy.substring(1,perviy.length()-1);
                vtoroi = vtoroi.substring(1,vtoroi.length()-1);
                if(perviy.indexOf(vtoroi)==-1)
                    System.out.println(perviy);
                if(perviy.indexOf(vtoroi)!=-1)
                {
                    String nachalo = perviy.substring(0,perviy.indexOf(vtoroi));
                    String konec = perviy.substring(perviy.indexOf(vtoroi)+vtoroi.length());
                    System.out.println("\""+nachalo+konec+"\"");
                }

            }
        }


    }
}