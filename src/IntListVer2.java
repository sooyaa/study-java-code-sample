public class IntListVer2 {

    private static final int DEFAULT_CAP=10;

    private int[] iValues;
    private int iSize;

    public void add(int x){

        if(iSize==iValues.length)
            resize();

        assert 0<=iSize && iSize< iValues.length;
        iValues[iSize]=x;
        iSize++;
    }

    private void resize(){
        int[] temp=new int[iValues.length*2];
        System.arraycopy(iValues,0,temp,0,iValues.length);
        iValues=temp;
    }

    public String toString(){
        String result="size: "+iSize +", elements: [";
        for( int i=0; i<iSize-1; i++)
            result +=iValues[i]+" , ";

        if( iSize>0 )
            result+=iValues[iSize-1];

        result +="]";
        return result;
    }

    public String toStringUsingStringBuffer(){
        StringBuffer result=new StringBuffer();

        result.append("size: ");
        result.append(iSize);
        result.append(", elements: [");

        for( int i=0; i<iSize-1; i++){
            result.append(iValues[i]);
            result.append(", ");
        }
        if(iSize>0)
            result.append(iValues[iSize-1]);

        result.append("]");
        return result.toString();
    }

    public IntListVer2(){
        this(DEFAULT_CAP);
    }

    public IntListVer2(int initialCap){
        assert initialCap>0:"Violation if precondtion. IntListVer1(int initalCap):"
                +"initialCap must be greater than 0, VAlue of initalCap: "+initialCap;
        iValues=new int[initialCap];
        iSize=0;
    }

    public boolean equals(Object other){
        boolean result;
        if(other==null)
            result=false;

        else if(this==other)
            result=true;

        else if(this.getClass()!=other.getClass())
            result=false;

        else{
            IntListVer2 otherIntList=(IntListVer2)other;
            result=this.iSize==otherIntList.iSize;
            int i=0;
            while(i<iSize && result){
                result=this.iValues[i]==otherIntList.iValues[i];
                i++;
            }
        }
        return result;
    }
}
