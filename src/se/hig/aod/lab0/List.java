package se.hig.aod.lab0;

/**
 * A Java interface for the Abstract Data Type List.
 * <p>
 * Note: A class that implements an {@code interface} will also inherit all {@code Javadoc} from the {@code interface}. 
 * 
 * @author Anders Jackson
 * @author Hanna Holmgren
 * @param <T> The data type that is to be stored in the list.
 */
public interface List<T>
{
	/**
	 * Check if the list is empty.
	 * 
	 * @return true if the list is empty, otherwise false.
	 */
	public boolean isEmpty();

	/**
	 * Clear the list of all elements stored in it.
	 */
	public void clear();

	/**
	 * Return the number of elements in the list.
	 * 
	 * @return Number of elements in the list.
	 */
	public int numberOfElements();

	/**
	 * Add an element at the first position in the list.
	 * 
	 * @param t
	 *            object to add.
	 */
	public void insertFirst(T t);

	/**
	 * Add an element at the last position in the list.
	 * 
	 * @param t
	 *            object to add.
	 */
	public void insertLast(T t);

	/**
	 * Remove the first element from the list.
	 * 
	 * @return the first element from the list.
	 * @throws ListEmptyException if the application attempts to remove a value from an
	 * empty list.
	 */
	public T removeFirst();

	/**
	 * Remove the last element from the list.
	 * 
	 * @return the last element from the list.
	 * @throws ListEmptyException if the application attempts to remove a value from an
	 * empty list.
	 */
	public T removeLast();

	/**
	 * Get the first element in the list, without removing it.
	 * 
	 * @return the first element in the list.
	 * @throws ListEmptyException if the application attempts to retrieve a value from an 
	 * empty list.
	 */
	public T getFirst();

	/**
	 * Get the last element in the list, without removing it.
	 * 
	 * @return the last element in the list.
	 * @throws ListEmptyException if the application attempts to retrieve a value from an
	 * empty list.
	 */
	public T getLast();
	

}
