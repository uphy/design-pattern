package jp.uphy.dsptn.strategy;
public class MallardDuck extends Duck {

  /**
   * {@link MallardDuck}オブジェクトを構築します。
   */
  public MallardDuck() {
    super(new HighFrequencyQuack(), new FlyWithWings());
  }

}
