package LeetCode100;

public class Father {
    public void test() {
        System.out.println("father");
    }

    static class Son1 extends Father {
        @Override
        public void test() {
            System.out.println("son1");
        }
    }

    static class Son2 extends Father {
        @Override
        public void test() {
            System.out.println("son2");
        }
    }

    static class TR{
        void test(Father father) {
            System.out.println("father");
        }

        void test(Son1 son1) {
            System.out.println("son1");
        }

        void test(Son2 son2) {
            System.out.println("son2");
        }
    }

    public static void main(String[] args) {
        Father a = new Father();
        Father b = new Son1();
        Father c = new Son2();
        new TR().test(a);
        new TR().test(b);
        new TR().test(c);

    }
}
