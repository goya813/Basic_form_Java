
public class Line {
	public String line;
	public int index;
	
	public Line(String _line)
	{
		line  = new String(_line);
		index = 0;
	}
	public Line(Line _line)
	{
		line  = new String(_line.line);
		index = _line.index;
	}
}
