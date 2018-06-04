package com.andrewclam.minesweeper;

public class PlayingState implements MineSweeperContract.GameState {
  private MineSweeperContract.Presenter mContext;

  PlayingState(MineSweeperContract.Presenter context){
    mContext = context;
  }

  @Override
  public void onClick(int x, int y) {
    MineSweeperContract.Board board = mContext.getGameBoard();
    MineSweeperContract.Cell cell = board.getCell(x,y);
    if(cell.isBomb()){
      // oops, kaboom!!!
      board.revealAll();
      mContext.setState(mContext.getLostState());
    }else{
      // still in game, okay
      board.revealConnected(x, y);
      mContext.setState(mContext.getPlayingState());

      // TODO check if all empty cells are revealed
      mContext.setState(mContext.getWonState());
    }
    // update game board
    mContext.setGameBoard(board);
  }

  @Override
  public void onFlag(int x, int y) {
    MineSweeperContract.Board board = mContext.getGameBoard();
    MineSweeperContract.Cell cell = board.getCell(x,y);
    cell.setIsFlagged(true);
    board.setCell(x,y,cell);
    // update game board
    mContext.setGameBoard(board);
  }
}
