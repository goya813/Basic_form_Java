
public class Line {
	private String str;
	private int index;
	
	public Line(String _str)
	{
		str  = new String(_str);
		index = 0;
	}
	public Line(Line _line)
	{
		str   = new String(_line.str);
		index = _line.index;
	}
	
	public void next()
	{
		if (index < str.length()){
			index++;
		}
	}
	public char getChar()
	{
		if (str.length() == index){
			return ('\0');
		}
		
		return (str.charAt(index));
	}
}
