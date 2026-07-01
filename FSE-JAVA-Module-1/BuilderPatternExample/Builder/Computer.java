package Builder;

public class Computer {
    private String cpu, ram, storage;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    @Override
    public String toString() {
        return "Product [cpu=" + cpu + ", ram=" + ram + ", storage=" + storage + "]";
    }

    public static class Builder {
        private String cpu, ram, storage;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

}
