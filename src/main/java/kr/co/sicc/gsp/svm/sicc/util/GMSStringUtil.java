/*
 * Copyright 2002-2004 SSangYong Information & Communications Corp.
 * All rights reserved.
 */ 

package kr.co.sicc.gsp.svm.sicc.util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ���ڿ� ���� Util �޼ҵ� ����
 * 
 * @version 1.0
 * @author Alex Park
 * @since 2005-08-10
 */
public class GMSStringUtil {
	
	
    /**
     * Null ���� üũ�Ͽ� Null Ȥ�� ""�̸� "0" String�� �ƴϸ� ���� trim�Ͽ� Return �Ѵ�.<BR>
     * ex) Space2Zero("1212") => "1212"<BR>
     *     Space2Zero(null) => "0"<BR>
     *     Space2Zero("") => "0"<BR>
     * 
     * @param val String
     * @return String
     */
    public static String Space2Zero(String val) {
        if(NullCheckS(val).equals(""))
             return "0";
        return val.trim();
    }	
    
	/**
	 * '' ���� üũ�Ͽ� ''�̸� null String�� �ƴϸ� ���� trim�Ͽ� Return �Ѵ�.<BR>
     * ex) EmptyCheckS("1212") => "1212"<BR>
     *     EmptyCheckS("") => "null"<BR>
	 * 
	 * @param val String
	 * @return String
	 */
	public static String EmptyCheckS(String val) {
		if (val == "")
			return null;
		return val.trim();
	}
	
	/**
	 * Null ���� üũ�Ͽ� Null�̸� "" String�� �ƴϸ� ���� trim�Ͽ� Return �Ѵ�.<BR>
     * ex) NullCheckS("1212") => "1212"<BR>
     *     NullCheckS(null) => ""<BR>
	 * 
	 * @param val String
	 * @return String
	 */
	public static String NullCheckS(String val) {
		if (val == null)
			return "";
		return val.trim();
	}
	/**
	 * Null ���� üũ�Ͽ� Null�̸� default String�� �ƴϸ� ���� trim�Ͽ� Return �Ѵ�.<BR>
     * ex) NullCheckS("1212", "default") => "1212"<BR>
     *     NullCheckS(null, "default") => "defalut"<BR>
	 * 
	 * @param str String
	 * @param pDefault String
	 * @return int
	 */
	public static String NullCheckS(String val, String pDefault) {
		if (val == null)
			return pDefault;
		return val.trim();
	}
    
    /**
     * Null ���� üũ�Ͽ� Null�̸� 0�� �ƴϸ� ���� parsing�Ͽ� Return �Ѵ�.<BR>
     * ex) NullCheck("1212") => 1212<BR>
     *     NullCheck(null) => 0<BR>
     * 
     * @param val String
     * @return String
     */
    public static int NullCheck(String val) {
        if (val == null)
            return 0;
        return Integer.parseInt(val);
    }
    /**
     * Null ���� üũ�Ͽ� Null�̸� default int�� �ƴϸ� ���� parsing�Ͽ� Return �Ѵ�.<BR>
     * ex) NullCheck("1212", 100) => 1212<BR>
     *     NullCheck(null, 100) => 100<BR>
     *     
     * @param str String
     * @param pDefault String
     * @return int
     */
    public static int NullCheck(String val, int pDefault) {
        if (val == null)
            return pDefault;
        return Integer.parseInt(val);
    }
    
    /**
     * ���ڿ��� '*'�� ���еǾ��ִ� ��� '*' ������ �Ѵ�. <BR>
     * ex) getLimitSize("1024*1024") => 1048576<BR>
     * 
     * @param string String
     * @return int 
     */
    public static long getLimitSize(String string) {
        List list = getToken(string, "*");  
        long size = 1;
        for(int m=0; m < list.size(); m++) {
            size *= stoi(list.get(m).toString()); 
        }    
        return size;
    }
    
