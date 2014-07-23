
public class ReservedWord {
	public String word;
	public int kind;
	
	public ReservedWord(String _word, int _kind)
	{
		word = new String(_word);
		kind = _kind;
	}
	public ReservedWord(ReservedWord _reservedWord)
	{
		word = new String(_reservedWord.word);
		kind = _reservedWord.kind;
	}
}
