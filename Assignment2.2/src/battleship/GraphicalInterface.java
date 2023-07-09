package battleship;
/**
 * The GraphicalInterface interface defines the methods that a graphical interface for the Battleship game should implement.
 */
public interface GraphicalInterface {
	/**
     * Called when the computer selects a position on the game board.
     *
     * @param x The x-coordinate of the selected position.
     * @param y The y-coordinate of the selected position.
     */
	void selectComputer(int x,int y);
	/**
     * Called when the player selects a position on the game board.
     *
     * @param x The x-coordinate of the selected position.
     * @param y The y-coordinate of the selected position.
     */
	void selectPlayer(int x, int y);
	/**
     * Redraws the player's game board.
     */
	void drawPlayerBoard();
	/**
     * Called when all ships have been placed on the game board.
     * This indicates that the player is ready to start playing.
     */
	void allShipsPlaced();


}
