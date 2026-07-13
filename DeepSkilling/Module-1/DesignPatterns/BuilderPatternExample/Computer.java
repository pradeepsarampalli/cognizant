public class Computer {
  private String cpu, ram, storage;

  private Computer(Builder b) {
    cpu = b.cpu;
    ram = b.ram;
    storage = b.storage;
  }

  public String toString() {
    return cpu + " " + ram + " " + storage;
  }

  public static class Builder {
    String cpu, ram, storage;

    public Builder cpu(String c) {
      cpu = c;
      return this;
    }

    public Builder ram(String r) {
      ram = r;
      return this;
    }

    public Builder storage(String s) {
      storage = s;
      return this;
    }

    public Computer build() {
      return new Computer(this);
    }
  }
}