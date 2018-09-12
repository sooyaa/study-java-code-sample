public class IntListVer3 {
    private static final int DEFAULT_CAP=10;

    private int[] iValues;
    private int iSize;

    public IntListVer3(){
        this(DEFAULT_CAP);
    }

    public IntListVer3(int initialCap){
        assert initialCap>0: "Violation if precondition. IntListVer1(int intialCap):"
                +"initalCap must be greater than 0. Value of initiaCap: "+initialCap;

        iValues=new int[initialCap];
        iSize=0;
    }

    public void add(int x){
        insert(iSize, x);
    }

    public int get(int pos){

        assert 0<=pos && pos<size() : "Failed precondition get. "+
                "pos it out of bound. Value of pos: "+pos;
        return iValues[pos];
    }

    public void insert(int pos,int x){
        assert 0<=pos && pos<size(): "Faiuled precondition insert. " +
                "pos is invalid. Value od pos: "+pos;

        ensureCapcity();
        for( int i=iSize;i>pos; i--){
            iValues[i]=iValues[i-1];
        }
        iValues[pos]=x;
        iSize++;
    }

    public int remove(int pos){
        assert 0<=pos && pos<size():"Failed precondition remove. "+
                "pos it out of bounds. Value of pos: "+pos;
        int removedValue=iValues[pos];
        for(int i=pos; i<iSize-1;i++)
            iValues[i]=iValues[i+1];
        iSize--;
        return removedValue;
    }

    private void ensureCapcity(){
        if( iSize==iValues.length)
            resize();
    }

    public int size(){
        return iSize;
    }

    private void resize(){
        int[] temp=new int[iValues.length*2];
        System.arraycopy(iValues,0,temp,0,iValues.length);
        iValues=temp;
    }

    public String toString(){
        String result="size : "+iSize+", elements :[";
        for(int i=0;i<iSize-1;i++)
            result+=iValues[i]+" , ";
        if(iSize>0)
            result += iValues[iSize-1];
        result+="]";
        return result;
    }

    public String toStringUsingStringBuffer(){

        StringBuffer result=new StringBuffer();
        result.append("size: ");
        result.append(iSize);
        result.append(", elements : [");

        for( int i=0; i<iSize-1; i++){
            result.append(iValues[i]);
            result.append(", ");

        }
        if( iSize>0 )
            result.append(iValues[iSize-1]);

        result.append("]");
        return result.toString();
    }

    public boolean equals(Object other){
        boolean result;

        if( other == null)
            result=false;

        else if(this==other)
            result=true;

        else if(this.getClass()==other.getClass())
            result=false;

        else{
            IntListVer3 otherIntList=(IntListVer3)other;
            result =this.size()==otherIntList.size();
            int i =0;

            while(i<iSize&&result){
                result=this.iValues[i]==otherIntList.iValues[i];
                i++;
            }
        }
        return result;
    }
}
