
public class Source {
	
	private static Source instance = new Source();
	public String[] source = new String[Define.MAX_LINE_NO];
	public Integer noOfLine;
	
	private Source()
	{
		instance = this;
	}
	public static Source getInstance()
	{
		return (instance);
	}
	
	public void clear()
	{
		noOfLine = 0;
	}
	
	public void show()
	{
		for (int i = 0; i < noOfLine; i++){
			Console.output_console(source[i]);
		}
	}
	
	@SuppressWarnings("null")
	public int edit(Line line)
	{
		int error;
		Line _line;
		Parse parse = Parse.getInstance();
		Integer lineNo = null;
		
		_line = new Line(line);
		
		parse.getInt(_line, lineNo);
		
		if (lineNo.intValue() <= 0 || lineNo.intValue() > Define.MAX_LINE_NUMBER){
			return (Define.ERROR_ILLEGAL_LINE_NUMBER);
		}
		
		if (parse.isLineend(line) == true){
			error = eraseLine(lineNo);
		}
		else {
			String str = "";
			while (line.getChar() == '\0'){
				str += line.getChar();
				line.next();
			}
			error = insertLine(lineNo, str);
		}
		
		return (error);
	}
	
	private int eraseLine(int lineNo)
	{
		Integer matchIndex = null;
		
		if (searchLine(lineNo, matchIndex) == Define.MATCH){
			for (@SuppressWarnings("null")
			int i = matchIndex.intValue(); i < noOfLine - 1; i++){
				source[i] = new String(source[i + 1]);
			}
			noOfLine--;
			
			return (Define.NO_ERROR);
		}
		
		return (Define.ERROR_UNDEFINED_LINE);
	}
	@SuppressWarnings("null")
	private int insertLine(int lineNo, String line)
	{
		Integer insertIndex = null;
		
		if (noOfLine >= Define.MAX_LINE_NO){
			return (Define.ERROR_MEMORY_FULL);
		}
		
		if (searchLine(lineNo, insertIndex) != Define.MATCH){
			for (int i = noOfLine; i > insertIndex; i--){
				source[i] = new String(source[i - 1]);
			}
			
			noOfLine++;
		}
		
		source[insertIndex] = new String(line);
		
		return (Define.NO_ERROR);
	}
	@SuppressWarnings("null")
	private int searchLine(int searchNo, Integer matchIndex)
	{
		Parse parse = Parse.getInstance();
		Integer lineNo = null;
		Line line;
		
		for (int i = 0; i < noOfLine; i++){
			line = new Line(source[i]);
			parse.getInt(line, lineNo);
			if (lineNo.intValue() == searchNo){
				matchIndex = i;
				return (Define.MATCH);
			}
			else if (lineNo.intValue() > searchNo){
				break;
			}
		}
		
		matchIndex = new Integer(lineNo);
		
		return (Define.UNMATCH);
	}
}
