package jp.uphy.dsptn.strategy;
public class Duck {

  private QuackBehavior quackBehavior;
  private FlyBehavior flyBehavior;

  /**
   * {@link Duck}オブジェクトを構築します。
   */
  public Duck() {
    this(new MuteQuack(), new FlyNoway());
  }

  /**
   * {@link Duck}オブジェクトを構築します。
   * 
   * @param quackBehavior 鳴く振る舞い
   * @param flyBehavior 飛ぶ振る舞い
   */
  protected Duck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
    if (quackBehavior == null) throw new NullPointerException();
    if (flyBehavior == null) throw new NullPointerException();
    this.quackBehavior = quackBehavior;
    this.flyBehavior = flyBehavior;
  }

  public void display() {

  }

  public void swim() {

  }

  public void performQuack() {
    this.quackBehavior.quack();
  }

  public void performFly() {
    this.flyBehavior.fly();
  }

  protected void setQuackBehavior(QuackBehavior quackBehavior) {
    if (quackBehavior == null) throw new NullPointerException();
    this.quackBehavior = quackBehavior;
  }

  protected void setFlyBehavior(FlyBehavior flyBehavior) {
    if (flyBehavior == null) throw new NullPointerException();
    this.flyBehavior = flyBehavior;
  }

}
