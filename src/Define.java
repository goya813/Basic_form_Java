
public class Define {
	public static int ON 	= 1;
	public static int OFF	= 0;
	
	public static int OK	= 1;
	public static int NG	= 0;

	public static int MATCH	= 1;
	public static int UNMATCH	= 0;
	
	public static int SUCCESS	= 1;
	public static int FAIL		= 0;
	
	public static int OVERFLOW  = -1;
	public static int UNDERFLOW = -2;
	
	public static int UNKNOWN	  = 0;
	public static int PRINT	  = -1;
	public static int INPUT	  = -2;
	public static int LET		  = -3;
	public static int GOTO		  = -4;
	public static int GOSUB	  = -5;
	public static int RETURN	  = -6;
	public static int IF		  = -7;
	public static int THEN		  = -8;
	public static int FOR		  = -9;
	public static int TO		  = -10;
	public static int NEXT		  = -11;
	public static int REM	  	  = -12;
	public static int CLEAR	  = -13;
	public static int RUN		  = -14;
	public static int LIST		  = -15;
	public static int SYSTEM	  = -16;
	public static int NEW		  = -17;
	public static int SAVE		  = -18;
	public static int LOAD		  = -19;
	public static int END		  = -20;
	
	public static int EQUAL	   	= 1;
	public static int LESS		   	= 2;
	public static int GREATER	   	= 3;
	public static int LESS_EQ	   	= 4;
	public static int GREATER_EQ	= 5;
	public static int NOT			= 6;
	
	public static int MAX_LINE_LEN		= 256;
	public static int MAX_LINE_NO		= 100;
	public static int MAX_TOKEN_LEN	= 256;
	public static int MAX_PRINT_BUF	= 256;
	public static int MAX_INPUT_BUF	= 256;
	public static int MAX_FILENAME_LEN	= 100;
	
	public static int MODE_DIRECT	= 0;
	public static int MODE_PROGRAM	= 1;
	public static int MODE_IF		= 2;
	
	public static int MAX_GOSUB_STACK		= 8;
	public static int MAX_FOR_STACK		= 8;
	public static int MAX_EXPRESSION_STACK	= 16;
	public static int MAX_LINE_NUMBER		= 9999;
	
	public static int NO_ERROR						= 0;
	public static int ERROR_SYNTAX					= -1;
	public static int ERROR_UNDEFINED				= -2;
	public static int ERROR_MEMORY_FULL			= -3;
	public static int ERROR_FUNCTION_REVSERVED		= -4;
	public static int ERROR_UNDEFINED_LINE			= -5;
	public static int ERROR_ILLEGAL_LINE_NUMBER	= -6;
	public static int ERROR_QUOTE					= -7;
	public static int ERROR_TOO_MANY_GOSUB			= -8;
	public static int ERROR_WITHOUT_RETURN			= -9;
	public static int ERROR_WITHOUT_GOSUB			= -10;
	public static int ERROR_EXPRESSION				= -11;
	public static int ERROR_DIV0					= -12;
	public static int ERROR_PARENTHESIS			= -13;
	public static int ERROR_TOO_MANY_FOR			= -14;
	public static int ERROR_WITHOUT_NEXT			= -15;
	public static int ERROR_WITHOUT_FOR			= -16;
	public static int ERROR_MODE					= -17;
	public static int ERROR_FILE_OPEN				= -18;
	public static int ERROR_FILE_NOTFOUND			= -19;
	public static int ERROR_FILE_FORMAT			= -20;
	public static int ERROR_DISK_FULL				= -21;
	
}
