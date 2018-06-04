package com.andrewclam.minesweeper;

import com.andrewclam.minesweeper.MineSweeperContract;

public class LostState implements MineSweeperContract.GameState {
  private MineSweeperContract.Presenter mContext;
  LostState(MineSweeperContract.Presenter context){
    mContext = context;
  }

  @Override
  public void onClick(int x, int y) {
    // TODO reset the game
  }

  @Override
  public void onFlag(int x, int y) {
    // TODO reset the game
  }
}
