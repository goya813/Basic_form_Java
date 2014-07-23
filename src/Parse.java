
public class Parse {
	
	private static Parse instance = new Parse();
	private static ReservedWord[] reservedWordsTable = new ReservedWord[20];
	
	private Parse()
	{
		instance = this;
		
		reservedWordsTable[0]  = new ReservedWord("PRINT", Define.PRINT);
		reservedWordsTable[1]  = new ReservedWord("INPUT", Define.INPUT);
		reservedWordsTable[2]  = new ReservedWord("LET", Define.LET);
		reservedWordsTable[3]  = new ReservedWord("GOTO", Define.GOTO);
		reservedWordsTable[4]  = new ReservedWord("GOSUB", Define.GOSUB);
		reservedWordsTable[5]  = new ReservedWord("RETURN", Define.RETURN);
		reservedWordsTable[6]  = new ReservedWord("IF", Define.IF);
		reservedWordsTable[7]  = new ReservedWord("THEN", Define.THEN);
		reservedWordsTable[8]  = new ReservedWord("FOR", Define.FOR);
		reservedWordsTable[9]  = new ReservedWord("TO", Define.TO);
		reservedWordsTable[10] = new ReservedWord("NEXT", Define.NEXT);
		reservedWordsTable[11] = new ReservedWord("REM", Define.REM);
		reservedWordsTable[12] = new ReservedWord("CLEAR", Define.CLEAR);
		reservedWordsTable[13] = new ReservedWord("RUN", Define.RUN);
		reservedWordsTable[14] = new ReservedWord("LIST", Define.LIST);
		reservedWordsTable[15] = new ReservedWord("SYSTEM", Define.SYSTEM);
		reservedWordsTable[16] = new ReservedWord("NEW", Define.NEW);
		reservedWordsTable[17] = new ReservedWord("CLEAR", Define.CLEAR);
		reservedWordsTable[18] = new ReservedWord("SAVE", Define.SAVE);
		reservedWordsTable[19] = new ReservedWord("LOAD", Define.LOAD);
		reservedWordsTable[20] = new ReservedWord("END", Define.END);
		reservedWordsTable[21] = new ReservedWord("", Define.UNKNOWN);
	}
	public Parse getInstance()
	{
		return (instance);
	}
	
	public void getToken(Line line, String token)
	{
		skipSpace(line);
		
		token = "";
		while (line.getChar() != ' ' && line.getChar() != '\0'){
			token += line.getChar();
			line.next();
		}
	}
	public void skipSpace(Line line)
	{
		while (line.getChar() == ' '){
			line.next();
		}
	}
	public void skipToken(Line line)
	{
		while (line.getChar() != ' ' && line.getChar() != '\0'){
			line.next();
		}
	}
	public void skipNum(Line line)
	{
		while (line.getChar() >= '0' && line.getChar() <= '9'){
			line.next();
		}
	}
	public void skipStatement(Line line)
	{
		skipSpace(line);
		skipNum(line);
		skipSpace(line);
		skipToken(line);
		skipSpace(line);
	}
	
	public int getInt(Line line, Integer num)
	{
		Line _line;
		int error;
		
		_line = new Line(line);
		error = Define.NG;
		
		skipSpace(_line);
		
		num = 0;
		while (isDigit(line.getChar())){
			num = num * 10 + (line.getChar() - '0');
			line.next();
			error = Define.OK;
		}
		
		if (error == Define.OK){
			line = new Line(_line);
		}
		
		return (error);
	}
	public boolean isLineend(Line line)
	{
		skipSpace(line);
		if (line.getChar() == '\0'){
			return (true);
		}
		
		return (false);
	}
	public int getStatement(Line line)
	{
		int index;
		
		if (line.getChar() >= '1' && line.getChar() <= '9'){
			skipToken(line);
			skipSpace(line);
		}
		
		index = 0;
		while (reservedWordsTable[index].kind != Define.UNKNOWN){
			String src = new String(reservedWordsTable[index].word);
			String dst = new String(line.getString(src.length()));
			
			if (src.equals(dst)){
				return (reservedWordsTable[index].kind);
			}
		}
		
		return (Define.UNKNOWN);
	}
	public int getLineNo(Line line)
	{
		Integer num = null;
		
		skipSpace(line);
		if (getInt(line, num) == Define.NG){
			num = -1;
		}
		
		return (num.intValue());
	}
	public int getStr(Line line, String str)
	{
		line.next();
		
		str = "";
		while (line.getChar() != '\"'){
			if (line.getChar() == '\0'){
				return (Define.ERROR_QUOTE);
			}
			str += line.getChar();
			line.next();
		}
		
		return (Define.NO_ERROR);
	}
	
	private boolean isDigit(char c)
	{
		if (c >= '0' && c <= '9'){
			return (true);
		}
		
		return (false);
	}
}
