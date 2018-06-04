package com.andrewclam.minesweeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MineSweeperContract.View{
  private MineSweeperContract.Presenter mPresenter;

  @Override
  protected void onResume() {
    super.onResume();
    mPresenter.setView(this);
  }

  @Override
  protected void onPause() {
    super.onPause();
    mPresenter.dropView();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mPresenter = new PresenterImpl();
    mPresenter.initGameBoard(10,10);
  }

  @Override
  public void showUserLost() {
    Toast.makeText(this,"You lost!",Toast.LENGTH_LONG).show();
  }

  @Override
  public void showUserWon() {
    Toast.makeText(this,"You won, yay!.",Toast.LENGTH_LONG).show();
  }

  @Override
  public void notifyOnBoardChanged() {
    // TODO implement view adapter
  }
}
