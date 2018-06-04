package com.andrewclam.minesweeper;

import com.andrewclam.minesweeper.MineSweeperContract;

public class WonState implements MineSweeperContract.GameState {
  private MineSweeperContract.Presenter mContext;

  WonState(MineSweeperContract.Presenter context){
    mContext = context;
  }

  @Override
  public void onClick(int x, int y) {
    // TODO Reset the game
  }

  @Override
  public void onFlag(int x, int y) {
    // TODO Reset the game
  }
}
