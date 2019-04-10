package de.cherry.flang;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    Flang flang = new FlangFactory()
        .createFlang(
            Main.class.getResourceAsStream("/func.flang"));

    System.out.println(flang);
  }
}
