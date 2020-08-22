package com.company;

public class Computer extends Device {

    private String cpu;
    private String gpu;
    private String ram;

    public Computer(){
        super();
        setCpu("-");
        setGpu("-");
        setRam("-");
    }

    public Computer(String name, int price, String country, String cpu, String gpu, String ram){
        super(name, price, country);
        setCpu(cpu);
        setGpu(gpu);
        setRam(ram);
    }

    @Override
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    @Override
    public void setRam(String ram){
        this.ram = ram;
    }

    @Override
    public String getCpu() {
        return cpu;
    }

    @Override
    public String getGpu() {
        return gpu;
    }

    @Override
    public String getRam() {
        return ram;
    }
}
