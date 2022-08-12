package hello.core.singleton;

public class SingletonService {
    // static 으로 만들어두었기 때문에 class level 로 올라가 딱 하나만 만들어 짐
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() { }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