    /**
     * ������ ����� Bytes, KB, MB ������ ��ȯ�Ѵ�.<BR>
     * ex) getFileSize(1)			=> 1 Bytes<BR>
     *     getFileSize(1024)		=> 1.0 KB<BR>
     *     getFileSize(1048576)		=> 1.0 MB<BR>
     *     getFileSize(1073741824)	=> 1.0 GB<BR>
     * 
     * @param filesize long
     * @return String
     */
    public static String getFileSize(long filesize) {
        DecimalFormat df = new DecimalFormat(".##"); 
        String fSize="";
        if ((filesize >= 1024) && (filesize < 1024 * 1024)) {
            fSize = df.format((float)filesize/1024).toString() + " KB" ;
        } else if ((filesize >= 1024 * 1024) && (filesize < 1024 * 1024 * 1024)) {
            fSize = df.format((float)filesize/(1024*1024)).toString() + " MB" ;
        } else if ( filesize >= 1024 * 1024 * 1024 ) { 
            fSize = df.format((float)filesize/(1024*1024*1024)).toString() + " GB" ;
        } else {
            fSize = Long.toString(filesize) + " Bytes" ;
        }
        return fSize;
    }
	
	/**
	 * String�� int������ ��ȯ�Ѵ�.
	 * @param str String
	 * @return int
	 */
	public static int stoi(String str) {
		if (NullCheckS(str).equals("")) {
			return 0;
		}
		return (Integer.valueOf(str).intValue());
	}

	/**
	 * int�� String������ ��ȯ�Ѵ�.
	 * @param i int
	 * @return String
	 */
	public static String itos(int i) {
		return (new Integer(i).toString());
	}
    
    /**
     * String�� float������ ��ȯ�Ѵ�.
     * @param str String
     * @return float
     */
    public static float stof(String str) {
        if (NullCheckS(str).equals("")) {
            return 0;
        }
        return (Float.valueOf(str).floatValue());
    }
    
    /**
     * float�� String������ ��ȯ�Ѵ�.
     * @param f float
     * @return String
     */
    public static String ftos(float f) {
        return (new Float(f).toString());
    }
    
    /**
     * String�� long������ ��ȯ�Ѵ�.
     * @param str String
     * @return long
     */
    public static long stol(String str) {
        if (NullCheckS(str).equals("")) {
            return 0L;
        }
        return (Long.valueOf(str).longValue());
    }

    /**
     * long�� String������ ��ȯ�Ѵ�.
     * @param i long
     * @return String
     */
    public static String ltos(long i) {
        return (new Long(i).toString());
    }

    


	/**
	 * �ѱ�(KSC5601)�� �����ڵ�� ��ȯ�Ѵ�.
	 * @param kscStr String
	 * @return String
	 * @throws java.io.UnsupportedEncodingException
	 */
	public static String Ksc2Uni(String kscStr)
		throws java.io.UnsupportedEncodingException {
		String str = NullCheckS(kscStr);
		if (str.equals("")) {
			return "";
		} else {
			return new String(str.getBytes("KSC5601"), "8859_1");
		}
	}

	/**
	  * �����ڵ带 �ѱ�(KSC5601)�� ��ȯ�Ѵ�.
	  * @param UnicodeStr String
	  * @return	String
	  * @throws java.io.UnsupportedEncodingException
	  */
	public static String Uni2Ksc(String UnicodeStr)
		throws UnsupportedEncodingException {
		String str = NullCheckS(UnicodeStr);
		if (str.equals("")) {
			return "";
		} else {
			return new String(str.getBytes("8859_1"), "KSC5601");
		}
	} 
    
