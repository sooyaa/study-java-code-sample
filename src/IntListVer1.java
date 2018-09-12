public class IntListVer1 {
    private static final int DEFAULT_CAP=10;

    private int[] iValues;
    private int iSize;

    public IntListVer1(){
        this(DEFAULT_CAP);
    }

    public IntListVer1(int initialCap){
        assert initialCap>0 : "Violation of precondition. IntListVer(int initalCap): "
                + "initalCap must be greater than 0. VAlue of initalCap: "+ initialCap;
        iValues=new int[initialCap];
        iSize=0;
    }
}
