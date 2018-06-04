package com.andrewclam.minesweeper;

class PresenterImpl implements MineSweeperContract.Presenter {
  private MineSweeperContract.View mView;
  private MineSweeperContract.GameState mState;
  private MineSweeperContract.GameState mPlayingState;
  private MineSweeperContract.GameState mLostState;
  private MineSweeperContract.GameState mWinState;

  private MineSweeperContract.Board mBoard;

  PresenterImpl(){}

  @Override
  public void initGameBoard(int size, int numBombs) {
    mBoard = new MineSweeperContract.Board(size,numBombs);
    // Init states and start with playing state
    mPlayingState = new PlayingState(this);
    mLostState = new LostState(this);
    mWinState = new WonState(this);
    mState = mPlayingState;
    mView.notifyOnBoardChanged();
  }

  @Override
  public void setView(MineSweeperContract.View view) { mView = view; }

  @Override
  public void dropView() { mView = null; }

  @Override
  public void onClick(int x, int y) { mState.onClick(x,y); }

  @Override
  public void onFlag(int x, int y) { mState.onFlag(x,y); }

  @Override
  public MineSweeperContract.Board getGameBoard() { return mBoard; }

  @Override
  public void setGameBoard(MineSweeperContract.Board board) { this.mBoard = board; }

  @Override
  public void setState(MineSweeperContract.GameState gameState) { mState = gameState; }

  @Override
  public MineSweeperContract.GameState getLostState() { return mLostState; }

  @Override
  public MineSweeperContract.GameState getWonState() { return mWinState; }

  @Override
  public MineSweeperContract.GameState getPlayingState() { return mPlayingState; }
}
