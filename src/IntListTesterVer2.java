import org.apache.commons.lang.time.StopWatch;



public class IntListTesterVer2 {

    public static void main(String[] args){

        IntListVer2 list1=new IntListVer2();
        IntListVer2 list2=new IntListVer2(100);

        for(int i=0; i<100; i+=5){
            list1.add(i);
            list2.add(i);
        }

        System.out.println("list1.equals(list2): "+list1.equals(list2));
        System.out.println("list1: "+list1);
        System.out.println("list2: "+list2);

        list2.add(200);
        System.out.println("Added 200 to list2.");
        System.out.println("list1.equals(list2): "+list1.equals(list2));
        System.out.println("list1: "+list1);
        System.out.println("list2: "+list2);

        System.out.println("Testing efficiency of StringBuffer versus using Sting");
        System.out.ptintln("Increasing list1 size to 10000.");
        StopWatch s=new StopWatch();
        list1=new IntListVer2();
        for(int i=0;i<10000;i++)
            list1.add(i);
        s.start();
        list1.toString();
        s.stop();
        System.out.println("Time to build Sting using String class: "+s.toString());
        s.start();
        list1.toStringUsingStringBuffer();
        s.stop();
        System.out.println("Time to build Sting using StringBuffer class: "+s.toString());


    }
}
