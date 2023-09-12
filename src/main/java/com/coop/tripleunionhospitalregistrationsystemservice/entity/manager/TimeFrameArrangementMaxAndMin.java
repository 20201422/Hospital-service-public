package com.coop.tripleunionhospitalregistrationsystemservice.entity.manager;

public class TimeFrameArrangementMaxAndMin {
  private int Max;
  private int Min;

  public TimeFrameArrangementMaxAndMin() {
  }
  public TimeFrameArrangementMaxAndMin(int max, int min) {
    Max = max;
    Min = min;
  }

  public int getMax() {
    return Max;
  }

  public void setMax(int max) {
    Max = max;
  }

  public int getMin() {
    return Min;
  }

  public void setMin(int min) {
    Min = min;
  }
}
