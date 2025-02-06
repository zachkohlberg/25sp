public abstract class Pet {
  private String name;

  public Pet(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public abstract String getSound();

  public void speak() {
    System.out.println(getName() + " says " + getSound());
  }
}
