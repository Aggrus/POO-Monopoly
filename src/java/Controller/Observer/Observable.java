package Controller.Observer;

public interface Observable {
    public void add(Observer o);
	public void remove(Observer o);
	// public int get(int var);
}