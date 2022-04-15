public class ItemException extends Exception{
    private static int ErrorCount = 0;

    public static int errorCount(){
        return ErrorCount;
    }

    public void incCount(){
        ErrorCount++;
    }
}
