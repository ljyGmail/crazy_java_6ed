package org.crazy.ch06_oop_2.sec10_sealed_classes;

public abstract sealed class A_Apple
    permits B_Gala, C_Macintosh, D_GrannySmith {

        public abstract void taste();
}
