package se.hig.aod.lab0;

/**
 * Extension of the {@link se.hig.aod.lab0.List}-interface to represent printable lists.
 * <p>
 * @author Hanna Holmgren
 * @param <T> The data type that is to be stored in the list.
 */
public interface PrintableList<T> extends List<T> {
	
	/**
	 * Converts the list to a string with format "[element1, element2, ...]". 
	 * 
	 * @return String representation of the list to be printed
	 */
	public String toStringRecursive();

	/**
	 * Converts the list to a string with format "[lastElement, secondLastelement, ...]". 
	 * 
	 * @return String representation of the list to be printed
	 */
	public String toStringReverseRecursive();

}