    /**
     * �Է��� ��Ʈ���� �ݺ��Ѵ�.<BR>
     * ex) repeatString("ABC", 3) => "ABCABCABC"
     * 
	 * @param string String
	 * @param repeatCnt int
	 * @return String
	 */
	public static String repeatString(String string, int repeatCnt) {
        String s = "";
        for(int i=0;i<repeatCnt;i++){
            s = s + string;
        }
        return s;
    }
    
    
   
    
	/**
	 * ������ ���ڿ����� delim�� ���õ� ������ �����Ͽ� �����Ѵ�.<BR>
	 * ex) delString("Alex's house", 's') => "Alex' houe"
	 * 
	 * @param str String
	 * @param delim	String
	 * @return String
	 */
	public static String delString(String str, char delim) {
		// ��ó��
		str = NullCheckS(str);
		if (str.equals(""))
			return "";
        //            
		StringBuffer tempStr = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i + 1).indexOf(delim) == -1) {
				tempStr.append(str.substring(i, i + 1));
			}
		}
		return tempStr.toString();		
	}
			
	/**
	 * ������ ���ڿ����� �ο��ȣ(')�� �����Ͽ� �����Ѵ�.<BR>
	 * ex) delApos("Alex's house") => "Alexs house"
	 * 
	 * @param str String
	 * @return String
	 */
	public static String delApos(String str) {
		return delString(str, '\'');
	}
	
	/**
	 * ������ ���ڿ����� �ο��ȣ(")�� �����Ͽ� �����Ѵ�.<BR>
	 * ex) delApos("Alex's house") => "Alexs house"
	 * 
	 * @param str String
	 * @return String
	 */
	public static String delApos2(String str) {
		return delString(str, '\"');
	}	

	/**
	 * ������ ���ڿ����� delim���� ���õ� ������ �ΰ��� ����� �����Ѵ�.<BR>
	 * ex) appendString("Hello Alex!", '!') => "Hello Alex!!"
	 * 
	 * @param str
	 * @param delim
	 * @return
	 */
	public static String appendString(String str, char delim) {
		// ��ó��
		str = NullCheckS(str);
		if (str.equals(""))
			return "";
		//		
		int i = 0;
		StringBuffer tempStr = null;
		while ((i = str.indexOf(delim, i)) != -1) {
            tempStr = new StringBuffer();
			tempStr.append(str.substring(0, i) + delim + str.substring(i));
			str = tempStr.toString();
			i += 2;
		} 
		return str;		
	}
		
	/**
	 * ������ ���ڿ����� "'"��  �ΰ��� ����� �����Ѵ�.<BR>
	 * Ư�� �ؽ�Ʈ �Է��� �޾� DB�� ������ ����ϴ� �κп� �ݵ�� ����Ѵ�.(��ȸ���� �� ������ ��)<BR>
	 * ��, PreparedStatement�� QueryRunner�� ����Ҷ��� �ʿ����.<BR>
	 * 
	 * ex) appendApos("Alex's House") => "Alex''s House"
	 * 
	 * @param  str		String
	 * @param  delim	String
	 * @return 	String
	 */
	public static String appendApos(String str) {
		return appendString(str,'\'');
	}

    /**
     * ���ڿ��� Numeric������ �ٲܶ� "."�� 0~9 ���� �ٸ� ���ڰ� �ִ� ��� ���Ž�Ų�� ��ȯ�Ѵ�.<BR>
     * ex) toNumericType("+12,200,000.1212") => "12200000.1212"
     * 
     * @param value String
     * @return String
     */
    public static String toNumericType(String value) {
        String result = null;
        if(value != null && !value.trim().equals("")) {
            try {
                char[] c = new char[value.length()];
                value.getChars(0,value.length(), c, 0);
                StringBuffer sb = new StringBuffer();
                for(int i = 0 ; i < c.length ; i++) {
                    if( (int)c[i] == 46 || ( (int)c[i] > 47 && (int)c[i] < 58 ) )
                        sb.append(c[i]);
                }
                result = sb.toString();
            }catch(IndexOutOfBoundsException e){
                result = "0";
            }
        } else {
            result = "0";
        }
        return result;
    }

    /**
     * ���� ���ڿ��� ','(comma)�� pos�� ����� ��ġ�� �־� ���ڿ��� �����.<BR>
     * �������� ǥ���Ҷ� ����.<BR>
     * ex) getComma("1200000",3) => "1,200,000"
     * 
     * @param org String
     * @param pos int
     * @return String
     */
    public static String getComma(String org, int pos) {
        String result = ""; 
        String front = "";
        String rear = "";

        int len = 0; 
        int rearPos = 0;
        
        try {
            boolean flag = false;
            org = org.trim();
            
            if(org.charAt(0) == '-') {
                flag = true;
                org = org.substring(1);
            }

            if(org.indexOf(".") != -1) {
                front = org.substring(0,org.indexOf("."));
                rear = org.substring(org.indexOf("."));
            } else {
                front = org; 
            } 

            front = toNumericType(front);

            len = front.length(); 
            for(int i=len-1; i >=0;i--) {
                rearPos++;
                result = front.charAt(i) + result;
                if( (rearPos % pos) == 0 && i !=0) result = "," + result;
            }

            result += rear;

            if(flag)
                result = '-' + result;
        } catch(IndexOutOfBoundsException e) {
            result = org;
        }

        return result;
    }

	/**
	 * �Ϲ� ���ڿ��� HTML���ڿ��� ��ȯ�Ѵ�.<BR>
	 * �ҽ��ڵ尰�� ���� HTML���� �����ٶ� �����ϰ� ���.<BR>
	 * ex) htmlEscape("<html>") => &lt;html&gt;
	 * @param str String
	 * @return String
	 */
	public static String htmlEscape(String str) {
		//	��ó��
		str = NullCheckS(str);
		if (str == null || str.length() <= 0) {
			return "";
		}
		int len = str.length();
		StringBuffer sb=new StringBuffer(len);
		for( int i = 0; i < len; i++ ) {
			char c = str.charAt(i);
			if ( c == '&' ) { 
				sb.append("&amp;");
			} else if (c == '"') { 
				sb.append("&quot;");
			} else if ( c == '<' ) {
				sb.append("&lt;");
			} else if ( c == '>' ) { 
				sb.append("&gt;");
			} else if ( c == '\'' ) {
				sb.append("&#39;");
            } else if ( c == '\n' ) {
                sb.append("<BR>"); 
            } else if ( c == ' ' ) {
                sb.append("&nbsp;");                                                  
			} else {
				sb.append(c);
			} 
		}
		return sb.toString();
	}

	/**
	 * �Ķ���ͷ� �Ѿ�� ���� ������.<BR>
	 * @param str String
	 * @return String
	 */
	public static String paramFilter(String str) {
		if (str != null) {
			str = str.replaceAll("<", "&lt;");
			str = str.replaceAll(">", "&gt;");
			/*str = str.replaceAll("&", "&#38;");
			str = str.replaceAll(")", "&#41;");
			str = str.replaceAll("(", "&#40;");
			str = str.replaceAll("#", "&#35;");
			str = str.replaceAll("\"", "&quot;");
			str = str.replaceAll("/", "&#x2F;");
			str = str.replaceAll("'", "&#x27;");*/
		}
		return str;
	}
	
	/**
     * �Է� �ڷῡ ����(%s)�� �ڷḦ ������� �ִ´�. 
     * 
	 * @param pattern String
	 * @param arguments String[]
	 * @return String
	 */
    public static String sprintf(String pattern, String[] arguments) {
         StringBuffer buf = new StringBuffer();
         int iArgIndex = 0;  // �߰��ϴ� ���ڿ�
         int iFront = 0;  // �˻�������ġ
         int k = -1; // �˻���ġ
         while(( k = pattern.indexOf( "%s", iFront)) >= 0) { // $s�� �����ϸ�
             buf.append(pattern.substring(iFront, k)).append(NullCheckS(arguments[iArgIndex++]));
             iFront = k + 2;
         }
         if ( iFront < pattern.length() ) { //ī�Ǿȵ� ����Ÿ�� ���� ������
             buf.append(pattern.substring(iFront));
         }
         return buf.toString();
    }
    
    /**
     * �Է� �ڷῡ ����(%s)�� �ڷḦ �ִ´�.  
     * 
	 * @param pattern String
	 * @param arguments String
	 * @return String
	 */
    public static String sprintf(String pattern, String arguments) {
         StringBuffer buf = new StringBuffer();
         int iFront = 0; // �˻�������ġ
         int k = -1; // �˻���ġ
         while(( k = pattern.indexOf( "%s", iFront)) >= 0) { // $s�� �����ϸ�
             buf.append(pattern.substring(iFront, k)).append(NullCheckS(arguments));
             iFront = k + 2;
         }
         if ( iFront < pattern.length() ) { //ī�Ǿȵ� ����Ÿ�� ���� ������
             buf.append(pattern.substring(iFront));
         }
         return buf.toString();
    }
        
    /**
     * ���ڿ��� �и� �Ͽ� ��ū���� ������ ���ϴ� ��ġ�� ���� �����´�.<BR>
     * ex) getToken("AA,BB,CC" , ",", 2) => "BB"
     * 
	 * @param pValue String
	 * @param pGubun String
	 * @param pos int
	 * @return String
	 */
    public static String getToken(String pValue , String pGubun, int pos) {
        // ��ó��
        pValue = NullCheckS(pValue);
        if (pValue.equals(""))
            return "";
        //                                
        int i = 0;
        int j = 0;
        int count = 0;
        String string = "";
        while ((i = pValue.indexOf(pGubun, j)) != -1) {
            string = pValue.substring(j, i);
            count ++;
            j = i+1;
            // Loop ����
            if (pos==count) {
                break;
            } else {
                string = pValue.substring(j, pValue.length());
            }                                                     
        } 
        return string;
    }  
    
    /**
     * ��Ʈ�� �迭�� ��ū���� �����Ͽ� �ϳ��� ���ڿ��� ��ȯ�Ѵ�.<BR>
     * ex) toTokenFromString({"AA","BB","CC"} , ",") => "AA,BB,CC"
     * 
     * @param pValue String
     * @param pGubun String
     * @param pos int
     * @return String
     */
    public static String toTokenFromString(String[] pValue , String pGubun) {
        // ��ó��
        if (pValue == null || pValue.length == 0) {
            return "";
        }
        if (pGubun == null || pGubun.trim().equals("")) {
            return null;
        }
        //                                
        StringBuffer string = new StringBuffer();
        for (int i = 0; i < pValue.length; i++) {
            string.append(pValue[i] + pGubun);
        }
        return string.substring(0, string.length()-pGubun.length());
    }  
    
    /**
     * List�� ��ū���� �����Ͽ� �ϳ��� ���ڿ��� ��ȯ�Ѵ�.<BR>
     * ex) toTokenFromList(list, ",") => "AA,BB,CC"<BR>
     * getToken()�� �ݴ�
     * 
     * @param pValue String
     * @param pGubun String
     * @param pos int
     * @return String
     */
    public static String toTokenFromList(List pValue , String pGubun) {
        // ��ó��
        if (pValue == null || pValue.size() == 0) {
            return "";
        }
        if (pGubun == null || pGubun.trim().equals("")) {
            return null;
        }
        //                                
        StringBuffer string = new StringBuffer();
        for (int i = 0; i < pValue.size(); i++) {
            string.append(pValue.get(i) + pGubun);
        }
        return string.substring(0, string.length()-pGubun.length());
    }  
    
    /**
     * Map�� ����ִ� List�� ��ū���� �����Ͽ� �ϳ��� ���ڿ��� ��ȯ�Ѵ�.<BR>
     * ex) toTokenFromMapList(list, "CODE", ",") => "AA,BB,CC"
     * 
     * @param pValue String
     * @param pGubun String
     * @param pos int
     * @return String
     */
    public static String toTokenFromMapList(List pValue, String mapKey, String pGubun) {
        // ��ó��
        if (pValue == null || pValue.size() == 0) {
            return "";
        }
        if (mapKey == null || mapKey.trim().equals("")) {
            return "";
        }
        if (pGubun == null || pGubun.trim().equals("")) {
            return null;
        }
        //                                
        StringBuffer string = new StringBuffer();
        for (int i = 0; i < pValue.size(); i++) {
            
            string.append(((Map)pValue.get(i)).get(mapKey) + pGubun);
        }
        return string.substring(0, string.length()-pGubun.length());
    }  
    
    
    
    /**
     * ���ڿ��� �и� �Ͽ� ��ū���� ������ ���ͷ� ������ �Ѵ�.<BR>
     * ex) getToken("AA,BB,CC" , ",") => AA BB CC�� List�� ��Ƽ� ��ȯ
     * 
     * @param pValue String
     * @param pGubun String
     * @return List
     */
    public static List getToken(String pValue , String pGubun) {
        List list = new ArrayList();
        // ��ó��
        pValue = NullCheckS(pValue);
        if (pValue.equals(""))
            return list;
        //                            
        int i = 0;
        int j = 0;
        String string = "";
        while ((i = pValue.indexOf(pGubun, j)) != -1) {
            //
            string = pValue.substring(j, i);
            list.add(string);
            //
            j = i+1;
        } 
        // �������� �߰��Է�
        string = pValue.substring(j, pValue.length());
        list.add(string);
        return list;
    }
    
    /**
     * �Էº����� ���Ͽ� ü��� �۾��� �Ѵ�.<BR>
     * ex) getFillString("12","0000") => "0012"
     * 
     * @param fillString String
     * @param filler String
     * @return String
     */
    public static String getFillString(String fillString, String filler) {
        // �������� ������ ��Ʈ�� ��
        int cutLength = fillString.length();
        int fillLength = filler.length();
        // ü��� ������ ���̰� �Էº����� ���� ���� ª�� ��� 
        // ü��� �۾��� �����ʰ� �Էº����� �����ش�.
        if (cutLength <= fillLength) {
            fillString = filler + fillString;
            fillString = fillString.substring(cutLength, fillString.length());
        }                            
        return fillString;     
    }
    

         
    /**
     * ���ڿ��� ���ϴ� Ư�����ڿ� Ȥ�� ���ڸ� Ư�����ڿ� Ȥ�� ���ڷ� ��ġ�Ѵ�.<BR>
     * ( JDK 1.4 ���ʹ� ���� )
     * @param org �ٲٰ��� �ϴ� ���ڿ�
     * @param srch ã�� ���ڿ�
     * @param replace ��ġ�� ���ڿ�
     * @return ��ġ�� ���ڿ��� ��ȯ�Ѵ�.
     */
    public static String replace(String string, String oldString, String newString) {
        if (string == null) {
            return "";
        }
        if (oldString == null || oldString.length() <= 0) {
            return string;
        }
        if (newString == null) {
            newString = "";
        }
        // ������ ������ ������ return
        if(string == null || oldString == null)
            return "";
        //
        String result = "";
        int i = 0;
        // Loop ��ȯ
        do {
            i = string.indexOf(oldString);
            if(i != -1) {
                result += string.substring(0, i);
                result += newString;
                string = string.substring(i + oldString.length());
            } else {
                result += string;
                break;
            }
        } while(i != -1);
        // return
        return result;
    }
    
    /**
     * ������ �����ŭ ���ڿ��� �ڸ��� "..."�� �ڿ� �ٿ� �����Ѵ�.<BR>
     * �ַ� ��¹��̳� �Խ��ǿ��� �ʹ� �� ���ڿ��� �ڸ��� ����Ѵ�.<BR>
     * ex) zzumzzumString("Hello HiHi oh yea~", 10) => "Hello HiHi..."
     * 
     * @param  currStr      String (��ȯ�� ���ڿ�)
     * @return String
     * @auth   sharki        2003.07.02
     */ 
    public static String zzumzzumString(String currStr, int size){
        if (currStr==null) return "";
        if (size == 0) return "";
        
        currStr = currStr.trim();
        
        if (currStr.length() <= size)
            return currStr;
        else 
            return currStr.substring(0, size) + "...";
    }
}