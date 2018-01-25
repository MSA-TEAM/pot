package kr.co.sicc.gsp.svm.sicc.util;

public class GMSBindingUtil {
    
    public static String[] copyStringArray(String[] array){
    	String[] ref = null;
    	if(array != null && array.length > 0){
    		ref = new String[array.length];
    		
    		System.arraycopy(array, 0, ref, 0, array.length);
    		
    	}
    	return ref;    		
    }
    
    public static void copyStringArray(String[] src, String[] target){
    	if(src != null && src.length > 0){
    		System.arraycopy(src, 0, target, 0, src.length);    		
    	}
    }

	public static int[] copyIntArray(int[] array){
		int[] ref = null;
		if(array != null && array.length > 0){
			ref = new int[array.length];
			
			System.arraycopy(array, 0, ref, 0, array.length);			
		}
        
        return ref;
    }
	
	public static void copyIntArray(int[] src, int[] target){
		if(src != null && src.length > 0){
			System.arraycopy(src, 0, target, 0, src.length);
		}
    }
}
