public class Q3 {
    static class Test{
        private
        int mark = 0;

        public
        Test() {
            // Default constructor
        }
        void setValue(int m){
            mark = m;
        }
        void showValue(){
            System.out.println("Mark: " + mark);
        }
    }    
    public static void main(String[] args) {
        Test t =  new Test();
        t.setValue(20);
        t.showValue();
        // t.mark = 89;
    }
}
