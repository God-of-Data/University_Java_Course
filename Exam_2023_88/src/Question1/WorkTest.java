package Question1;

public class WorkTest {

    public void work(TypeA param) throws Exception {

        param.action();
        param.actionA();

        if (param instanceof TypeB){

            ((TypeB) param).actionB();
        }
    }
}
