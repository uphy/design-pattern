package jp.uphy.dsptn.strategy;
public class RubberDuck extends Duck {

  /**
   * {@link RubberDuck}オブジェクトを構築します。
   */
  public RubberDuck() {
    super(new HighFrequencyQuack(), new FlyNoway());
  }

}
