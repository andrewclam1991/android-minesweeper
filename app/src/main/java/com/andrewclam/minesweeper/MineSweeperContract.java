package com.andrewclam.minesweeper;

/**
 * API that defines the View and Presenter(s)
 */
public interface MineSweeperContract {

  interface View{
    void showUserLost();
    void showUserWon();
    void notifyOnBoardChanged();
  }

  interface Presenter extends GameState{
    void setView(View view);
    void dropView();
    void initGameBoard(int size, int numBombs);
    Board getGameBoard();
    void setGameBoard(Board board);
    void setState(GameState gameState);
    GameState getLostState();
    GameState getWonState();
    GameState getPlayingState();
  }

  /**
   * API for changing Presenter's runtime behavior base on its
   * internal state for each state-affective method.
   */
  interface GameState{
    void onClick(int x, int y);
    void onFlag(int x, int y);
  }

  class Board{
    private int size;
    private int numBombs;
    private Cell[][] cells;
    private Cell[] bombs;
    private int cellsRemaining; // TODO tracks num unopened cells remaining

    Board(int size, int numBombs){
      // Initialize the board
      this.size = size;
      this.numBombs = numBombs;
      this.cells = new Cell[size][size];

      for (int i = 0; i < cells.length; i++){
        for (int j = 0; i< cells[0].length; j++){
          // add all bombs to the first row only
          cells[i][j] = new Cell(i == 0 && i < numBombs);
        }
      }

      // TODO shuffle the bombs around

      // TODO set cells to hold numeric value of nearby bombs
    }

    /**
     * Gets a particular cell
     * @param x index for col
     * @param y index for row
     * @return the particular cell at the location.
     */
    public Cell getCell(int x, int y) { return cells[x][y]; }

    /**
     * Sets a particular cell
     * @param x index for col
     * @param y index for row
     * @param cell the particular cell to set.
     */
    public void setCell(int x, int y, Cell cell) { cells[x][y] = cell; }

    /**
     * Implementation to reveal all the cells
     */
    public void revealAll(){
      for (int i = 0; i < cells.length; i++){
        for (int j = 0; i< cells[0].length; j++){
          cells[i][j].setIsHidden(false);
        }
      }
    }

    public void revealConnected(int x, int y){
      // TODO Implement connected empty spaces
    }

  }
  /**
   * API of a Cell within the grid board
   */
  class Cell{
    private boolean isHidden;
    private boolean isFlagged;
    private int numBombsNearBy;
    private final boolean isBomb;

    Cell(boolean isBomb){
      this.isHidden = true;
      this.isFlagged = false;
      this.isBomb = isBomb;
      this.numBombsNearBy = 0;
    }

    public boolean isHidden() { return isHidden; }
    public boolean isBomb() { return isBomb; }
    public boolean isFlagged() { return isFlagged; }
    public int getNumBombsNearBy() { return numBombsNearBy; }
    public void setIsHidden(boolean isHidden){ this.isHidden = isHidden; }
    public void setIsFlagged(boolean isFlagged) {this.isFlagged = isFlagged; }
  }

}
